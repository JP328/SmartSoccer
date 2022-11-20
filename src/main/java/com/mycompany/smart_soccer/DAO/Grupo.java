package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grupo {

    public ArrayList listarGrupos() {
        ArrayList<String> listaDeGrupos = new ArrayList<>();
    
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sql = "SELECT * FROM tb_grupo;";
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()){
                int codigoGrupo = rs.getInt("cod_grupo");
                String nome = rs.getString("nome_grupo");
                String nomeFormatado = nome.substring(0,1).toUpperCase().concat(nome.substring(1));
                String aux = String.format(
                    "%s       Codigo do Grupo: %s",                
                    nomeFormatado,
                    codigoGrupo
                );
                listaDeGrupos.add(aux);
            }
            ps.close();
            return listaDeGrupos;           
        }
            catch (Exception e){
            e.printStackTrace();
        } 
        
        return null;

    }  

    public void cadastrarGrupo(String name){        
        String sqlComand = "INSERT INTO tb_grupo (nome_grupo) VALUES(?);";

        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);

            ps.setString(1, name);
            
            ps.execute();
            ps.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean VerificarGrupos(){
        String sqlComand = "SELECT count(cod_grupo) AS total_grupos FROM tb_grupo;";

        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int quantidade = rs.getInt("total_grupos");
            ps.close();
            
            if(quantidade>=8){
                JOptionPane.showMessageDialog(null, "Total máximo de grupos atingido!");
                return false;
            }
            else{
                return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean VerificarTimeGrupo (){
    
        String sqlComand = "SELECT id_grupo, count(cod_time) AS total_no_grupo FROM tb_time WHERE id_grupo = ? group by id_grupo;";
        
        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareCall(sqlComand);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int qntTime = rs.getInt("total_no_grupo");
            ps.close();
            
            if(qntTime == 4){
                return false; 
            }else{
                return true;
            }
          
            
        }
        catch(Exception e){
         e.printStackTrace();
        }
        return false;
        
    }
    
}

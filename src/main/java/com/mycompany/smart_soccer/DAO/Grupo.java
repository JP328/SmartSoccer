package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Grupo {

    public ArrayList listarGrupos(String retorno) {
        ArrayList<String> listaDeGruposExibicao = new ArrayList<>();
        ArrayList<Integer> listaDeGrupos = new ArrayList<>();
    
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sql = "SELECT * FROM tb_grupo ORDER BY nome_grupo;";
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            if (retorno.equals("exibir")) {
                while (rs.next()){
                    int codigoGrupo = rs.getInt("cod_grupo");
                    String nome = rs.getString("nome_grupo");
                    String nomeFormatado = nome.substring(0,1).toUpperCase().concat(nome.substring(1));
                    String aux = String.format(
                        "%s       Codigo do Grupo: %s",                
                        nomeFormatado,
                        codigoGrupo
                    );
                    listaDeGruposExibicao.add(aux);
                }
                ps.close();
                return listaDeGruposExibicao;           
            } else if (retorno.equals("listar")) {
                while (rs.next()){
                    int codigoGrupo = rs.getInt("cod_grupo");

                    listaDeGrupos.add(codigoGrupo);
                }
                ps.close();
                return listaDeGrupos;   
            }
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

    public boolean verificarGrupos(){
        String sqlComand = "SELECT count(cod_grupo) AS total_grupos FROM tb_grupo;";

        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int quantidade = rs.getInt("total_grupos");
            ps.close();
            
            if(quantidade>=8){
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
    
    public void limparGrupos (){
        String sqlComand = "TRUNCATE `projetoa3`.`tb_grupo`;";

        try (Connection connect = new ConnectionFactory().obtemConexao()) {
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ps.execute();        
            ps.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Grupo {

    public ArrayList listarGrupos() {
        ArrayList<String> listaDeGrupos = new ArrayList<>();
    
        //listaDeTimes.clear();
        //1: Definir o comando SQL
        //2: Abrir uma conexão
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
}

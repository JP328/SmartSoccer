package com.mycompany.smart_soccer;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import javax.swing.JOptionPane;


public class Administrador extends Usuario {
   
    public void cadastrarTime(String name, String classificacao, String group){        
        String sqlComand = "INSERT INTO tb_time (nome, classificacao, id_grupo) VALUES(?,?,?);";

        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);

            ps.setString(1, name);
            ps.setString(2, classificacao);
            ps.setString(3, group);

            ps.execute();
            ps.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
        }
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

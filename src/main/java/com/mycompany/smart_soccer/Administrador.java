/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_soccer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author joaop
 */
public class Administrador extends Usuario {
   
//    public void main (String[] args){
//        cadastrarTime("Alemanha", "Grupo A", "Fase de Grupos");
//    }
    
    public void cadastrarTime(String name, String group, String classificacao){        
        String sqlComand = "INSERT INTO tb_time (nome, grupo, classificacao) VALUES(?,?,?);";

        try{
            Connection connect = new ConnectionFactory().obtemConexao();
//            ConnectionFactory connectFac = new ConnectionFactory();
            PreparedStatement ps = connect.prepareStatement(sqlComand);

            ps.setString(1, name);
            ps.setString(2, group);
            ps.setString(3, classificacao);

            ps.execute();
            ps.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

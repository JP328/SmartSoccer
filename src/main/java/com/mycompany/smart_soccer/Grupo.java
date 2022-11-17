/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_soccer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author joaop
 */
public class Grupo {
    private ArrayList<String> listaDeGrupos = new ArrayList<>();

    public void listarGrupos() {
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

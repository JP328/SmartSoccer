/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joaop
 */
public class ValidarAdministrador {
        
    public Boolean validar(String usuario, String senha){
    
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sql = "SELECT usuario, senha FROM tb_administrador WHERE usuario = ? AND senha = ?;";

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            
            return rs.next();
        }
            catch (Exception e){
            e.printStackTrace();
        } 
        
        return false;
    } 
}

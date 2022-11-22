package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CadastroAutomatico {
    
    public void cadastroGrupoAutomatico (){  
        try{
            String sqlComand = "SELECT * FROM tb_grupo_oficial ORDER BY nome_grupo;";
            
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                        String nome = rs.getString("nome_grupo");
                        Grupo g = new Grupo();
                        g.cadastrarGrupo(nome);
            } 
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void cadastroTimeAutomatico (){  
        try{
            String sqlComand = "SELECT t.nome, t.classificacao, t.id_grupo FROM tb_time_oficial "
                + "t, tb_grupo_oficial g WHERE t.id_grupo = g.cod_grupo ORDER BY g.nome_grupo;";
            
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                        String nome = rs.getString("nome");
                        String grupo = rs.getString("id_grupo");
                        Time t = new Time();
                        t.cadastrarTime(nome,"Fase de Grupos", grupo);
            } 
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

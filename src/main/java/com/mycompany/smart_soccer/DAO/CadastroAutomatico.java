package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CadastroAutomatico {
    public void cadastroTimeAutomatico (){  
        String sqlComand = "SELECT t.cod_time, t.nome, t.classificacao, g.nome_grupo FROM tb_time_oficial t, tb_grupo g WHERE t.id_grupo = g.cod_grupo ;";
        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                        String nome = rs.getString("nome");
                        String grupo = rs.getString("nome_grupo");
                        Time t = new Time();
                        t.cadastrarTime(nome,"Fase de Grupos", grupo);
            } 
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

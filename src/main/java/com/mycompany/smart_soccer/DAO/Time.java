package com.mycompany.smart_soccer.DAO;

import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Time {

    public ArrayList listarTimes(){
    ArrayList<String> listaDeTimes = new ArrayList<>();
    
    //listaDeTimes.clear();
         //1: Definir o comando SQL
        //2: Abrir uma conexão
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sql = "SELECT t.cod_time, t.nome, g.nome_grupo FROM tb_time t, "
                    + "tb_grupo g WHERE t.id_grupo = g.cod_grupo;";
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()){
                String nome = rs.getString("nome");
                String grupo = rs.getString("nome_grupo");
                String grupoFormatado = grupo.substring(0,1).toUpperCase().concat(grupo.substring(1));
                String aux = String.format(
                    "%s       Time: %s",                
                    grupoFormatado,
                    nome
                );
                listaDeTimes.add(aux);
            }
            return listaDeTimes;           
        }
            catch (Exception e){
            e.printStackTrace();
        } 
        
        return null;
    } 
    
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
    
}

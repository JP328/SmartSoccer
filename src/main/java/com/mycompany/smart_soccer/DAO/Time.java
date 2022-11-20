package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Time {

    public ArrayList mostrarTimes(String retornoLista){
        ArrayList<String> listaDeTimesString = new ArrayList<>();
        ArrayList<ArrayList> listaDeTimesArray = new ArrayList<>();
    
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sql = "SELECT t.cod_time, t.nome, g.nome_grupo FROM tb_time t, "
                    + "tb_grupo g WHERE t.id_grupo = g.cod_grupo;";

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if ("String".equals(retornoLista)){
                while (rs.next()){
                    String nome = rs.getString("nome");
                    String grupo = rs.getString("nome_grupo");
                    String grupoFormatado = grupo.substring(0,1).toUpperCase().concat(grupo.substring(1));
                    String aux = String.format(
                        "%s       Time: %s",                
                        grupoFormatado,
                        nome
                    );
                    listaDeTimesString.add(aux);
                }
                return listaDeTimesString;
            } else if ("Array".equals(retornoLista)) {
                while (rs.next()){
                    ArrayList<String> atributosTime = new ArrayList<>();
                    int codigoTime = rs.getInt("cod_time");
                    String nome = rs.getString("nome");
                    String grupo = rs.getString("nome_grupo");
                    
                    atributosTime.add(Integer.toString(codigoTime));
                    atributosTime.add(nome);
                    atributosTime.add(grupo);
                    listaDeTimesArray.add(atributosTime);
                }
                return listaDeTimesArray;            
            }
            ps.close();
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
      
    public boolean verificarTime(){
        String sqlComand = "SELECT count(cod_time) AS total_times FROM tb_time";

        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareCall(sqlComand);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int quantidadeTime = rs.getInt("total_times");
            ps.close();
            
            if(quantidadeTime >= 32){
                return false;
            }else{
                return  true;
            }
            

        }catch(Exception e){
           e.printStackTrace();
        }
    
        return false;
    }
    
      public boolean verificarTimeGrupo (String codigo_grupo){
    
        String sqlComand = "SELECT id_grupo, count(cod_time) AS total_no_grupo FROM "
                + "tb_time WHERE id_grupo = ? group by id_grupo;";
        
        try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareCall(sqlComand);
            ps.setString(1, codigo_grupo);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int qntTime = rs.getInt("total_no_grupo");
                ps.close();

                if(qntTime >= 4){
                    System.out.println("False");
                    return false; 
                }else{
                    System.out.println("True");
                    return true;
                }
            } else {
                return true;
            }
        }
        catch(Exception e){
         e.printStackTrace();
        }
        return false;
        
    }
   
}

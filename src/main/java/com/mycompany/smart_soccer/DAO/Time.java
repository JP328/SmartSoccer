package com.mycompany.smart_soccer.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Time {

    public ArrayList mostrarTimes(){
        ArrayList<String> listaDeTimesString = new ArrayList<>();
    
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sql = "SELECT t.nome, t.classificacao FROM tb_time t, "
                    + "tb_grupo g WHERE t.id_grupo = g.cod_grupo;";

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
                     
            while (rs.next()){
                String nome = rs.getString("nome");
                String classificacao = rs.getString("classificacao");
                String aux = String.format(
                    "Time: %s     Classificacão: %s",                
                    nome,
                    classificacao
                );
                listaDeTimesString.add(aux);
            }
            ps.close();
            return listaDeTimesString;
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
    
    public boolean verificarTimeGrupo(String codigo_grupo){
    
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
                    return false; 
                }else{
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
   
    public ArrayList retornarTimesGrupo(String codigo_grupo, String classificacao) {
        ArrayList<ArrayList> timesDoGrupo = new ArrayList<>();
        
        try (Connection c = new ConnectionFactory().obtemConexao()){
            String sqlComandDefault = "SELECT cod_time, nome FROM tb_time WHERE id_grupo = ?;";
            String sqlComand = tipoClassificacaoSelect(classificacao);
            
            if (tipoClassificacaoSelect(classificacao).equals(sqlComandDefault)){
                PreparedStatement ps = c.prepareStatement(sqlComandDefault);
                ps.setString(1, codigo_grupo);
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    int codigo = rs.getInt("cod_time");
                    String nome = rs.getString("nome");

                    ArrayList<String> atributosTime = new ArrayList<>();

                    atributosTime.add(String.valueOf(codigo));
                    atributosTime.add(nome);
                    timesDoGrupo.add(atributosTime);
                }
                c.close();
                ps.close();
            } else {
                PreparedStatement ps = c.prepareStatement(sqlComand);
                ResultSet rs = ps.executeQuery();

                while (rs.next()){
                    int codigo = rs.getInt("cod_time");
                    String nome = rs.getString("nome");

                    ArrayList<String> atributosTime = new ArrayList<>();

                    atributosTime.add(String.valueOf(codigo));
                    atributosTime.add(nome);
                    timesDoGrupo.add(atributosTime);
                }
                c.close();
                ps.close();
            }
            return timesDoGrupo;            
        }
            catch (Exception e){
            e.printStackTrace();
        } 
        
        return null;
    }
    
    private String tipoClassificacaoSelect(String classificacao) {
        if (!"Fase de Grupos".equals(classificacao)){
            return "SELECT t.cod_time, t.nome FROM tb_time t, tb_grupo g WHERE t.id_grupo = "
                    + "g.cod_grupo AND t.classificacao = '" + classificacao + "' ORDER BY g.nome_grupo;";
        }
        return "SELECT cod_time, nome FROM tb_time WHERE id_grupo = ?;";
    }
    
    private String tipoClassificacaoUpdate(String classificacao){
        if(!"Fase de Grupos".equals(classificacao)) {
            return "UPDATE tb_time SET classificacao='" + classificacao +"' WHERE cod_time = ?;";
        }
        return "UPDATE tb_time SET classificacao='Fase de Grupos' WHERE cod_time = ?;";
    }
    
    public void atualizarClassificacao(String codigoTime, String classificacao){
        String sqlComand = tipoClassificacaoUpdate(classificacao);
        
          try{
            Connection connect = new ConnectionFactory().obtemConexao();
            PreparedStatement ps = connect.prepareStatement(sqlComand);

            ps.setString(1, codigoTime);

            ps.execute();
            ps.close();
            connect.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void limparTimes() {
        String sqlComand = "TRUNCATE `projetoa3`.`tb_time`;";

        try (Connection connect = new ConnectionFactory().obtemConexao()) {
            PreparedStatement ps = connect.prepareStatement(sqlComand);
            ps.execute();        
            ps.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

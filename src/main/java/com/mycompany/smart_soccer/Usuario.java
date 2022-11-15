package com.mycompany.smart_soccer;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//import javax.swing.JOptionPane;
/* @author joaop */
public class Usuario {
    private ArrayList<String> listaDeTimes = new ArrayList<>();
    private ArrayList<String> listaDeGrupos = new ArrayList<>();
    
    public void listarTimes(){
         //1: Definir o comando SQL
        String message = "Lista de Grupos:\n";
        String sql = "SELECT * FROM tb_time;";
        //2: Abrir uma conexão
        try (Connection c = new ConnectionFactory().obtemConexao()){
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            //4: Executa o comando e guarda
            //o resultado em um ResultSet
            ResultSet rs = ps.executeQuery();
            //5: itera sobre o resultado
            while (rs.next()){
                int codigo = rs.getInt("cod_time");
                String nome = rs.getString("nome");
                String grupo = rs.getString("grupo");
                String classificacao = rs.getString("classificacao");
                String aux = String.format(
                    "Código: %d, Nome: %s, Grupo: %s, Classificação: %s",
                    codigo,
                    nome,
                    grupo,
                    classificacao
                );
                listaDeTimes.add(aux);
            }
            for (String grupo : listaDeTimes) {
                message += grupo + "\n";
            }
            JOptionPane.showMessageDialog (null, message);
            listaDeTimes.clear();

        }
            catch (Exception e){
            e.printStackTrace();
        } 
     }    
    public void listarGrupos() {
        
//        listaDeGrupos.add("Grupo A");
//        listaDeGrupos.add("Grupo B");
//        listaDeGrupos.add("Grupo C");
//        listaDeGrupos.add("Grupo D");
//        listaDeGrupos.add("Grupo E");
//        listaDeGrupos.add("Grupo F");
//        listaDeGrupos.add("Grupo G");
//        listaDeGrupos.add("Grupo H");
//        
//        String message = "Lista de Grupos:\n";
//        for (String grupo : listaDeGrupos) {
//            message += grupo + "\n";
//        }
//        JOptionPane.showMessageDialog(null, message);

    }  
}

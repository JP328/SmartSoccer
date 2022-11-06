package com.mycompany.smart_soccer;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author joaop
 */
public class Usuario {
    private ArrayList<String> listaDeTimes = new ArrayList<String>();
    private ArrayList<String> listaDeGrupos = new ArrayList<String>();
    
    public void mostrarTimesCadastrados() {
        listaDeTimes.add("Brasil");
        listaDeTimes.add("Sérvia");
        listaDeTimes.add("Suiça");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");
        listaDeTimes.add("Camarões");

        String message = "Lista de Times:\n";
        for (String time: listaDeTimes) {
            message += time + "     ";
        }
        JOptionPane.showMessageDialog(null, message);

    }
    
    public void mostrarGruposCadastrados() {
        listaDeGrupos.add("Grupo A");
        listaDeGrupos.add("Grupo B");
        listaDeGrupos.add("Grupo C");
        listaDeGrupos.add("Grupo D");
        listaDeGrupos.add("Grupo E");
        listaDeGrupos.add("Grupo F");
        listaDeGrupos.add("Grupo G");
        listaDeGrupos.add("Grupo H");
        
        String message = "Lista de Grupos:\n";
        for (String grupo : listaDeGrupos) {
            message += grupo + "\n";
        }
        JOptionPane.showMessageDialog(null, message);

    }

    
}

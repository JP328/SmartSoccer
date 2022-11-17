package com.mycompany.smart_soccer;

import javax.swing.JOptionPane;

public class Copa {

    public static void main(String[] args) {
        String time1 = "Flamengo";
        String time2 = "Vasco";
        Jogo jogo = new Jogo();

        String resultado = jogo.simularJogo(time1, time2);

        JOptionPane.showMessageDialog(null, resultado);
    }
//    public void SimularPartida() {
//        String time1 = "Flamengo";
//        String time2 = "Vasco";
//
//        Jogo.simularJogo(time1, time2);
//    }
}

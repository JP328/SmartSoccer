package com.mycompany.smart_soccer;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Copa {
      ArrayList<String> listaDeTimes = new ArrayList<>();
     
      ArrayList<String> Resultados = new ArrayList<>();

    public static void SimularCopa(String[] args) {
        //As Strings simulam os objetos times com todas as informações do time e do seu grupo
        String time1 = "Flamengo";
        String time2 = "Vasco";

        Jogo jogo = new Jogo();

        String resultado = jogo.simularJogo(time1, time2);

        JOptionPane.showMessageDialog(null, resultado);
    }
    
    

    public  ArrayList<String> FaseDeGrupos( ArrayList<String> listaDeTimes,   ArrayList<String> Resultados ) {
      Jogo jogo = new Jogo();

      int time1 = 0;
      int time2 = 0;
      int time3 = 0;
      int time4 = 0;
      
      int[] timesMaisVitorias = new int[4];
      ArrayList<String> vencedoresFaseDeGrupo = new ArrayList<>();

      for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
          Resultados.add( jogo.simularJogo(listaDeTimes.get(i), listaDeTimes.get(j)) );          
       }
      }  

      for(String time : Resultados){
        if(time == listaDeTimes.get(0)){
          time1++;
        }
        if(time == listaDeTimes.get(1)){
          time2++;
        }
        if(time == listaDeTimes.get(2)){
          time3++;
        }
        if(time == listaDeTimes.get(3)){
          time4++;
        }
      }

      timesMaisVitorias[0] = time1;
      timesMaisVitorias[1] = time2;
      timesMaisVitorias[2] = time3;
      timesMaisVitorias[3] = time4;
      Arrays.sort(timesMaisVitorias);

      if( time1 == timesMaisVitorias[0] || time1 == timesMaisVitorias[1] ){
        vencedoresFaseDeGrupo.add(listaDeTimes.get(0));
      }
      if( time2 == timesMaisVitorias[0] || time2 == timesMaisVitorias[1] ){
        vencedoresFaseDeGrupo.add(listaDeTimes.get(1));
      }
      if( time3 == timesMaisVitorias[0] || time3 == timesMaisVitorias[1] ){
        vencedoresFaseDeGrupo.add(listaDeTimes.get(2));
      }
      if( time4 == timesMaisVitorias[0] || time1 == timesMaisVitorias[1] ){
        vencedoresFaseDeGrupo.add(listaDeTimes.get(3));
      }

      return vencedoresFaseDeGrupo;
    } 

   
    //Na fase de grupos, cada seleção joga três vezes, e a melhor passa de fase
    //
}  

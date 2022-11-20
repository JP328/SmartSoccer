package com.mycompany.smart_soccer;

import com.mycompany.smart_soccer.DAO.Time;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Copa {
  // ArrayList<String> listaDeTimes = new ArrayList<>();
  // Um array de arrays é bacicamente uma lista de listas
  // Exemplo: [[time, grupo], [time, grupo], [time, grupo]]
  Time t = new Time();
  ArrayList<ArrayList> listaDeTimes = t.mostrarTimes("Array");

  public static void SimularCopa(String[] args) {
    // As Strings simulam os objetos times com todas as informações do time e do seu
    // grupo
    // String time1 = "Flamengo";
    // String time2 = "Vasco";

    // Jogo jogo = new Jogo();

    // String resultado = jogo.simularJogo(time1, time2);

    // JOptionPane.showMessageDialog(null, resultado);

  }

  public ArrayList<String> FaseDeGrupos(ArrayList<String> listaDeTimes) {
    Jogo jogo = new Jogo();

    ArrayList<String> Resultados = new ArrayList<>();

    Resultados.add(jogo.simularJogo(listaDeTimes.get(0), listaDeTimes.get(1)));
    Resultados.add(jogo.simularJogo(listaDeTimes.get(0), listaDeTimes.get(2)));
    Resultados.add(jogo.simularJogo(listaDeTimes.get(0), listaDeTimes.get(3)));
    Resultados.add(jogo.simularJogo(listaDeTimes.get(1), listaDeTimes.get(2)));
    Resultados.add(jogo.simularJogo(listaDeTimes.get(1), listaDeTimes.get(3)));
    Resultados.add(jogo.simularJogo(listaDeTimes.get(2), listaDeTimes.get(3)));

    int time1 = 0;
    int time2 = 0;
    int time3 = 0;
    int time4 = 0;

    for (String time : Resultados) {
      if (time == listaDeTimes.get(0)) {
        time1++;
      }
      if (time == listaDeTimes.get(1)) {
        time2++;
      }
      if (time == listaDeTimes.get(2)) {
        time3++;
      }
      if (time == listaDeTimes.get(3)) {
        time4++;
      }
    }

    int[] timesMaisVitorias = new int[4];

    timesMaisVitorias[0] = time1;
    timesMaisVitorias[1] = time2;
    timesMaisVitorias[2] = time3;
    timesMaisVitorias[3] = time4;
    Arrays.sort(timesMaisVitorias);

    ArrayList<String> vencedoresFaseDeGrupo = new ArrayList<>();

    if (time1 == timesMaisVitorias[0] || time1 == timesMaisVitorias[1]) {
      vencedoresFaseDeGrupo.add(listaDeTimes.get(0));
    }
    if (time2 == timesMaisVitorias[0] || time2 == timesMaisVitorias[1]) {
      vencedoresFaseDeGrupo.add(listaDeTimes.get(1));
    }
    if (time3 == timesMaisVitorias[0] || time3 == timesMaisVitorias[1]) {
      vencedoresFaseDeGrupo.add(listaDeTimes.get(2));
    }
    if (time4 == timesMaisVitorias[0] || time1 == timesMaisVitorias[1]) {
      vencedoresFaseDeGrupo.add(listaDeTimes.get(3));
    }

    return vencedoresFaseDeGrupo;
  }

//  public ArrayList<String>  OitavasDeFinal("VencedoresGrupo1","VencedoresGrupo2") {
//
//    Jogo jogo = new Jogo();
//    ArrayList<String> vencedoresOitavasDeFinal = new ArrayList<>();
//
//    vencedoresOitavasDeFinal.add(jogo.simularJogo(VencedoresGrupo1.get(0), VencedoresGrupo2.get(1)));
//    vencedoresOitavasDeFinal.add(jogo.simularJogo(VencedoresGrupo1.get(1), VencedoresGrupo2.get(0)));
//
//    return vencedoresOitavasDeFinal;
//  }
//
//  public ArrayList<String> QuartasDeFinal("VencedoresOitavas1","VencedoresOitavas2") {
//
//    Jogo jogo = new Jogo();
//    ArrayList<String> VencedoresQuartasDeFinal = new ArrayList<>();
//
//    VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresOitavas1.get(0), VencedoresOitavas2.get(1)));
//    VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresOitavas1.get(1), VencedoresOitavas2.get(0)));
//
//    return VencedoresQuartasDeFinal;
//  }
//
//  public ArrayList<String> SemiFinal("VencedoresQuartas1","VencedoresQuartas2") {
//    Jogo jogo = new Jogo();
//    ArrayList<String> VencedoresSemiFinal = new ArrayList<>();
//
//    VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresQuartas1.get(0), VencedoresQuartas2.get(1)));
//    VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresQuartas1.get(1), VencedoresQuartas2.get(0)));
//
//    return VencedoresSemiFinal;
//  }
  

  // Na fase de grupos, cada seleção joga três vezes, e a melhor passa de fase
  //
}


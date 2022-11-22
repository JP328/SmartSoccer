package com.mycompany.smart_soccer;

import com.mycompany.smart_soccer.DAO.Grupo;
import com.mycompany.smart_soccer.DAO.Time;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Copa {

  public void SimularCopa() {
    faseDeGrupos();
    oitavasDeFinal();
  }

  private void faseDeGrupos() {
    Jogo jogo = new Jogo();
    Time t = new Time();
    Grupo g = new Grupo();

    for (int i = 0; i <= 7; i++) {
      String grupo = String.valueOf(g.listarGrupos("listar").get(i));

      ArrayList<String> resultados = new ArrayList<>();
      ArrayList<ArrayList> timesDoGrupo = t.retornarTimesGrupo(grupo, "Fase de Grupos");

      resultados.add(jogo.simularJogo(timesDoGrupo.get(0), timesDoGrupo.get(1)));
      resultados.add(jogo.simularJogo(timesDoGrupo.get(0), timesDoGrupo.get(2)));
      resultados.add(jogo.simularJogo(timesDoGrupo.get(0), timesDoGrupo.get(3)));
      resultados.add(jogo.simularJogo(timesDoGrupo.get(1), timesDoGrupo.get(2)));
      resultados.add(jogo.simularJogo(timesDoGrupo.get(1), timesDoGrupo.get(3)));
      resultados.add(jogo.simularJogo(timesDoGrupo.get(2), timesDoGrupo.get(3)));

      ArrayList<String> classificados = new ArrayList<>();
      for (int j = 0; j <= 3; j++) {
        String timeReferencia = String.valueOf(timesDoGrupo.get(j).get(0));
        int contador = 0;

        for (String time : resultados) {
          if (time.equals(timeReferencia)) {
            contador++;
          }
        }
        if (contador >= 2) {
          String codTimeReferencia = String.valueOf(timesDoGrupo.get(j).get(0));
          classificados.add(codTimeReferencia);
        }
      }

      if (classificados.toArray().length == 2) {
        t.atualizarClassificacao(classificados.get(0), "Oitavas de Final");
        t.atualizarClassificacao(classificados.get(1), "Oitavas de Final");
      } else {
        i--;
      }
    }
  }

  private void oitavasDeFinal() {
    Jogo jogo = new Jogo();
    Time t = new Time();

    ArrayList<ArrayList> timesOitavas = t.retornarTimesGrupo("0", "Oitavas de Final");

    for (int i = 0; i <= 15; i ++) {
      
        
        int adversario = i+2;

        String resultado = jogo.simularJogo(timesOitavas.get(i), timesOitavas.get(adversario));

        t.atualizarClassificacao(resultado, "Quartas de Final");

      if(adversario%2 != 0){
        i += 2;
      }
    }
  }

  //
  // public ArrayList<String>
  // QuartasDeFinal("VencedoresOitavas1","VencedoresOitavas2") {
  //
  // Jogo jogo = new Jogo();
  // ArrayList<String> VencedoresQuartasDeFinal = new ArrayList<>();
  //
  // VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresOitavas1.get(0),
  // VencedoresOitavas2.get(1)));
  // VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresOitavas1.get(1),
  // VencedoresOitavas2.get(0)));
  //
  // return VencedoresQuartasDeFinal;
  // }
  //
  // public ArrayList<String> SemiFinal("VencedoresQuartas1","VencedoresQuartas2")
  // {
  // Jogo jogo = new Jogo();
  // ArrayList<String> VencedoresSemiFinal = new ArrayList<>();
  //
  // VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresQuartas1.get(0),
  // VencedoresQuartas2.get(1)));
  // VencedoresQuartasDeFinal.add(jogo.simularJogo(VencedoresQuartas1.get(1),
  // VencedoresQuartas2.get(0)));
  //
  // return VencedoresSemiFinal;
  // }

  // Na fase de grupos, cada seleção joga três vezes, e a melhor passa de fase
  //
}

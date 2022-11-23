package com.mycompany.smart_soccer;

import com.mycompany.smart_soccer.DAO.Grupo;
import com.mycompany.smart_soccer.DAO.Time;
import java.util.ArrayList;

public class Copa {

  public void SimularCopa() {
    faseDeGrupos();
    oitavasDeFinal();
    quartasDeFinal();
    finalDaCopa();
    
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
  
    private void quartasDeFinal() {
    Jogo jogo = new Jogo();
    Time t = new Time();

    ArrayList<ArrayList> timesOitavas = t.retornarTimesGrupo("0", "Quartas de Final");

    for (int i = 0; i <= 7; i ++) {
      
        
        int adversario = i+2;

        String resultado = jogo.simularJogo(timesOitavas.get(i), timesOitavas.get(adversario));

        t.atualizarClassificacao(resultado, "Semi-Final");

      if(adversario%2 != 0){
        i += 2;
      }
    }
  }

    private void finalDaCopa() {
        Jogo jogo = new Jogo();
        Time t = new Time();

        ArrayList<ArrayList> timesQuartas = t.retornarTimesGrupo("0", "Semi-Final");

        for (int i = 0; i <= 3; i += 2) {
            String resultado = jogo.simularJogo(timesQuartas.get(i), timesQuartas.get(i+1));
            t.atualizarClassificacao(resultado, "Final");
        }
        
        ArrayList<ArrayList> timesSemiFinal = t.retornarTimesGrupo("0", "Final");       
        String resultado = jogo.simularJogo(timesSemiFinal.get(0), timesSemiFinal.get(1));
        t.atualizarClassificacao(resultado, "Vencedor Da Copa do Mundo");
    }
}

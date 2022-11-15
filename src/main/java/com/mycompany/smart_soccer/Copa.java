package com.mycompany.smart_soccer;

public class Copa {

  /**
   *
   */
  Jogo jogo = new Jogo();

  public void SimularPartida() {
    String time1 = "Flamengo";
    String time2 = "Vasco";

    Jogo.simularJogo(time1, time2);

  }
}

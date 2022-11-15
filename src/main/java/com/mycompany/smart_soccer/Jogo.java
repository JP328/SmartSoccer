package com.mycompany.smart_soccer;

import java.util.Random;

public class Jogo {

  public static String simularJogo(String time1, String time2) {

    Random rd = new Random();

    int golTime1 = 0;
    int golTime2 = 0;

    while (golTime1 == golTime2) {
      golTime1 = rd.nextInt(3) + 1;
      golTime2 = rd.nextInt(3) + 1;

      if (golTime1 != golTime2) {
        break;
      }
    }

    System.out.println("O resultado da partida foi: " + golTime1 + ":" + golTime2);

    if (golTime1 > golTime2) {
      System.out.println(time1 + " venceu");
      return time1;
    } else {
      System.out.println(time2 + " venceu");
      return time2;
    }
  }

}

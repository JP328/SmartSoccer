package com.mycompany.smart_soccer;

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
   
  public String simularJogo(ArrayList<String> time1, ArrayList<String> time2) {

    Random rd = new Random();

    int golTime1 = 0;
    int golTime2 = 0;

    while (golTime1 == golTime2) {
      golTime1 = rd.nextInt(4);
      golTime2 = rd.nextInt(4);

      if (golTime1 != golTime2) {
        break;
      }
    }

    System.out.println("O resultado da partida foi: " + golTime1 + ":" + golTime2);

    if (golTime1 > golTime2) {
      System.out.println(time1.get(1) + " venceu");
      return String.valueOf(time1.get(0));
    } else {
      System.out.println(time2.get(1) + " venceu");
      return String.valueOf(time2.get(0));
    }
  }

}

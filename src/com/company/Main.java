package com.company;

import com.company.RollingDicePlayMode.MultiPlayerMode;
import com.company.RollingDicePlayMode.SinglePlayerMode;

public class Main {

    public static void main(String[] args) {
	// write your code here
     PlayerService playerService = new PlayerService(new SinglePlayerMode());
     // PlayerService playerService1 = new PlayerService(new MultiPlayerMode());

      //playerService.play();
      playerService.play();


    }


}



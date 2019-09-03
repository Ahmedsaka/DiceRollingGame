package com.company.RollingDicePlayMode;

import com.company.Player;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class SinglePlayerMode implements PlayMode {
    Class<? extends Collections> k;
    Random random = new Random();
    Scanner scan = new Scanner(System.in);

    @Override
    public Player createPlayer() {
        Player player = new Player();

        System.out.println("Enter your name here: ");
        player.setName(scan.next());

        System.out.println("Enter your age here: ");
        player.setAge(scan.nextInt());

        System.out.println("Enter your gender here(M/F): ");
        player.setGender(scan.next());

        return player;
    }

    String playerName = createPlayer().getName();

    @Override
    public int[] play(){
        return rollResult();
    }

    public int[] rollResult() {
        int[] rolled = new int[2];
        rolled[0] = dieFace[random.nextInt(dieFace.length)];
        rolled[1] = dieFace[random.nextInt(dieFace.length)];
        if ((rolled[0] == rolled[1]) && (rolled[0] == 6)) {
            System.out.println("Hurray " + playerName + ", you won!\nyou rolled a double " + rolled[0]);
        } else {
            System.out.println("You rolled " + rolled[0] + " & " + rolled[1] + ", do you want to try again?[1/0]");
            int x = scan.nextInt();
            if (x == 1){
                return rollResult();
            }
            System.out.println("End");
        }
        return rolled;
    }
}

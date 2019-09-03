package com.company.RollingDicePlayMode;

import com.company.Player;

import java.util.*;

public class MultiPlayerMode implements PlayMode {
    private ArrayList<Player> players = new ArrayList<>();
    private int num_of_players;//Number of players to play the game.........
    private int counter = 0;


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

    private final ArrayList playerList(){
        System.out.println("How many players: ");
        num_of_players = scan.nextInt();

        for (int i = 0; i < num_of_players; ++i){
            players.add(createPlayer());
        }
        return players;
    }

    @Override
    public int[] play(){
        playerList();
        rollResult();
        return dieFace;
    }

    @Override
    public int[] rollResult(){
        int[] rolled = new int[2];
        rolled[0] = dieFace[random.nextInt(dieFace.length)];
        rolled[1] = dieFace[random.nextInt(dieFace.length)];
        if (counter < players.size()) {
            if ((rolled[0] == rolled[1]) && (rolled[0] == 6)) {
                System.out.println("Hurray " + players.get(counter).getName()+" won!\nyou rolled a double " + rolled[0]);
                System.exit(1);
            }
            else {
                System.out.println(players.get(counter).getName()+" rolled " + rolled[0] + " & " + rolled[1]);
                System.out.println("\nnext is "+ players.get(counter).getName());
                System.out.println("Input 1 and hit enter to play");
                int next = scan.nextInt();
                if (next == 1){
                    if ((counter == players.size() - 1)){
                        counter = 0;
                        rollResult();
                    }
                    else {
                        counter++;
                        rollResult();
                    }
                }
            }
        }
        return rolled;
    }
}

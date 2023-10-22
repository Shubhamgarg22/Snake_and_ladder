package com.snakeLadder;

import com.snakeLadder.model.Game;
import com.snakeLadder.model.Player;

import java.util.Scanner;

public class SnakeLadderApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board Size");
        int boardSize = scanner.nextInt();
        System.out.println("Enter number Of Player");
        int numberOfPlayer = scanner.nextInt();
        System.out.println("Enter number of Snakes");
        int numberOfSnakes = scanner.nextInt();
        System.out.println("Enter Board Ladders");
        int numberOfLadders = scanner.nextInt();

        Game game = new Game(numberOfLadders , numberOfSnakes , boardSize);

        for(int i=0; i<numberOfPlayer ;i++){
            System.out.println("Enter player name");
            String pName = scanner.next();
            Player player = new Player(pName);
            game.addPlayer(player);
        }
        game.playGame();
    }
}

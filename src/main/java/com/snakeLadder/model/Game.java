package com.snakeLadder.model;

import org.apache.commons.lang3.RandomUtils;

import java.util.*;

public class Game {
    private int numberOfSankes;
    private int numberOfLadders;

    Queue<Player>players;
    List<Snake>snakes;
    List<Ladder>ladders;

    private Board board;
    private Dice dice;

    public Game(int numberOfLadders , int numberOfSankes , int boardSize){
        this.numberOfSankes = numberOfSankes;
        this.numberOfLadders = numberOfLadders;
        this.players = new ArrayDeque<>();
        snakes = new ArrayList<>(numberOfSankes);
        ladders = new ArrayList<>(numberOfLadders);
        board = new Board(boardSize);
        dice = new Dice(1 , 6 , 2);
        initBoard();
    }
    private void initBoard(){
        Set<String>slSet = new HashSet<>();
        for(int i=0;i<numberOfSankes;i++){
            while (true){
                int snakeStart = RandomUtils.nextInt(board.getStart() , board.getSize());
                int snakeEnd = RandomUtils.nextInt(board.getStart() , board.getSize());
                if(snakeStart<= snakeEnd){continue;}
                String StartEndPair = String.valueOf(snakeStart) + snakeEnd;
                if(!slSet.contains(StartEndPair)){
                    Snake snake = new Snake(snakeStart , snakeEnd);
                    snakes.add(snake);
                    slSet.add(StartEndPair);
                    break;
                }
            }
        }
        for(int i=0;i<numberOfLadders;i++){
            while (true){
                int ladderStart = RandomUtils.nextInt(board.getStart() , board.getSize());
                int ladderEnd = RandomUtils.nextInt(board.getStart() , board.getSize());
                if(ladderStart>= ladderEnd){continue;}
                String StartEndPair = String.valueOf(ladderStart) + ladderEnd;
                if(!slSet.contains(StartEndPair)){
                    Ladder ladder= new Ladder(ladderStart ,ladderEnd);
                    ladders.add(ladder);
                    slSet.add(StartEndPair);
                    break;
                }
            }
        }
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void playGame(){
        while(true){
            Player player = players.poll();
            int val = dice.roll();
            int newPosition = player.getPosition()+val;
            if(newPosition > board.getEnd()){
                player.setPosition(player.getPosition());
                players.offer(player);
            }
            else{
                player.setPosition(getNewPosition(newPosition));
                if(player.getPosition() == board.getEnd()){
                    player.setWon(true);
                    System.out.println("Player " + player.getName() + " Won ");
                }
                else{
                    System.out.println("Setting " + player.getName() + "'s new position to " + player.getPosition());
                    players.offer(player);
                }
            }
            if(players.size()<2){break;}
        }
    }
    private int getNewPosition(int newPosition){
        for(Snake snake: snakes){
            if(snake.getHead()==newPosition){
                System.out.println("Snake bit");
                return snake.getTail();
            }
        }
        for(Ladder ladder: ladders){
            if(ladder.getStart() == newPosition){
                System.out.println("Climbed ladder");
                return ladder.getEnd();
            }
        }
        return newPosition;
    }


}

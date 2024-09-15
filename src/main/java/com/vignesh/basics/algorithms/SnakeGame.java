package com.vignesh.basics.algorithms;

import java.util.*;

public class SnakeGame {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine()) {
                int games = Integer.valueOf(scan.nextLine());
                for (int i = 0; i < games; i++) {
                    String line = scan.nextLine();
                    String[] vals = line.split(" ", 2);
                    char[] moves = vals[1].toCharArray();
                    Game g = new Game();
                    String resp = g.play(moves);
                    System.out.println(resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Game {
    int x = 0, y = 0;
    int di = 0;
    char[] directions = new char[]{'N', 'W', 'S', 'E'};
    int direction = directions[di];

    public String play(char[] moves) {
        Deque<String> deque = new ArrayDeque();
        deque.add(position(x, y));
        String resp = "YES";
        for (int i = 0; i < moves.length; i++) {
            String current = "";
            switch (moves[i]) {
                case 'F':
                    deque.pollLast();
                    break;
                case 'L':
                    deque.pollLast();
                    di++;
                    direction = directions[di % 4];
                    move();
                    break;
                case 'R':
                    deque.pollLast();
                    di--;
                    direction = directions[di % 4];
                    move();
                    break;
            }
            move();
            current = position(x, y);
            if(deque.contains(current)) {
                return String.valueOf(i+1);
            }
            deque.offer(current);
        }
        return resp;
    }

    private String position(int x, int y) {
        return x + "," + y;
    }

    private void move() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'W':
                x--;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
        }
    }
}

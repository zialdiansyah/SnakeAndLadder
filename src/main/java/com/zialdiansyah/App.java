package com.zialdiansyah;

import java.util.Scanner;

import com.zialdiansyah.Services.Game;
import com.zialdiansyah.Services.Player;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        int[] cells = new int[101];
        int totalSnakes = sc.nextInt();
        for (int i = 0; i < totalSnakes; i++)
            cells[sc.nextInt()] = sc.nextInt();

        int totalLadders = sc.nextInt();
        for (int i = 0; i < totalLadders; i++)
            cells[sc.nextInt()] = sc.nextInt();

        int totalPlayers = sc.nextInt();
        Player[] players = new Player[totalPlayers];
        for (int i = 0; i < totalPlayers; i++)
            players[i] = new Player(sc.next());

        Game game = new Game(cells, totalPlayers, players);
        game.startGame();

        sc.close();
    }
}

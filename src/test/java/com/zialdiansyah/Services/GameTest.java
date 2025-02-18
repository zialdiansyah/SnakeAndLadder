package com.zialdiansyah.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    
    private Game game;
    private Player[] players;
    private int[] cells;
    private static final int TOTAL_PLAYERS = 2;
    
    @BeforeEach
    void setUp() {
        cells = new int[101];
        // Add some snakes and ladders for testing
        cells[14] = 4;  // snake
        cells[20] = 38; // ladder
        
        players = new Player[] {
            new Player("Player1"),
            new Player("Player2")
        };
        
        game = new Game(cells, TOTAL_PLAYERS, players);
    }
    
    @Test
    void setPlayersShouldReturnCorrectPlayer() {
        Player player = game.setPlayers(0, players);
        
        assertEquals("Player1", player.getName(), "Should return correct player for given turn");
    }
    
    @Test
    void movePlayerPositionShouldUpdatePosition() {
        Player player = players[0];
        int initialPosition = player.getPosition();
        int steps = 3;
        
        game.movePlayerPosition(player, steps);
        
        assertEquals(initialPosition + steps, player.getPosition(), 
            "Player position should be updated by the number of steps");
    }
    
    @Test
    void movePlayerPositionShouldHandleSnake() {
        Player player = players[0];
        player.setPosition(12); // Position with snake
        
        game.movePlayerPosition(player, 2); // Move to trigger snake
        
        assertEquals(4, player.getPosition(), "Player should move down");
    }
    
    @Test
    void movePlayerPositionShouldHandleLadder() {
        Player player = players[0];
        player.setPosition(16); // Position with ladder
        
        game.movePlayerPosition(player, 4); // Move to trigger ladder
        
        assertEquals(38, player.getPosition(), "Player should move up");
    }
    
    @Test
    void playerShouldNotMoveAbove100() {
        Player player = players[0];
        player.setPosition(98);
        
        game.movePlayerPosition(player, 4); // Try to move beyond 100
        
        assertEquals(98, player.getPosition(), 
            "Player should not move if final position would exceed 100");
    }
}

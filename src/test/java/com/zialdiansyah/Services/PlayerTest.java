package com.zialdiansyah.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    
    private Player player;
    private static final String TEST_NAME = "TestPlayer";
    
    @BeforeEach
    void setUp() {
        player = new Player(TEST_NAME);
    }
    
    @Test
    void constructorShouldInitializePlayerCorrectly() {
        assertEquals(TEST_NAME, player.getName(), "Player name should be initialized correctly");
        assertEquals(0, player.getPosition(), "Player initial position should be 0");
    }
    
    @Test
    void setNameShouldUpdatePlayerName() {
        String newName = "NewPlayer";
        
        player.setName(newName);
        
        assertEquals(newName, player.getName(), "Player name should be updated");
    }
    
    @Test
    void setPositionShouldUpdatePlayerPosition() {
        int newPosition = 5;
        
        player.setPosition(newPosition);
        
        assertEquals(newPosition, player.getPosition(), "Player position should be updated");
    }
}

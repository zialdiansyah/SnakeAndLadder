package com.zialdiansyah.Services;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    
    @RepeatedTest(10)
    void rollShouldReturnNumberBetweenOneAndSix() {
        int result = Dice.roll();
        assertTrue(result >= 1 && result <= 6, 
            "Dice roll should return a number between 1 and 6, but got: " + result);
    }
}

package com.neutrinosys.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach
    void setUp() {
        game = new GuessingGame();
    }

    @Test
    public void testSimpleWinSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum);
        assertEquals("You got it in 1 try", message);
    }

    @Test
    public  void testOneWrongNegGuessSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(-5);
        assertEquals("You didn't get it - you're too low", message);
    }

    @Test
    public void testOneWrongPosGuessSituation() {
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1);
        assertEquals("You didn't get it - you're too high", message);
    }

   @Test
    public void testRandomNumBerGeneration() {
        // 1 2 3 4 5 6 7 8 9 10
        // 1 1 0 1 1 0 1 1 1 1  =10
       int[] rdnNumCount = new int[11];
       for (int counter=0; counter < 100; counter++) {
           GuessingGame game = new GuessingGame();
           int randomNum = game.getRandomNumber();
           rdnNumCount[randomNum] = 1;
       }

       int sum = 0;
       for (int counter=0; counter < 11; counter++) {
           sum = sum + rdnNumCount[counter];
       }
       System.out.println(sum);
       assertEquals(10, sum);
   }

   @Test
    public void testFourWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("You didn't get it and you've had four times", message);
   }

    @Test
    public void testThreeWrongAndOneCorrect() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        int correctAnswer = game.getRandomNumber();
        String message = game.guess(correctAnswer);
        assertEquals("You got it in 4 tries", message);
    }

    @Test
    public void testFiveWrongGuesses() {
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        game.guess(-3);
        String message = game.guess(-3);
        assertEquals("Sorry. You are limited to only 4 tries. Your game is over", message);
    }

}

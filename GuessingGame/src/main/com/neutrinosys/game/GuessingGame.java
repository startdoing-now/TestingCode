package com.neutrinosys.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1;
    private int counter = 0;
    public String guess(int guessedNumber) {
        counter++;
        String response = null;
        if (counter == 4 && guessedNumber != getRandomNumber()) {
            response = "You didn't get it and you've had four times";
        } else if (counter > 4) {
            response = "Sorry. You are limited to only 4 tries. Your game is over";
        }
        else {
            String lowHighText = null;
            if (guessedNumber < getRandomNumber()) {
                lowHighText = "- you're too low";
            } else if (guessedNumber > getRandomNumber()) {
                lowHighText = "- you're too high";
            }
            else {
                lowHighText = "";
            }
            String tryText = counter == 1 ? "try" : "tries";
            String winningMsg = String.format("You got it in %d %s", counter, tryText);
            String loseText = String.format("You didn't get it %s", lowHighText).trim();
            response = guessedNumber == getRandomNumber() ? winningMsg : loseText;

        }
        return response;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        boolean loopShouldContinue = true;
        do {
            String input = System.console().readLine("Enter a number: ");
            if ("q".equals(input))
                return;
            String output = game.guess(Integer.parseInt(input));
            System.out.println(output);
            if (output.contains("you got it") || output.contains("over")) {
                loopShouldContinue = false;
            }
        } while (loopShouldContinue == true);

    }
}

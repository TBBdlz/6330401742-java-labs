/*
  GuessNumberGameV3 is an updated version of GuessNumberGameV2
  Version 3 update:
    1.Version 3 has configGame() method which allows player to setting the game
    2.playGame() method update: after player win or run out of tries.
        The game will ask player to play again or leave game.
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 15 January 2021
*/
package yingyongwatthanakit.metee.lab3;

import java.util.Scanner;
import java.lang.Math;

public class GuessNumberGameV3 {
    static int correctNum;
    static int minNum = 1, maxNum = 10;
    static int maxTries = 3;
    public static void main(String[] args) {
        configGame();
        getAnwser();
        playGames();
    }

    static void configGame() {
        Scanner config = new Scanner(System.in);
        System.out.print("Enter the min and the max values:");
        int value1 = config.nextInt();
        int value2 = config.nextInt();
        // determine which value is max or min
        if (value1 >= value2) {
            maxNum = value1;
            minNum = value2;
        } else {
            maxNum = value2;
            minNum = value1;
        }
        System.out.print("Enter the number of tries:");
        maxTries = config.nextInt();
    }

    static void getAnwser() {
        // correctNum is random number generate from Math.random() function
        correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
    }

    public static void playGames() {
        playGame();
        while (true) {
            Scanner opd = new Scanner(System.in);
            System.out.println("If you want to play again? type 'y' to continue or 'q' to quit:");
            String command = opd.next();
            String commandToLowerCase = command.toLowerCase();
            switch (commandToLowerCase) {
                case "y":
                    getAnwser();
                    playGames();
                case "q":
                    System.exit(1);
                default:
                    continue;
            }
        }
    }

    static void playGame() {
        boolean winStatus = false;
        for (int numTries = maxTries; numTries > 0; numTries--) {
            while (!winStatus) {
                Scanner scan = new Scanner(System.in);
                System.out.print("Please enter a guess (" + minNum + "-" + maxNum + "):");
                int guessNum = scan.nextInt();
                // tell the user if their input is out of range.
                if (guessNum < minNum || guessNum > maxNum) { 
                    System.out.println("The guess number must be in the range " + minNum + " and " + maxNum);
                } else if (guessNum == correctNum) {
                    System.out.println("Congratulations! That's correct");
                    winStatus = true;
                    break;
                } else if (guessNum > correctNum) {
                    System.out.println("Please type a lower number! Number of remaining tries " + (numTries - 1));
                    break;
                } else {
                    System.out.println("Please type a higher number! Number of remaining tries " + (numTries - 1));
                    break;
                }
            }
        }
    }
}
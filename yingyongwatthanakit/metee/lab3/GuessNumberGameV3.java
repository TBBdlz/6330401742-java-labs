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
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        configGame();
        getAnwser();
        playGame();
    }

    static void configGame() {
        Scanner scan = new Scanner(System.in);
        Boolean validity = false;
        while (!validity) {
            System.out.print("Enter the min and the max values:");
            String data = scan.nextLine();
            String[] numStr = data.split(" ");
            // input must contains 2 number
            if (numStr.length != 2) {
                System.out.println("Please enter 2 values for min and max values");
                continue;
            }
            int val1 = Integer.parseInt(numStr[0]);
            int val2 = Integer.parseInt(numStr[1]);
            // determine which value is max or min
            if (val1 > val2) {
                maxNum = val1;
                minNum = val2;
                validity = true;
            } else if (val2 > val1) {
                maxNum = val2;
                minNum = val1;
                validity = true;
            // if they're the same value tell player to input different number.
            } else {
                System.out.println("Input number must be different.");
            }
        }
        System.out.print("Enter the number of tries:");
        maxTries = scan.nextInt();
    }

    static void getAnwser() {
        // correctNum is random number generate from Math.random() function
        correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
    }

    static void playGame() {
        Boolean winStatus = false;
        for (int numTries = maxTries; numTries > 0; numTries--) {
            while (true) {
                System.out.print("Please enter a guess (" + minNum + "-" + maxNum + "):");
                int guessNum = scan.nextInt();
                // tell the user if their input is out of range.
                if (guessNum < minNum || guessNum > maxNum) { 
                    System.out.println("The guess number must be in the range " + minNum + " and " + maxNum);
                    continue;
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
            // Check wherever user is out of tries or win the game
            if ((numTries - 1) == 0 || winStatus) {
                System.out.print("If you want to play again? type 'y' to continue or 'q' to quit:");
                String command = scan.next();
                String commandToLowerCase = command.toLowerCase();
                if (commandToLowerCase.equals("y")) {
                    getAnwser();
                    playGame();
                } else if (commandToLowerCase.equals("q")) {   
                    scan.close();
                    System.exit(1);
                }
            }
        }
    }
}
/*
  GuessNumberGameV2 is an updated version of GuessNumberGame
  Version 2 has subroutine
    getAnswer()
    playGame()
  getAnswer() it gets random number from random function
  playGame() contains loop that let players play the game
  if player's number is not correct
  the program will tell hint to the player
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 15 January 2021
*/
package yingyongwatthanakit.metee.lab3;

import java.util.Scanner;
import java.lang.Math;

public class GuessNumberGameV2 {
    static int correctNum;
    static int minNum = 1, maxNum = 10;
    public static void main(String[] args) {
        getAnwser();
        playGame();
    }

    static void getAnwser() {
        // correctNUm is random number generate from Math.random() function
        correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));
    }
    
    static void playGame() {
        Scanner scan = new Scanner(System.in);
        for (int numTries = 3; numTries > 0; numTries--) {
            System.out.print("Please enter a guess (" + minNum + "-" + maxNum + "):");
            int guessNum = scan.nextInt();
            if (guessNum == correctNum) {
                System.out.println("Congratulations! That's correct");
                scan.close();
                System.exit(1);
            } else if (guessNum > correctNum) {
                System.out.println("Please type a lower number! Number of remaining tries " + (numTries - 1));
            } else {
                System.out.println("Please type a higher number! Number of remaining tries " + (numTries - 1));
            }
        }
    }
}
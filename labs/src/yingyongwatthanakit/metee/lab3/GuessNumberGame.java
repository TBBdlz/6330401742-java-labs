/*
  GuessNumberGame is a game
  The game let player guess the number, player has 3 tries
  correct number is generated from random function
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

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int minNum = 1, maxNum = 10, guessNum, correctNum;
        // answer is random number generate from Math.random() function
        correctNum = minNum + (int)(Math.random() * ((maxNum - minNum) + 1));

        // let player plays game until they run out of tries.
        for (int numTries=3; numTries>0; numTries--) {
            System.out.print("Please enter a guess (" + minNum + "-" + maxNum + "):");
            guessNum = scan.nextInt();
            if (guessNum == correctNum) {
                System.out.println("Congratulations! That's correct");
                System.exit(1);
            // if player isn't right print hint to player!
            } else if (guessNum > correctNum) {
                System.out.println("Please type a lower number! Number of remaining tries " + (numTries - 1));
            } else {
                System.out.println("Please type a higher number! Number of remaining tries " + (numTries - 1));
            }
        }
        scan.close();
    }
}

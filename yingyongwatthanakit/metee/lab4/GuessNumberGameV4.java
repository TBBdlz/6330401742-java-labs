/*
  GuessNumberGameV4 is an updated version of GuessNumberGameV3
  Quick reminder:
    Version 3 has configGame(), getAnswer() and playGame() methods
    and playgame() also ask player if they want to play again
  Version 4 update:
    1.add playGames() method which is recursive of playGame()
    and include ask-player lines of code.
    playGames() also ask user if they want to see guesses they've been played
    2.add showGuesses() and showSpecific() methods
    showGuesses() method print all guesses to the screen
    showSpecific() method print order of guess the player wants to see
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 22 January 2021
*/
package yingyongwatthanakit.metee.lab4;

import java.util.Scanner;

public class GuessNumberGameV4 {
    
    static int correctNum;
    static int minNum = 1, maxNum = 10;
    static int maxTries = 3;
    static int[] guesses;
    static int numGuesses = 0;
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
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public static void playGames() {
        playGame();
        while (true) {
            Scanner opd = new Scanner(System.in);
            System.out.println("If you want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see guess on a specific play.");
            String command = opd.next();
            String commandToLowerCase = command.toLowerCase();
            switch (commandToLowerCase) {
                case "y":
                    getAnwser();
                    playGames();
                case "q":
                    System.exit(1);
                case "a":
                    getAnwser();
                    showGuesses();
                    continue;
                case "g":
                    showSpecific();
                    continue;
                default:
                    continue;
            }
        }
    }

    public static void playGame() {
        numGuesses = 0;
        guesses = new int[maxTries];
        boolean winStatus = false;
        for (int numTries = maxTries; numTries > 0; numTries--) {
            Scanner scan = new Scanner(System.in);
            while (!winStatus) {
                System.out.print("Please enter a guess (" + minNum+ "-" + maxNum + "):");
                int guessNum = scan.nextInt();
                // tell the user if their input is out of range.
                if (guessNum < minNum || guessNum > maxNum) {
                    System.out.println("The guess number must be in the range " + minNum + " and " + maxNum);
                } else if (guessNum == correctNum) {
                    System.out.println("Congratulations! That's correct");
                    winStatus = true;
                    guesses[numGuesses] = guessNum;
                    numGuesses++;
                    break;
                } else if (guessNum > correctNum) {
                    System.out.println("Please type a lower number! Number of remaining tries " + (numTries - 1));
                    guesses[numGuesses] = guessNum;
                    numGuesses++;
                    break;
                } else {
                    System.out.println("Please type a higher number! Number of remaining tries " + (numTries - 1));
                    guesses[numGuesses] = guessNum;
                    numGuesses++;
                    break;
                }
            }
        }
    }

    public static void showGuesses() { // print all the guesses player have been played.
        String[] allGuess = new String[numGuesses];
            for (int i = 0; i < numGuesses; i++) {
                allGuess[i] = String.valueOf(guesses[i]);
            }
        String result = String.join(" ", allGuess);
        System.out.println(result);
    }

    public static void showSpecific() { // show order guess that player wants to see.
        Scanner show = new Scanner(System.in);
        System.out.println("The guess number must be in the range (1-" + numGuesses + ")");
        int indexp = show.nextInt();
        while (indexp < 1 || indexp > numGuesses) {
            Scanner kb = new Scanner(System.in);
            System.out.println("The guess number must be in the range (1-" + numGuesses + ")");
            indexp = kb.nextInt();
        }
        System.out.println("Guess number " + (indexp) + " is " + guesses[indexp - 1]);
    }
}
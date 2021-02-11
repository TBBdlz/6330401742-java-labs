/*
  GuessNumberGameVer3 inherited from GuessNumberGameVer2
  this class contains modify method and new methods
  GuessNumberGameVer3 has override version of playGames()
  playGames() will ask player 3 more quesion if they
  want to see average, minimum guess or maximum guess
  New methods: getMin(), getMax(), getAverage()
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 6 February 2021
*/
package yingyongwatthanakit.metee.lab5;

import java.util.Scanner;

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {

    public GuessNumberGameVer3() {
        super();
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public void playGames() {
        playGame();
        while (true) { // continuing ask player what player wants to do next
            Scanner opd = new Scanner(System.in);
            System.out.println("If you want to play again? type 'y' to continue or 'q' to quit:");
            System.out.println("Type 'a' to see all your guesses or 'g' to see guess on a specific play.");
            System.out.println("Type 'v' to see average or 'm' to see minimum or 'x' to see maximum of your guesses");
            String command = opd.next();
            String commandToLowerCase = command.toLowerCase();
            switch (commandToLowerCase) {
                case "y":
                    playGames();
                case "q":
                    System.exit(1);
                case "a":
                    showGuesses();
                    continue;
                case "g":
                    showSpecific(); // show guess number N to the player *N is in range 1-number of guesses
                    continue;
                case "v":
                    System.out.println("Average = " + guessAverage());
                    continue;
                case "m":
                    System.out.println("Min = " + guessMin());
                    continue;
                case "x":
                    System.out.println("Max = " + guessMax());
                    continue;
                default:
                    continue;
            }
        }
    }

    public double guessAverage() { // this method return average of guesses
        int sum = 0;
        double average;
        for (int i = 0; i < numGuesses; i++) {
            sum += guesses[i];
        }
        average = (double) sum / numGuesses;

        return average;
    }

    public int guessMin() { // this method return minimum guess that user had played
        int min = guesses[0];
        for (int i = 0; i < numGuesses; i++) {
            if (min >= guesses[i]) {
                min = guesses[i];
            }
        }

        return min;
    }

    public int guessMax() { // this method return maximum guess that user had played
        int max = guesses[0];
        for (int i = 0; i < numGuesses; i++) {
            if (max <= guesses[i]) {
                max = guesses[i];
            }
        }
        
        return max;
    }

}

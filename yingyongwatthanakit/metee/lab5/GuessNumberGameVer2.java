package yingyongwatthanakit.metee.lab5;

import java.util.Scanner;

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    protected int[] guesses;
    protected int numGuesses = 0;
    protected final int MAX_GUESSES = 20;
    
    public GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    public void playGames() { // play multiple games
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
                    getAnswer();
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

    @Override
    public void playGame() { // play only 1 game
        getAnswer();
        numGuesses = 0;
        boolean winStatus = false;
        for (int numTries = maxTries; numTries > 0; numTries--) {
            Scanner scan = new Scanner(System.in);
            while (!winStatus) {
                System.out.print("Please enter a guess (" + minNum + "-" + maxNum + "):");
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

    public void showGuesses() { // print all the guesses player have been played.
        String[] allGuess = new String[numGuesses];
        for (int i = 0; i < numGuesses; i++) {
            allGuess[i] = String.valueOf(guesses[i]);
        }
        String result = String.join(" ", allGuess);
        System.out.println(result);
    }

    public void showSpecific() { // show order guess that player wants to see.
        Scanner show = new Scanner(System.in);
        System.out.println("The guess number must be in the range (1-" + numGuesses + ")");
        int indexp = show.nextInt();
        while (indexp < 1 || indexp > numGuesses) { // if invalid input, tell user and let user type again.
            Scanner kb = new Scanner(System.in);
            System.out.println("The guess number must be in the range (1-" + numGuesses + ")");
            indexp = kb.nextInt();
        }
        System.out.println("Guess number " + indexp + " is " + guesses[indexp - 1]);
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

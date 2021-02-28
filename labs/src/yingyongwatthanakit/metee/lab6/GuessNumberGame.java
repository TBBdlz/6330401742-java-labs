package yingyongwatthanakit.metee.lab6;

import java.util.Scanner;

public class GuessNumberGame extends Game {

    protected int minNum;
    protected int maxNum;
    protected int correctNum;
    protected int maxTries;
    protected static int numOfGames = 0;

    public GuessNumberGame() {
        super("Guess Number Game",1);
        minNum = 1;
        maxNum = 10;
        maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public GuessNumberGame(int minNum, int maxNum) {
        super("Guess Number Game",1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public GuessNumberGame(int minNum, int maxNum, int maxTries) {
        gameName = "Guess Number Game";
        numOfPlayers = 1;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxTries() {
        return maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    @Override
    public String toString() {
        return "Game name : " + getGameName() +
                ", Number of players: " + getNumOfPlayers() +
                ", Min is " + getMinNum() + ", Max is " + getMaxNum() +
                ", Number of tries is " + getMaxTries();
    }

    @Override
    public void playGame() { // play GuessNumberGameVer1 through this method
        boolean winStatus = false;
        for (int numTries = maxTries; numTries > 0; numTries--) {
            Scanner scan = new Scanner(System.in);
            while (!winStatus) {
                System.out.print("Please enter a guess (" + minNum + "-" + maxNum + "):");
                int guessNum = scan.nextInt();
                if (guessNum < minNum || guessNum > maxNum) {  // tell the user if their input is out of range.
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

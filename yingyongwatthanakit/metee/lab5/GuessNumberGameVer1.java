package yingyongwatthanakit.metee.lab5;

import java.util.Scanner;

public class GuessNumberGameVer1 {
    protected int minNum;
    protected int maxNum;
    protected int correctNum;
    protected int maxTries;
    protected static int numOfGames = 0;

    public GuessNumberGameVer1() {
        this.minNum = 1;
        this.maxNum = 10;
        this.maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        numOfGames++;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMinNum() {
        return this.minNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    } 

    public int getMaxTries() {
        return this.maxTries;
    }

    public void playGame() {
        getAnswer();
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

    @Override
    public String toString() {
        return "GuessNumberGame with min number as " + String.valueOf(minNum)
                + " max number as " + String.valueOf(maxNum)
                + " max number of tries as " + String.valueOf(maxTries);
    }

    public static int getNumOfGames() {
        return numOfGames;
    }

    public void getAnswer() {
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

}

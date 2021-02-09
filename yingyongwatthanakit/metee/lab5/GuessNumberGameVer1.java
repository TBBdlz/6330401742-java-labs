/*
  GuessNumberGameVer1 is an OOP version of GuessNumberGame
  GuessNumberGameVer1 has 3 constructors
  1) GuessNumberGameVer1(), GuessNumberGameVer1(minNum, maxNum), 
  GuessNumberGameVer1(minNum, maxNum, maxTries)
  GuessNumberGameVer1 class contains variables and methods:
  list of variables: minNum, maxNum, correctNum, maxTries
  and class variable for numOfGames
  list of methods: setMinNum(), getMinNum(), setMaxNum(), getMaxNum()
  setMaxTries(), getMaxTries(), getNumOfGames()
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 6 February 2021
*/
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
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = 3;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numOfGames++;
    }

    public void setMinNum(int minNum) { // set minNum to some integer
        this.minNum = minNum;
    }

    public int getMinNum() { // method returns minNum
        return minNum;
    }

    public void setMaxNum(int maxNum) { // set maxNum to some integer
        this.maxNum = maxNum;
    }

    public int getMaxNum() { // method returns maxNum
        return maxNum;
    }

    public void setMaxTries(int maxTries) { // set maxTries to some integer
        this.maxTries = maxTries;
    } 

    public int getMaxTries() { // method return maxTries
        return maxTries;
    }

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

    @Override
    public String toString() { // toString return a string which use to System.out.print/println() method
        return "GuessNumberGame with min number as " + minNum
                + " max number as " + maxNum
                + " max number of tries as " + maxTries;
    }

    public static int getNumOfGames() { // this method return numOfGames
        return numOfGames;
    }

}

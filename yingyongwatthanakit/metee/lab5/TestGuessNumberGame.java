/*
  TestGuessNumberGame is a program mainly to test GuessNumberGame
  this program can test GuessNumberGameVer1/2/3
  class methods:
    testSetterGetterMethod() to test get/set() methods
    testConstructors() to test class constructors
    testPlayGames() to test GuessNumberGameVer2 and playGames() method
    testGuessNumberGameVer3() 
  ID: 633040174-2
  Sec: 2
  Date: 6 February 2021
*/
package yingyongwatthanakit.metee.lab5;

public class TestGuessNumberGame {
    public static void main(String[] args) { // you can remove comment to test GuessNumberGameVer1/2/3
        // testConstructors();
        // testSetterGetterMethod();
        // testPlayGames();
        testGuessNumberGameVer3();
    }

    public static void testSetterGetterMethod() {
        GuessNumberGameVer1 gng = new GuessNumberGameVer1();
        System.out.println("The first guess number game is");
        System.out.println(gng);
        System.out.println("Now, the number of game is " + GuessNumberGameVer1.getNumOfGames());
        GuessNumberGameVer1 gng2 = new GuessNumberGameVer1(5, 20);
        System.out.println("Creating another guess number game");
        System.out.println("Now, the number of game is " + GuessNumberGameVer1.getNumOfGames());

        gng.setMinNum(2);
        gng.setMaxNum(5);
        gng.setMaxTries(2);
        System.out.println("GuessNumberGame with new setting");
        System.out.println(gng);
        System.out.println("GuessNumberGame with getting method");
        System.out.println("Min num is " + gng.getMinNum() + ", max num is " + gng.getMaxNum() +
                            ", and max tries is " + gng.getMaxTries());
    }

    public static void testConstructors() {
        GuessNumberGameVer1 gng1 = new GuessNumberGameVer1();
        GuessNumberGameVer1 gng2 = new GuessNumberGameVer1(5, 10);
        GuessNumberGameVer1 gng3 = new GuessNumberGameVer1(10, 20, 5);
        System.out.println(gng1);
        gng1.playGame();
        System.out.println(gng2);
        gng2.playGame();
        System.out.println(gng3);
        gng3.playGame();
    }

    public static void testPlayGames() {
        GuessNumberGameVer2 gng = new GuessNumberGameVer2(5, 10, 4);
        gng.playGames();
    }

    public static void testGuessNumberGameVer3() {
        GuessNumberGameVer3 gng = new GuessNumberGameVer3(5, 10);
        gng.playGames();
    }

}
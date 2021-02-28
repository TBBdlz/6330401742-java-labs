/*
  DiceGame is a game that let player guess the outcome of dice
  if they guess "l" for low they can win
  if dice number is lower or equal to 3
  and if they guess "h" for high they can win
  if dice number is greater than 3
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 27 February 2021
*/
package yingyongwatthanakit.metee.lab6;

import java.util.Locale;

public class DiceGame extends Game {

    protected int diceRoll;
    protected String answer;
    protected int minNum = 1;
    protected int maxNum = 6;

    public DiceGame() {
        super("Dice game",1);
        diceRoll = minNum + (int) (Math.random() * maxNum);
        answer = "l";
    }

    public DiceGame(String answer) {
        super("Dice game",1);
        diceRoll = minNum + (int) (Math.random() * maxNum);
        this.answer = answer;
    }

    public int getDiceRoll() {
        return diceRoll;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public void playGame() {
        String winningText = "Congratulations! you win.";
        String losingText = "Sorry. you lose.";
        if ((diceRoll > 3 && answer.toLowerCase().equals("h"))) {
            System.out.println(winningText);
        } else if ((diceRoll <= 3 && answer.toLowerCase().equals("l"))) {
            System.out.println(winningText);
        } else {
            System.out.println(losingText);
        }
    }

    @Override
    public String toString() {
        return "Game name : " + gameName +
                ", Number of players : " + numOfPlayers +
                ", Dice roll : " + diceRoll +
                ", Player's guess " + answer;
    }

}

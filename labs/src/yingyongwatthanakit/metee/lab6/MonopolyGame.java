package yingyongwatthanakit.metee.lab6;

public class MonopolyGame extends DiceGame implements UseDice, HasRule, UseBoard {

    protected int[] cash;
    protected final int NUMBER_OF_DICE = 2;

    public MonopolyGame() {
        gameName = "Monopoly Game";
        numOfPlayers = 2;
        cash = new int[2];
        cash[0] = 1500;
        cash[1] = 1500;
    }

    public MonopolyGame(int numOfPlayers) {
        gameName = "Monopoly Game";
        this.numOfPlayers = numOfPlayers;
        cash = new int[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            cash[i] = 1500;
        }
    }

    public void setCash(int[] cash) {
        this.cash = cash;
    }

    public String getCash() {
        String[] cashStr = new String[numOfPlayers];
        for (int i = 0; i < numOfPlayers; i++) {
            cashStr[i] = String.valueOf(cash[i]);
        }
        return String.join(" ",cashStr);
    }

    @Override
    public void playGame() {
        System.out.println("Playing Monopoly Game");
    }

    @Override
    public String gameRules() {
        return "Do you want to get rich? Then let's play monopoly game!!!\n" +
                "Each player will row the dice and move by a number\n" +
                "Player can buy and upgrade their lands";
    }

    @Override
    public int rollDice() {
        diceRoll = 0;
        int numDice;
        for (int i = 0; i < NUMBER_OF_DICE; i++) {
            numDice = minNum + (int) (Math.random() * maxNum);
            diceRoll += numDice;
        }
        return diceRoll;
    }

    @Override
    public void setUpBoard() {
        System.out.println("Setting up monopoly board");
    }

    @Override
    public String toString() {
        return "Game name : " + gameName +
                "Number of players : " + numOfPlayers;
    }
}

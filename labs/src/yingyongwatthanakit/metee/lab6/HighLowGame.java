package yingyongwatthanakit.metee.lab6;

public class HighLowGame extends DiceGame implements UseDice, HasRule {

    protected int numOfDice;

    public HighLowGame() {
        super();
        this.gameName = "High-Low Game";
        numOfDice = 3;
        rollDice();
    }

    public HighLowGame(int numOfDice) {
        super();
        this.gameName = "High-Low Game";
        this.numOfDice = numOfDice;
        rollDice();
    }

    public HighLowGame(int numOfDice, String answer) {
        super(answer);
        this.numOfDice = numOfDice;
        this.gameName = "High-Low Game";
        rollDice();
    }

    public int getNumOfDice() {
        return numOfDice;
    }

    public void setNumOfDice(int numOfDice) {
        this.numOfDice = numOfDice;
    }

    @Override
    public void playGame() {
        String winingText = "Congratulations! you win.";
        String losingText = "Sorry. you lose.";
        int middle = (numOfDice * maxNum - numOfDice + minNum) / 2 + numOfDice - minNum;
        if (diceRoll > middle && answer.toLowerCase().equals("h")) {
            System.out.println(winingText);
        } else if (diceRoll <= middle && answer.toLowerCase().equals("l")) {
            System.out.println(winingText);
        } else {
            System.out.println(losingText);
        }
    }

    @Override
    public String gameRules() {
        return null;
    }

    @Override
    public int rollDice() {
        diceRoll = 0;
        int numDice;
        for (int i = 0; i < numOfDice; i++) {
            numDice = minNum + (int) (Math.random() * maxNum);
            diceRoll += numDice;
        }
        return diceRoll;
    }

    @Override
    public String toString() {
        return "Game name : " + gameName +
                ", Number of players : " + numOfPlayers +
                ", Dice roll : " + diceRoll +
                ", Player's guess : " + answer +
                ", Number of dice " + numOfDice;
    }
}

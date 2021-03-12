package yingyongwatthanakit.metee.lab7;

import yingyongwatthanakit.metee.lab6.DiceGame;
import yingyongwatthanakit.metee.lab6.HighLowGame;
import yingyongwatthanakit.metee.lab6.MonopolyGame;
import yingyongwatthanakit.metee.lab6.UseDice;

import java.util.ArrayList;

public class TestInterfaceAsType {

    public static int compareRollDice(DiceGame game1, DiceGame game2) {
        return Integer.compare(game1.getDiceRoll(), game2.getDiceRoll());
    }

    public static void main(String[] args) {
        ArrayList<UseDice> games = new ArrayList<UseDice>(0);
        games.add(new HighLowGame());
        games.add(new HighLowGame(3));
        games.add(new HighLowGame(4,"h"));
        games.add(new MonopolyGame());
        games.add(new MonopolyGame(3));

        for (int i = 0; i < games.size() - 1; i++) {
            DiceGame game1 = (DiceGame) games.get(i);
            DiceGame game2 = (DiceGame) games.get(i+1);
            if (compareRollDice(game1, game2) > 0) {
                System.out.printf("Game(%d):%d has dice roll greater than Game(%d):%d\n", i, game1.getDiceRoll()
                                                                                      , i+1, game2.getDiceRoll());
            } else if (compareRollDice(game1, game2) == 0) {
                System.out.printf("Game(%d):%d has dice roll equal to Game(%d):%d\n", i, game1.getDiceRoll()
                                                                                    , i+1, game2.getDiceRoll());
            } else {
                System.out.printf("Game(%d):%d has dice roll less than Game(%d):%d\n", i, game1.getDiceRoll()
                                                                                     , i+1, game2.getDiceRoll());
            }
            games.get(i).rollDice();
            System.out.printf("Game(%d): rollDice method returns %d\n", i, game1.getDiceRoll());
        }
    }

}

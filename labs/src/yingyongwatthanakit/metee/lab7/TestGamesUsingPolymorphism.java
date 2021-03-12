/*
  TestGamesUsingPolymorphism use
  polymorphism features in Java
  to print games and play games
  using arrayList and for loop
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 12 March 2021
*/
package yingyongwatthanakit.metee.lab7;

import yingyongwatthanakit.metee.lab6.DiceGame;
import yingyongwatthanakit.metee.lab6.Game;
import yingyongwatthanakit.metee.lab6.GuessNumberGame;
import java.util.ArrayList;

public class TestGamesUsingPolymorphism {

    public static void main(String[] args) {
        ArrayList<Game> games = new ArrayList<Game>(0);
        games.add(new DiceGame());
        games.add(new DiceGame("h"));
        games.add(new GuessNumberGame());
        games.add(new DiceGame("l"));
        games.add(new GuessNumberGame(1,6,1));
        for (Game game : games) {
            System.out.println(game);
            game.playGame();
        }
    }

}

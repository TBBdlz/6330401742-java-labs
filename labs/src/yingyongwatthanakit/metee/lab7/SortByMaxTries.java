/*
  SortByMaxTries implement Comparator interface
  which has
  @Override compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2)
  this method compare maxTries in descending order
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 12 March 2021
*/
package yingyongwatthanakit.metee.lab7;

import java.util.Comparator;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {

    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        return Integer.compare(game2.getMaxTries(), game1.getMaxTries());
    }

}

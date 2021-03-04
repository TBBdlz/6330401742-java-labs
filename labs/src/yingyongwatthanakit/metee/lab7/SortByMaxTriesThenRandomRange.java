package yingyongwatthanakit.metee.lab7;

import java.util.Comparator;

public class SortByMaxTriesThenRandomRange implements Comparator<GuessNumberGameVer4> {

    private static int range(GuessNumberGameVer4 game) {
        return game.getMaxNum() - game.getMinNum();
    }

    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        if (game1.getMaxTries() < game2.getMaxTries() && range(game1) < range(game2)) {
            return 2;
        } else if (game1.getMaxTries() < game2.getMaxTries() && range(game1) > range(game2)) {
            return 1;
        } else if (game1.getMaxTries() == game2.getMaxTries() && range(game1) == range(game2)) {
            return 0;
        } else if (game1.getMaxTries() > game2.getMaxTries() && range(game1) < range(game2)) {
            return -1;
        } else {
            return -2;
        }
    }

}

package yingyongwatthanakit.metee.lab7;

import java.util.Comparator;

public class SortByRange implements Comparator<GuessNumberGameVer4> {

    private static int range(GuessNumberGameVer4 game) {
        return game.getMaxNum() - game.getMinNum();
    }

    @Override
    public int compare(GuessNumberGameVer4 game1, GuessNumberGameVer4 game2) {
        return Integer.compare(range(game2), range(game1));
    }

}

package yingyongwatthanakit.metee.lab6;

public class TestGames2 {

    public static void main(String[] args) {
        HighLowGame game1 = new HighLowGame();
        System.out.println(game1);
        game1.playGame();
        HighLowGame game2 = new HighLowGame(3);
        System.out.println(game2);
        game2.playGame();
        HighLowGame game3 = new HighLowGame(4, "h");
        System.out.println(game3);
        game3.playGame();
        MonopolyGame game4 = new MonopolyGame();
        System.out.println(game4);
        MonopolyGame game5 = new MonopolyGame(3);
        System.out.println(game5);
        game5.setUpBoard();
        game5.playGame();
        System.out.println("roll dice " + game5.rollDice());
        System.out.println("show cash " + game5.getCash());
    }

}

/*
  Game is an abstract class
  This class has 2 constructors
  Game() and Game(String gameName, int nunOfPlayers)
  it has variables: gameName, NumOfPlayers
  And methods: setGameName(), getGameName()
  getNumOfPlayers(), setNumOfPlayers()
  @Override toString() method
  and abstract method playGame()
  Author: Metee Yingyongwatthanakit
  ID: 633040174-2
  Sec: 2
  Date: 27 February 2021
*/
package yingyongwatthanakit.metee.lab6;

public abstract class Game {

    protected String gameName;
    protected int numOfPlayers;

    public Game() {
        gameName = "Unknown game";
        numOfPlayers = 0;
    }

    public Game(String gameName, int numOfPlayers) {
        this.gameName = gameName;
        this.numOfPlayers = numOfPlayers;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
    
    @Override
    public String toString() {
        return "Game name : " + gameName +
                ", Number of player : " + numOfPlayers;
    }

    public abstract void playGame();

}
package net.app.entities;

import net.app.interfaces.IPlayer;

public class Player implements IPlayer {
    String name;
    Integer totalScore;

    public Player(String name) {
        //Done: initialize Player data
        this.name = name;
        this.totalScore = 0;
    }

    // Done: implement the propper interface
    @Override
    public String getName() {
        //Done: Auto-generated method stub
        return name;
    }

    @Override
    public int getTotalScore() {
        //Done: Auto-generated method stub
        return totalScore;
    }

    @Override
    public void incrementTotalScore() {
        //Done: Auto-generated method stub
        totalScore++;
    }

    @Override
    public void decrementTotalScore() {
        //Done: Auto-generated method stub
        totalScore--;
    }

}

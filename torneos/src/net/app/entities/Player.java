package net.app.entities;

import net.app.interfaces.IPlayer;

public class Player implements IPlayer {
    String name;
    Integer totalScore;

    public Player(String name, Integer totalScore) {
        //Done: initialize Player data
        this.name = name;
        this.totalScore = totalScore;
        
    }

    // Done: implement the propper interface
    @Override
    public String getName() {
        //Done Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getName'");
        return name;
    }

    @Override
    public int getTotalScore() {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getTotalScore'");
        return totalScore;
    }

    @Override
    public void incrementTotalScore() {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'incrementTotalScore'");
        totalScore += 1;
    }

    @Override
    public void decrementTotalScore() {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'decrementTotalScore'");
        totalScore -= 1;
    }

}

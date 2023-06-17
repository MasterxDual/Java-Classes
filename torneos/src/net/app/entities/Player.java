package net.app.entities;

import net.app.interfaces.IPlayer;

public class Player implements IPlayer {
    String name;
    Integer totalScore;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public void incrementTotalScore() {
        totalScore++;
    }

    @Override
    public void decrementTotalScore() {
        totalScore--;
    }

}

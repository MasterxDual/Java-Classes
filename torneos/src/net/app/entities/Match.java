package net.app.entities;

import java.util.HashMap;
import java.util.Map;

import net.app.entities.utilities.Status;
import net.app.exceptions.matchException.MatchException;
import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;

public class Match implements IMatch {
    private Status state;
    private IPlayer player1;
    private IPlayer player2;
    private Map<IPlayer, Integer> scores;

    public Match(IPlayer player1, IPlayer player2) {
        this.state = Status.INACTIVE;
        this.player1 = player1;
        this.player2 = player2;
        this.scores = new HashMap<>();
        this.scores.put(player1, 0);
        this.scores.put(player2, 0);
    }

    //Done: implement the propper interface
    @Override
    public IPlayer getPlayer1() {
        //Done: Auto-generated method stub
        return player1;
    }

    @Override
    public IPlayer getPlayer2() {
        //Done: Auto-generated method stub
        return player2;
    }

    @Override
    public Status getStatus() {
        //Done: Auto-generated method stub
        return state;
    }

    @Override
    public void setStatus(Status status) {
        //Done: Auto-generated method stub
        this.state = status;
    }

    @Override
    public Map<IPlayer, Integer> getScores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScores'");
    }

    @Override
    public void addScore(IPlayer player) throws MatchException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addScore'");
    }
    
}

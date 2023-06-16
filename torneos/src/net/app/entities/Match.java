package net.app.entities;

import java.util.HashMap;
import java.util.Map;

import net.app.entities.utilities.Status;
import net.app.exceptions.matchException.MatchException;
import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;

public class Match implements IMatch {
    private Status state;
    private Player player1;
    private Player player2;
    private Map<Player, Integer> scores;

    public Match(Status state, Player player1, Player player2, Map<Player, Integer> scores) {
        this.state = state;
        this.player1 = player1;
        this.player2 = player2;
        this.scores = new HashMap<>(scores);
        this.scores.put(player1, 0);
        this.scores.put(player2, 0);
    }

    //Done: implement the propper interface
    @Override
    public IPlayer getPlayer1() {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getPlayer1'");
        return player1;
    }

    @Override
    public IPlayer getPlayer2() {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getPlayer2'");
        return player2;
    }

    @Override
    public Status getStatus() {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
        return state;
    }

    @Override
    public void setStatus(Status status) {
        //Done: Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
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

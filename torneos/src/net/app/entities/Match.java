package net.app.entities;

import java.util.HashMap;
import java.util.Map;

import net.app.entities.utilities.Status;
import net.app.exceptions.matchException.MatchException;
import net.app.exceptions.matchException.MatchIsFinishedException;
import net.app.exceptions.matchException.MatchIsInactiveException;
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

    @Override
    public IPlayer getPlayer1() {
        return player1;
    }

    @Override
    public IPlayer getPlayer2() {
        return player2;
    }

    @Override
    public Status getStatus() {
        return state;
    }

    @Override
    public void setStatus(Status status) {
        this.state = status;
    }

    @Override
    public Map<IPlayer, Integer> getScores() {
        return scores;
    }

    @Override
    public void addScore(IPlayer player) throws MatchException {
        if(scores.containsKey(player) && (getStatus() == Status.ACTIVE)) {
            scores.put(player, 1);
        } else if(getStatus() == Status.FINISHED) {
            throw new MatchIsFinishedException(player1.getName(), player2.getName());
        } else if(getStatus() == Status.INACTIVE) {
            throw new MatchIsInactiveException(player1.getName(), player2.getName());
        }
    }

    @Override
    public String toString() {
        return "Estado:" + state + "\n"
        + player1 + scores.get(player1) + "-" + scores.get(player2) + player2 + "\n";
    }
}

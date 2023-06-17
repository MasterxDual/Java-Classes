package net.app.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.app.exceptions.PlayerExistsException;
import net.app.exceptions.PlayerIsOnAMatchException;
import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;
import net.app.interfaces.ITourney;

public class Tourney implements ITourney {
    Set<IPlayer> playersSet;
    String name;
    List<IMatch> matches;

    public Tourney(String name) {
        playersSet = new HashSet<>();
        matches = new LinkedList<>();
        this.name = name;
        // TODO: write this constructor
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addPlayer(IPlayer p) throws PlayerExistsException {
        if(playersSet.contains(p)) {
            throw new PlayerExistsException(p);
        } else {
            playersSet.add(p);
        }

    }

    @Override
    public Set<IPlayer> getPlayers() {
        return playersSet;
    }

    @Override
    public void removePlayer(IPlayer p) throws PlayerIsOnAMatchException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayer'");
    }

    @Override
    public void generateMatches() {
        List<IPlayer> list = new ArrayList<>(playersSet);
        for(int playerIndex=1; playerIndex<playersSet.size(); playerIndex+=2) {
            matches.add(new Match(list.get(playerIndex-1), list.get(playerIndex)));
        }
    }

    @Override
    public List<IMatch> getMatches() {
        return matches;
    }

    @Override
    public void switchPlayers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchPlayers'");
    }

    @Override
    public void switchPlayers(IPlayer p1, IPlayer p2) throws PlayerIsOnAMatchException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchPlayers'");
    }

    @Override
    public void printScheduling() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printScheduling'");
    }
}

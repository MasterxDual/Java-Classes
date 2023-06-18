package net.app.entities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.app.entities.utilities.Status;
import net.app.exceptions.PlayerExistsException;
import net.app.exceptions.PlayerIsOnAMatchException;
import net.app.exceptions.PlayerNotExistsException;
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
    public void removePlayer(IPlayer p) throws PlayerIsOnAMatchException, PlayerNotExistsException {
        if(playersSet.contains(p)) {
            for (IMatch match : matches) {
                if(match.getStatus() == Status.ACTIVE) {
                    throw new PlayerIsOnAMatchException(p, match);
                }
            }
            playersSet.remove(p);
        } else {
            throw new PlayerNotExistsException(p);
        }
    }

    @Override
    public void generateMatches() {
        Iterator<IPlayer> iterador = playersSet.iterator();
        while (iterador.hasNext()) {
            IPlayer playerTemp = iterador.next();
            if(iterador.hasNext()){
                matches.add(new Match(playerTemp, iterador.next()));
            }
        }
        /*Manera correcta pero ocupa mucho RAM porque copia una coleccion dentro de otra
        import java.util.ArrayList;
        List<IPlayer> list = new ArrayList<>(playersSet);
        for(int playerIndex=1; playerIndex<playersSet.size(); playerIndex+=2) {
            matches.add(new Match(list.get(playerIndex-1), list.get(playerIndex)));
        }
        
        Otra manera correcta pero no tan eficiente como la que dejé sin comentar
        int indice = 0;
        IPlayer playerTemp = null;
        for (IPlayer player : playersSet) {
            if (indice % 2 == 0) {
                playerTemp = player;
            } else {
                matches.add(new Match(playerTemp, player));
            }
            indice++;
        }
         */
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
        System.out.println(matches);
    }
}

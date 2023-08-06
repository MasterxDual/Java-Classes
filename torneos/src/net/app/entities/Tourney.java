package net.app.entities;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import net.app.entities.utilities.Status;
import net.app.exceptions.PlayerAlreadyPlayedException;
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
        Scanner scan = new Scanner(System.in);
        System.out.println("What players do you want to switch?");
        boolean searchingPlayer1 = true;
        boolean searchingPlayer2 = true;
        IPlayer pA = null;
        IPlayer pB = null;

        while(searchingPlayer1 || searchingPlayer2) {
            System.out.println("Player 1:");
            String player1 = scan.nextLine();
            System.out.println("Player 2:");            
            String player2 = scan.nextLine();
            // Busco si el nombre del player1 y el player 2 están en el set de jugadores
            for (IPlayer playerTemp : playersSet) {
                if(searchingPlayer1) {
                    searchingPlayer1 = !playerTemp.getName().equals(player1);
                    pA = playerTemp;
                }
                if(searchingPlayer2) {
                    searchingPlayer2 = !playerTemp.getName().equals(player2);
                    pB = playerTemp;
                }
            }
        }
        try {
            switchPlayers(pA, pB);
        } catch (PlayerIsOnAMatchException | PlayerAlreadyPlayedException e) {
            System.err.println(e.getMessage());
        }
        scan.close();
    }

    @Override
    public void switchPlayers(IPlayer p1, IPlayer p2) throws PlayerIsOnAMatchException, PlayerAlreadyPlayedException {
        List<IMatch> copyMatches = new LinkedList<>(matches);
        for (IMatch match : copyMatches) {
            replaceIfExists(match, p1, p2);
            replaceIfExists(match, p2, p1);
        }
    }

    private void replaceIfExists(IMatch match, IPlayer pA, IPlayer pB) throws PlayerIsOnAMatchException, PlayerAlreadyPlayedException {
            //Buscando pA en el player 1 del match y reemplazandolo por pB
            if(match.getPlayer1().getName().equals(pA.getName())) {
                if(match.getStatus() == Status.ACTIVE) {
                    throw new PlayerIsOnAMatchException(pA, match);    
                }
                if(match.getStatus() == Status.FINISHED) {
                    throw new PlayerAlreadyPlayedException(pA, match);
                }
                IPlayer contricante = match.getPlayer2();
                matches.remove(match);
                matches.add(new Match(pB, contricante));
            }
            //Buscando pA en el player 2 del match y reemplazandolo por pB
            if(match.getPlayer2().getName().equals(pA.getName())) {
                if(match.getStatus() == Status.ACTIVE) {
                    throw new PlayerIsOnAMatchException(pA, match);    
                }
                if(match.getStatus() == Status.FINISHED) {
                    throw new PlayerAlreadyPlayedException(pA, match);
                }
                IPlayer contricante = match.getPlayer1();
                matches.remove(match);
                matches.add(new Match(contricante, pB));
          }
    }

    @Override
    public void printScheduling() {
        for (IMatch match : matches) {
            System.out.println(match.toString());
        }
    }

}

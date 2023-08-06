package net.app;

import net.app.entities.Player;
import net.app.entities.Tourney;
import net.app.entities.utilities.Status;
import net.app.exceptions.PlayerAlreadyPlayedException;
import net.app.exceptions.PlayerExistsException;
import net.app.exceptions.PlayerIsOnAMatchException;
import net.app.exceptions.matchException.MatchException;
import net.app.interfaces.IMatch;

/**
 * Torneos
 */
public class Tourneys {
    public static void main(String[] args) throws PlayerExistsException, PlayerIsOnAMatchException, PlayerAlreadyPlayedException {
        Player player1 = new Player("Agustin");
        Player player2 = new Player("Julio");
        Player player3 = new Player("Lucia");
        Player player4 = new Player("Abby");
        Player player5 = new Player("Agostina");
        Player player6 = new Player("Matias");
        
        Tourney torneo1 = new Tourney("Devastation");

        torneo1.addPlayer(player1);
        torneo1.addPlayer(player2);
        torneo1.addPlayer(player3);
        torneo1.addPlayer(player4);
        torneo1.addPlayer(player5);
        torneo1.addPlayer(player6);
        torneo1.generateMatches();
        System.out.println("First print");
        torneo1.printScheduling();
        torneo1.switchPlayers(player1, player6);
        System.out.println("Later:");
        torneo1.printScheduling();

        //Añadir puntaje a un match entre 2 jugadores que están en el torneo1 
        for (IMatch match: torneo1.getMatches()) {
                try {
                    match.setStatus(Status.ACTIVE);
                    match.addScore(player6);
                } catch (MatchException e) {
                    System.err.println(e.getMessage());
                }
        }
        System.out.println("Last Print");
        torneo1.printScheduling();
    }
}
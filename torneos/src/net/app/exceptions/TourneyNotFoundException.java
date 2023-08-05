package net.app.exceptions;

import net.app.interfaces.ITourney;

public class TourneyNotFoundException extends Exception {
    public TourneyNotFoundException(ITourney tourney) {
        super("El torneo " + tourney.getName() + " no fue encontrado.");
    }
}

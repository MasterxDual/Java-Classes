package net.app.exceptions;

import net.app.interfaces.ITourney;

public class TourneyExistsException extends Exception {
    public TourneyExistsException(ITourney tourney) {
        super("El torneo " + tourney.getName() + " ya existe.");
    }
}

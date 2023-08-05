package net.app.entities;

import java.util.ArrayList;
import java.util.List;

import net.app.exceptions.TourneyExistsException;
import net.app.exceptions.TourneyNotFoundException;
import net.app.interfaces.ITournamentManager;
import net.app.interfaces.ITourney;

public class TournamentManager implements ITournamentManager {
    private List<ITourney> tourneys;

    public TournamentManager() {
        tourneys = new ArrayList<>();
    }

    @Override
    public void addTourney(ITourney tourney) throws TourneyExistsException {
        if(tourneys.contains(tourney)) {
            throw new TourneyExistsException(tourney);
        } else {
            tourneys.add(tourney);
        }
    }

    @Override
    public void removeTourney(ITourney tourney) throws TourneyNotFoundException {
        if(tourneys.contains(tourney)) {
            tourneys.remove(tourney);
        } else {
            throw new TourneyNotFoundException(tourney);
        }
    }

    @Override
    public List<ITourney> getTourneys() {
        return tourneys;
    }
}

package net.app.entities;

import java.util.List;

import net.app.exceptions.TourneyExistsException;
import net.app.exceptions.TourneyNotFoundException;
import net.app.interfaces.ITournamentManager;
import net.app.interfaces.ITourney;

public class TournamentManager implements ITournamentManager {

    @Override
    public void addTourney(ITourney tourney) throws TourneyExistsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addTourney'");
    }

    @Override
    public void removeTourney(ITourney tourney) throws TourneyNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeTourney'");
    }

    @Override
    public List<ITourney> getTourneys() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTourneys'");
    }
}

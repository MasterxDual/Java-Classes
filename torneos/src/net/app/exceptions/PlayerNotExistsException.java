package net.app.exceptions;

import net.app.interfaces.IPlayer;

public class PlayerNotExistsException extends Exception {
    public PlayerNotExistsException(IPlayer player) {
        super("El jugador " + player + "no existe en el torneo.");
    }
}

package net.app.exceptions;

import net.app.interfaces.IPlayer;

public class PlayerExistsException extends Exception {
    public PlayerExistsException(IPlayer player) {
        super("El jugador " + player.getName() + " ya existe.");
    }
}

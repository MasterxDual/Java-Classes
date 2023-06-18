package net.app.exceptions;

import net.app.interfaces.IMatch;
import net.app.interfaces.IPlayer;

public class PlayerIsOnAMatchException extends Exception {
    public PlayerIsOnAMatchException(IPlayer player, IMatch match) {
        super("El jugador " + player.getName() + "está en el partido. " + match.toString());
    }
}

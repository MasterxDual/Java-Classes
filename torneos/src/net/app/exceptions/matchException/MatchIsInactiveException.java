package net.app.exceptions.matchException;

public class MatchIsInactiveException extends MatchException {
    public MatchIsInactiveException(String player1, String player2) {
        super("No se puede agregar puntaje al partido debido a que el jugador " + player1 + " y el jugador " + player2 + "todavía no comenzaron a jugar.");
    }
}

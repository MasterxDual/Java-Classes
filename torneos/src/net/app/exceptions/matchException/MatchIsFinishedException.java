package net.app.exceptions.matchException;

public class MatchIsFinishedException extends MatchException {
    public MatchIsFinishedException(String player1, String player2) {
        super("No se puede agregar puntaje al partido debido a que el jugador " + player1 + " y el jugador " + player2 + "ya terminaron de jugar.");
    }
}

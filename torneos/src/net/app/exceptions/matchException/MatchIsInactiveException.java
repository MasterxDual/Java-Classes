package net.app.exceptions.matchException;

public class MatchIsInactiveException extends MatchException {
    public MatchIsInactiveException(String player1, String player2) {
        super("El partido está inactivo");
    }
}

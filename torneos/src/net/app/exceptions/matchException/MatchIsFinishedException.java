package net.app.exceptions.matchException;

public class MatchIsFinishedException extends MatchException {
    public MatchIsFinishedException(String player1, String player2) {
        super("El partido ha finalizado");
    }
}

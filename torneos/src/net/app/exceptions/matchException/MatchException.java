package net.app.exceptions.matchException;

public abstract class MatchException extends Exception {
    protected MatchException(String msg) {
        super(msg);
    }
}

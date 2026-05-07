package hr.tvz.game.game.exception;

public class GamePersistingException extends RuntimeException {
    public GamePersistingException() {

    }
    public GamePersistingException(String message) {
        super(message);
    }
    public GamePersistingException(String message, Throwable cause) {
        super(message, cause);
    }
    public GamePersistingException(Throwable cause) {
        super(cause);
    }
    public GamePersistingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}


package by.bntu.fitr.exception;

public class InternalServerErrorException extends IllegalArgumentException {
    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}

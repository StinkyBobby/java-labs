package Exceptions;

public class TransportNotFoundException extends RuntimeException {
    public TransportNotFoundException(String message) {
        super(message);
    }
}

package com.yourname.transport;

public class TransportSystemException extends RuntimeException {

    public TransportSystemException(String message) {
        super(message);
    }

    public TransportSystemException(String message, Throwable cause) {
        super(message, cause);
    }

}

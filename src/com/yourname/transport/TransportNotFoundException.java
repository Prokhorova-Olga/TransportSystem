package com.yourname.transport;

public class TransportNotFoundException extends TransportSystemException {

    public TransportNotFoundException(String id) {
        super("Транспорт с ID '" + id + "' не найден");
    }
}

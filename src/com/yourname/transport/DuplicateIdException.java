package com.yourname.transport;

public class DuplicateIdException extends Exception {

    public DuplicateIdException(String id) {
        super("Транспорт с ID '" + id + "' уже существует в системе");
    }
}

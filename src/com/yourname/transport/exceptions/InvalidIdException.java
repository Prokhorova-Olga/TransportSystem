package com.yourname.transport.exceptions;

public class InvalidIdException extends ValidationException {

    public InvalidIdException (String id) {
        super("Некорректный ID: '" + id + "' ID не может быть пустым или null");
    }
}

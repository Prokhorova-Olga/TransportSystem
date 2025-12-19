package com.yourname.transport.exceptions;

public class InvalidColorException extends ValidationException {

    public InvalidColorException(String color) {
        super("Некорректный цвет: '" + color + "'. Цвет должен быть задан");
    }
}

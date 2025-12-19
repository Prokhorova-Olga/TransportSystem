package com.yourname.transport.exceptions;

public class InvalidEngineVolumeException extends ValidationException {

    public InvalidEngineVolumeException(double volume) {
        super("Некорректный объем двигателя: " + volume + ". Должен быть положительным числом.");

    }

    public InvalidEngineVolumeException(String message) {
        super(message);
    }
}

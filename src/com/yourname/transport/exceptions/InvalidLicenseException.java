package com.yourname.transport.exceptions;

public class InvalidLicenseException extends  ValidationException {

    public InvalidLicenseException(String license) {
        super("Некорректные водительские права: '" + license +
                "'.Должны соответствовать формату (например, 'AB123456').");

    }
}

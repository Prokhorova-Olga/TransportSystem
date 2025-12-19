package com.yourname.transport.validators;

import com.yourname.transport.Driver;
import com.yourname.transport.exceptions.InvalidLicenseException;
import com.yourname.transport.exceptions.ValidationException;

import java.util.regex.Pattern;

public class DriverValidator implements Validator<Driver> {

    private static final Pattern LICENSE_PATTERN = Pattern.compile("^[A-Z]{2}\\d{6}$");

    @Override
    public void validate(Driver driver) {
        if (driver == null) {
            throw new ValidationException("Driver не может быть null");
        }
        validateLicenseId(driver.getLicenseId());
        validateName(driver.getName());
    }

    private void validateLicenseId(String licenseId) {
        if (licenseId == null || licenseId.isBlank()) {
            throw new InvalidLicenseException(licenseId);
        }
        if (!LICENSE_PATTERN.matcher(licenseId).matches()) {
            throw new InvalidLicenseException(licenseId);
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidationException("Имя водителя не может быть пустым");
        }
        if (name.length() < 2) {
            throw new ValidationException("Имя водителя должно содержать минимум 2 символа");
        }
    }


}

package com.yourname.transport;

import com.yourname.transport.exceptions.ValidationException;
import com.yourname.transport.validators.DriverValidator;
import com.yourname.transport.validators.Validator;

import java.util.Objects;



public class Driver {
    public String licenseId;
    public String name;
    public static final Validator<Driver> VALIDATOR = new DriverValidator();

    public Driver(String licenseId, String name) {
        this.licenseId = licenseId;
        this.name = name;
        validate();
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getName() {
        return name;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
        validate();
    }

    public void setName(String name) {
        this.name = name;
        validate();

    }

    private void validate() {
        try {
            VALIDATOR.validate(this);
        } catch (ValidationException e) {
            System.err.println("Ошибка валидации водителя: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public String toString() {
        return name + " (права: " + licenseId + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(licenseId, driver.licenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseId);
    }
}

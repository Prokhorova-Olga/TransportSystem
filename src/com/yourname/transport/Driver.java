package com.yourname.transport;

import java.util.Objects;

public class Driver {
    public String licenseId;
    public String name;

    public Driver(String licenseId, String name) {
        this.licenseId = licenseId;
        this.name = name;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public String getName() {
        return name;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public void setName(String name) {
        this.name = name;
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

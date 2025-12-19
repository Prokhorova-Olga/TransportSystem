package com.yourname.transport;

import com.yourname.transport.validators.CarValidator;
import com.yourname.transport.validators.DriverValidator;
import com.yourname.transport.validators.Validator;



public class Car extends Vehicle implements Repairable {
    private int numberOfDoors;
    private String bodyType;
    private String complete;
    private double engineCapacity;
    private Driver driver;
    private static Validator<Car> carValidator;

    static {
        carValidator = new CarValidator(new DriverValidator());
    }

    public Car(String id, String type, String model, String color, String producerCountry,
               double engineVolume, int numberOfDoors, String bodyType,
               String complete, double engineCapacity, Driver driver) {
        super(id, type, model, producerCountry, color, engineVolume);
        this.numberOfDoors = numberOfDoors;
        this.bodyType = bodyType;
        this.complete = complete;
        this.engineCapacity = engineCapacity;
        this.driver = driver;
        validate();
    }

    private void validate() {
        if (carValidator != null) {
            carValidator.validate(this);
        }
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
        validate();
    }

    @Override
    public void repair() {
        System.out.printf("Автомобиль %s %s проходит ТО. Замена масла, диагностика двигателя %.1f л.%n"
        , model, bodyType, engineVolume);
    }

    @Override
    public void printRepairStatus() {
        System.out.println("Автомобиль записан на сервис.");
    }


    @Override
    public void move() {
        System.out.println("Автомобиль начал движение");
    }


    @Override
    public String getInfo() {
       String baseInfo = super.getInfo();
       String driverInfo = (driver != null ? ", Водитель: " + driver.getName() : "");
        return String.format("Автомобиль [%s]. %s, Цвет: %s, Двигатель: %.1f л., Кузов: %s",
                model, baseInfo, color, engineVolume, bodyType, driverInfo);
    }

    public void autoStarted() {
        System.out.println("Автозапуск включен");
    }

    public void setTheAlarm() {
        System.out.println("Сигнализация активирована");
        validate();

    }

    public void disableTheAlarmSystem() {
        System.out.println("Сигнализация отключена");

    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        validate();
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
        validate();
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
        validate();
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
        validate();
    }
}

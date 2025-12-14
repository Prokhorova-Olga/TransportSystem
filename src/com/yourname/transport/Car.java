package com.yourname.transport;

public class Car extends Vehicle implements Repairable {
    private int numberOfDoors;
    private String bodyType;
    private String complete;
    private double engineCapacity;

    public Car(String id, String type, String model, String color, String producerCountry,
               double engineVolume, int numberOfDoors, String bodyType,
               String complete, double engineCapacity) {
        super(id, type, model, producerCountry, color, engineVolume);
        this.numberOfDoors = numberOfDoors;
        this.bodyType = bodyType;
        this.complete = complete;
        this.engineCapacity = engineCapacity;
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
        return String.format("Автомобиль [%s]. %s, Цвет: %s, Двигатель: %.1f л., Кузов: %s",
                model, baseInfo, color, engineVolume, bodyType);
    }

    public void autoStarted() {
        System.out.println("Автозапуск включен");
    }

    public void setTheAlarm() {
        System.out.println("Сигнализация активирована");

    }

    public void disableTheAlarmSystem() {
        System.out.println("Сигнализация отключена");

    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
}

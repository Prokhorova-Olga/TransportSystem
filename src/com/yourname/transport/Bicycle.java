package com.yourname.transport;

public class Bicycle extends Transport implements Repairable {
    private String bicycleType;

    public Bicycle(String id, String type, String bicycleType) {
        super(id, type);
        this.bicycleType = bicycleType;
    }

    public String getBicycleType() {
        return bicycleType;
    }

    public void setBicycleType(String bicycleType) {
        this.bicycleType = bicycleType;
    }

    @Override
    public void repair() {
        System.out.printf("Велосипед типа '%s' настроен: подкачаны шины, смазана цепь.%n"
        , bicycleType);
    }

    @Override
    public void move() {
        System.out.println("Велосипед начал движение");
    }

    @Override
    public String getInfo() {
        String baseInfo = super.getInfo();
        return String.format("Велосипед. %s, Стиль: %s", baseInfo, bicycleType);
    }
}

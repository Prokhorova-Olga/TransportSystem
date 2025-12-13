package com.yourname.transport;

public class Bicycle extends Transport {
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
    public void move() {
        System.out.println("Велосипед начал движение");
    }

    @Override
    public String getInfo() {
        String baseInfo = super.getInfo();
        return String.format("Велосипедд. %s, Стиль: %s", baseInfo, bicycleType);
    }
}

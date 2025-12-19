package com.yourname.transport;

public abstract class Vehicle extends Transport {
     protected String model;
     protected String producerCountry;
     protected String color;
     protected double engineVolume;

    public Vehicle(String id, String type, String model, String producerCountry, String color, double engineVolume) {
        super(id, type);
        this.model = model;
        this.producerCountry = producerCountry;
        this.color = color;
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }



}

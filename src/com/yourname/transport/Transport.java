package com.yourname.transport;

public abstract class Transport {
    protected String id;
    protected  String type;

    public Transport(String id, String type) {
        this.type = type;
        this.id = id;
    }

    public String getInfo() {
        return "ID: " + id + ", Type: " + type;
    }

    public abstract void move();

}

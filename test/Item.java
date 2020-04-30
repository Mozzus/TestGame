package com.test;

public class Item {
    private String name;
    private int power;
    private boolean isOn;

    public void setOn(boolean on) {
        isOn = on;
    }

    public Item (String name, int power, boolean isOn) {
        this.name = name;
        this.power = power;
        this.isOn = isOn;
    }

    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }

    public boolean isON() {
        return isOn;
    }

}

package com.test.units;

public class Warrior extends Unit {

    public Warrior (String name) {
        setHealth(10);
        id.add((long)(Math.random()*1000000));
        this.name = name;
    }

    @Override
    public void hit(Unit unit) {
        if (!this.getId().equals(unit.getId()) && getHealth() > 0) {
            System.out.println(name + " ударяет " + unit.name);
            unit.setHealth(unit.getHealth()-2);
            defence(this, unit);
        }
        if (unit.getHealth() < 0) unit.setHealth(0);
    }

    @Override
    public int givingExp() {
        return 150;
    }
}

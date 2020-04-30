package com.test.units;


public class Archer extends Unit {

    public Archer (String name) {
        setHealth(7);
        id.add((long)(Math.random()*1000000));
        this.name = name;
    }

    @Override
    public void hit(Unit unit) {
        if (!this.getId().equals(unit.getId()) && getHealth() > 0) {
            System.out.println(name + " ударяет " + unit.name);
            unit.setHealth(unit.getHealth()-1);
            defence(this, unit);
        }
        if (unit.getHealth() < 0) unit.setHealth(0);
    }

    @Override
    public int givingExp() {
        return 120;
    }
}

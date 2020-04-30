package com.test.units;

public class Wolf extends Unit {

    public Wolf () {
        setHealth(4);
        id.add((long)(Math.random()*1000000));
        name = "Волк";

    }

    @Override
    public int givingExp() {
        return 70;
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
}

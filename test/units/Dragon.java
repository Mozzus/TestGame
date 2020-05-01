package com.test.units;

public class Dragon extends Unit {
    public Dragon () {
        setHealth(20);
        id.add((long)(Math.random()*1000000));
        name = "Дракон";
    }

    @Override
    public int givingExp() {
        return 300;
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

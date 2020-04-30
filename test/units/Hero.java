package com.test.units;

import com.test.Locations.Location;

import java.io.IOException;

public class Hero extends Unit {
    public static Location heroLocation;
    public static Location lastLocation;

    public Hero (String name) {
        this.name = name;
        setHealth(5);
        setMaxHealth(5);
        id.add((long) (Math.random() * 100000));
    }

    @Override
    public int givingExp() {
        return 150;
    }

    @Override
    public void hit(Unit unit) {
        if (!this.getId().equals(unit.getId()) && getHealth() > 0) {
            System.out.println(name + " ударяет " + unit.name);
            unit.setHealth(unit.getHealth()- (this.getPower() + (int)(Math.random()*2)));
            defence(this, unit);
        }
        if (unit.getHealth() < 0) unit.setHealth(0);
    }

    private void increaseLevel() {
        System.out.println("*-Повышение уровня-*");
        setLevel(getLevel() + 1);
        switch (this.getLevel()) {
            case 2 : defenceRate+=10; setPower(2); setMaxHealth(7);
                break;
            case 3 : defenceRate+=7; setPower(3); setMaxHealth(10);
                break;
            case 4 : defenceRate+=5; setPower(4); setMaxHealth(12);
                break;
        }
    }

    public void changeState () {
        if (getExperience() > 50 && getExperience() < 100 && getLevel() == 1) increaseLevel();
        else if (getExperience() >= 100 && getExperience() < 200 && getLevel() == 2) increaseLevel();
    }

    public Location getHeroLocation() throws IOException {
        return heroLocation.getLocation();
    }

    public static void toLastLocation () throws IOException {
        lastLocation.getLocation().toLocation();
    }

    public static void toPresentLocation () throws IOException {
        heroLocation.getLocation().toLocation();
    }
}

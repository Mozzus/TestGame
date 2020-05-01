package com.test.units;

import com.test.Game;
import com.test.Locations.Location;

import java.io.IOException;

import static com.test.Game.hero;

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
        hero.setLevel(hero.getLevel() + 1);
        switch (hero.getLevel()) {
            case 2 : hero.defenceRate+=10; hero.setPower(2); hero.setMaxHealth(7);
                break;
            case 3 : hero.defenceRate+=7; hero.setPower(3); hero.setMaxHealth(10);
                break;
            case 4 : hero.defenceRate+=5; hero.setPower(4); hero.setMaxHealth(12);
                break;
        }
    }

    public void changeState () {
        if (hero.getExperience() > 50 && hero.getExperience() < 100 && hero.getLevel() == 1) increaseLevel();
        else if (hero.getExperience() >= 100 && getExperience() < 200 && hero.getLevel() == 2) increaseLevel();
        else if (hero.getExperience() >= 200 && getExperience() < 350 && hero.getLevel() == 3) increaseLevel();
    }

    public Location getHeroLocation() {
        return heroLocation.getLocation();
    }

    public static void toLastLocation () throws IOException {
        lastLocation.getLocation().toLocation();
    }

    public static void toPresentLocation () throws IOException {
        heroLocation.getLocation().toLocation();
    }
}

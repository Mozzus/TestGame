package com.test.units;

import com.test.Combat;
import com.test.Game;

import java.util.HashSet;
import java.util.Set;

public abstract class Unit implements Combat {
    private int health;
    private int maxHealth;

    public String name;
    private int level = 1;
    private int experience = 0;
    Set<Long> id = new HashSet<>();
    private boolean isAlive = true;
    private int power = 1;

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int defenceRate = 60;

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public void setPower(int power) {
        this.power = power;
    }


    public int getPower() {
        return power;
    }


    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth (){return health;}

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public boolean isAlive() {
        if (getHealth() <= 0) isAlive = false;
        return isAlive;
    }
    public Long getId() {
        long result = 0;
        for (Long x: id) {
            result = x;
        }
        return result;
    }

    public int getLevel() {
        return level;
    }

    public abstract int givingExp();

    public void info() {
        System.out.println(Game.hero.name);
        System.out.println("Уровень: " + Game.hero.getLevel());
        System.out.println("Сила: " + Game.hero.getPower());
        System.out.println("Количество здоровья: " + Game.hero.getHealth());
        System.out.println("Максимальное здоровье: " + Game.hero.getMaxHealth());
        System.out.println("Количество опыта: " + Game.hero.getExperience());
        System.out.println("Защита: " + Game.hero.defenceRate);
    }

}

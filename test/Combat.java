package com.test;

import com.test.units.Unit;


public interface Combat {

    void hit(Unit unit);

    default void defence (Unit getPunch, Unit defender) {
        if ((int)(Math.random()*100) > defender.defenceRate) {
            System.out.println(defender.name + " ударяет в ответ " + getPunch.name);
            getPunch.setHealth(getPunch.getHealth() - (1 + (int)(Math.random()*2)));
        }
    }

    static String battleRaiting (Unit unit) {
        String result = "";
        switch (unit.getHealth()) {
            case 0 : result = "убит";
            break;
            case 1 : result = "смертельно ранен";
            break;
            case 2 : result = "серьезное ранение";
            break;
            case 3 : result = "ранен";
            break;
            default : result = "в норме";
            break;
    }
        return result;
    }


}

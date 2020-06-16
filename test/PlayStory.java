package com.test;

import com.test.Locations.Taverna;
import com.test.units.Unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PlayStory {
    private static boolean  win = false;
    public static void startGame () {

        Stream.iterate(1, n -> {
            try {
                igraGo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("vse OK");
            return n + 1;
        }).filter(n -> win).limit(1).forEach(System.out::println);

    }

    public static void igraGo() throws IOException {
        Taverna.getInstance().toLocation();
    }
    public static boolean battle (Unit unit) {
        Stream.iterate(1, n -> {
            Unit whoHit = null;
            Unit whoDefence = null;
            int random = (int) (Math.random() * 2);
            if (random == 1) {
                whoHit = unit;
                whoDefence = Game.hero;
            }
            else {
                whoDefence = unit;
                whoHit = Game.hero;
            }
            whoHit.hit(whoDefence);
//            Game.hero.hit(unit);
            return n + 1;
        }).filter(n -> {
            if (unit.getHealth() <= 0) {
                win = true;
                System.out.println("ПОБЕДА!!!");
            }
            else if (Game.hero.getHealth() <= 0) {
                win = true;
                System.out.println("ПРОИГРЫШ!!!");
            }
            else win = false;
            return win;
        }).limit(1).forEach(System.out::println);
        return Game.hero.isAlive();
    }
}

//        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//        int attack1 = (int) (Math.random() * units.size());
//        Unit one = units.get(attack1);
//        one.hit(units);
//        System.out.println(one.getHealth() + " " + one.name);
//        try {
//            String vopros = r.readLine();
//            switch (vopros) {
//                case "уйти" : break;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (!one.isAlive()) {
//            units.remove(one);
//            System.out.println(one.name + " погибает");
//        }

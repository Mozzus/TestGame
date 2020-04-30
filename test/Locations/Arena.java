package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;
import com.test.units.Unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Arena extends Location implements Management {
    private static final Arena instance = new Arena();
    private static int history = 0;
    private static int shag = 0;
    public static Hero Gektor = new Hero("Гектор");
    public static Hero Norris = new Hero("Норрис");

    private Arena() {
        name = "Арена";
    }

    public static Arena getInstance() {
        return instance;
    }

    @Override
    public void toLocation() throws IOException {
        System.out.println("Итак вы пришли на Арену");
        Hero.heroLocation = this;
        manage(Game.hero, this);
    }

    @Override
    public void scopePlace() throws IOException {
        System.out.println("Арена тут конечно не колизей, но и не капна земли за горожами. Главное есть уютное ограждение,\n" +
                "где можно настучать по кумполу и заработать несколько монет. Вы видете хозяина арены и пару бойцов на лавках");
        manage(Game.hero, this);
    }

    @Override
    public void intoPlace() throws IOException {
        switch (history) {
            case 0:
                System.out.println("Здесь негде шаблаться");
                history = 1;
                manage(Game.hero, this);
                break;
            case 1:
                System.out.println("Пытаться можете до бесконечности, но кроме как обратно в деревню вы никуда отсюда не выйдете");
                manage(Game.hero, this);
                break;
        }
    }

    @Override
    public void addHero() {
        heroes.add(Gektor);
        heroes.add(Norris);
    }
}

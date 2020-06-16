package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;
import com.test.units.Unit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.test.Game.hero;

public class Arena extends Location implements Management {
    private static final Arena instance = new Arena();
    private Unit unit;
    public static Hero Gektor = new Hero("Гектор");
    public static Hero Norris = new Hero("Норрис");

    private Arena() {
        name = "Арена";
        addingHistory();
    }

    public static Arena getInstance() {
        return instance;
    }

    @Override
    public void toLocation() throws IOException {
        System.out.println("Итак вы пришли на Арену");
        Hero.heroLocation = this;
        manage(hero, this);
    }

    @Override
    public void scopePlace() throws IOException {
        System.out.println("Арена тут конечно не колизей, но и не капна земли за горожами. Главное есть уютное ограждение,\n" +
                "где можно настучать по кумполу и заработать несколько монет. Вы видете хозяина арены и пару бойцов на лавках");
        manage(hero, this);
    }

    @Override
    public void addHero() {
        heroes.add(Gektor);
        heroes.add(Norris);
    }

    @Override
    void addingHistory() {
        //General Story
        addStory("Здесь негде шаблаться", hero, generalStory);
        addStory("Пытаться можете до бесконечности, но кроме как обратно в деревню вы никуда" +
                " отсюда не выйдете", hero, generalStory);

        //Turn Left Story
        addStory("Итак вы решили пойти влево от Арены, но ТАМ НИЧЕГО НЕТ!!", hero, turnLeftStory);
    }
}

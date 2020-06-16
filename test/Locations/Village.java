package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;

import java.io.IOException;

public class Village extends Location implements Management {
    private static final Village instance = new Village();
    public static Hero chester = new Hero("Честер");

    public static Village getInstance() {
        return instance;
    }

    private Village() {
        name = "Деревня";
        addingHistory();
    }

    @Override
    public void toLocation() throws IOException {
        System.out.println("Вы стоите на просторной улице в небольшой деревушке. Ващи действия?");
        Hero.heroLocation = this;
        manage(Game.hero, this);
    }

    @Override
    public void scopePlace() throws IOException {
        System.out.println("Вы видите всего несколько домов, арену и таверну, деревня маленькая, на улице почти никого." +
                "\nКакой то тип рубит дрова у своего дома." +
                "\nВ деревне можно зайти в таверну, арену, и если не боитесь, вломиться к кому нибудь домой,\n" +
                "А из деревни, дорога только в лес");
        manage(Game.hero, this);
    }

    @Override
    public void addHero() {
        heroes.add(chester);
    }

    @Override
    void addingHistory() {
        addStory("Вы проходите несколько домов но не находите ничего интересного", Game.hero, generalStory);
        addStory("Эх, вы ходите кругом по деревне, но здесь как было кисло и пусто, так и осталось, " +
                "\nно тут вдруг, вы замечаете сундук в кустах за колодцем", Game.hero, generalStory);
    }
}

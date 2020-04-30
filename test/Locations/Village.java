package com.test.Locations;

import com.test.Game;
import com.test.Inventory;
import com.test.Management;
import com.test.units.Hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Village extends Location implements Management {
    private static final Village instance = new Village();
    private static int history = 0;
    private static int shag = 0;
    public static Hero chester = new Hero("Честер");

    public static Village getInstance() {
        return instance;
    }

    private Village() {
        name = "Деревня";
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
    public void intoPlace() throws IOException {
        switch (history) {
            case 0:
                System.out.println("Вы проходите несколько домов но не находите ничего интересного");
                history = 1;
                manage(Game.hero, this);
                break;
            case 1:
                System.out.println("Эх, вы ходите кругом по деревне, но здесь как было кисло и пусто, так и осталось, " +
                        "\nно тут вдруг, вы замечаете сундук в кустах за колодцем");
                history = 3;
                manage(Game.hero, this);
                break;
            case 3:
                System.out.println("Вы открыли сундук");
                Inventory.addToInventory(Inventory.sword);
                manage(Game.hero, this);
                break;
        }
    }

    @Override
    public void addHero() {
        heroes.add(chester);
    }
}

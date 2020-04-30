package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.PlayStory;
import com.test.units.Hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Taverna extends Location {
    private static final Taverna instance = new Taverna();
    private static int history = 0;
    private static int shag = 0;

    public static Hero vasiliy = new Hero("Василий");

    private Taverna () {
        name = "Таверна";
    }
    public static Taverna getInstance() {
        return instance;
    }

    @Override
    public void toLocation() throws IOException {
        System.out.println("Вы находитесь в таверне. Что дальше?");
        Hero.heroLocation = this;
        manage(Game.hero, this);
    }

    @Override
    public void scopePlace() throws IOException {
        System.out.println("Обыкновенный кабак, ничего примечательного, кроме выпивки и странного владельца с перекошенной\n" +
                "левой бровью, которого зовут Василий. Ну и конечно приятное дополнение, что втором этаже он сдает пару коек.\n" +
                "Можно выспаться и залечить раны.");
        manage(Game.hero, this);
    }

    @Override
    public void intoPlace() throws IOException {
        switch (history) {
            case 0:
                System.out.println("Вы идете проходите по таверне, но тут особо нечего смотреть, тут лучше пить");
                history = 1;
                manage(Game.hero, this);
                break;
            case 1:
                System.out.println("Дальше только деревня, а в таверне ничего кроме выпивки и Василия");
                manage(Game.hero, this);
                break;
        }
    }

    @Override
    public void addHero() {
        heroes.add(vasiliy);
    }
}

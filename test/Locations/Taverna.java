package com.test.Locations;

import com.test.Game;
import com.test.units.Hero;

import java.io.IOException;

public class Taverna extends Location {
    private static final Taverna instance = new Taverna();

    public static Hero vasiliy = new Hero("Василий");

    private Taverna () {
        name = "Таверна";
        addingHistory();
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
    public void addHero() {
        heroes.add(vasiliy);
    }

    @Override
    void addingHistory() {
        addStory("Вы идете проходите по таверне, но тут особо нечего смотреть, тут лучше пить", Game.hero, generalStory);
        addStory("Дальше только деревня, а в таверне ничего кроме выпивки и Василия", Game.hero, generalStory);
    }
}

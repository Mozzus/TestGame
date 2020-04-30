package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;
import com.test.units.Unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Location implements Management {
    public String name;
    public static int state = 0;
    private int number = 0;
    List<Hero> heroes = new ArrayList<>();

    public abstract void scopePlace() throws IOException;
    public abstract void intoPlace () throws IOException;
    public abstract void toLocation() throws IOException;
    public abstract void addHero();
    public Location getLocation() throws  IOException {
        return this;
    }

    public void whoIsHere() throws IOException{
        addHero();
        heroes.removeIf(x -> {
            if(!x.isAlive()) return true;
            else {
                number+=1;
                System.out.println(number + ". " + x.name);
                return false;
            }
        });
        if (heroes.isEmpty()){
            System.out.println("Здесь не с кем поговорить");
            manage(Game.hero, this);
        }
    }

    public static void info () {
        System.out.println("Правила и игровые команды:" +
                "\nВы можете переходить по локациям игры используя интуитивно понятные слова. Например: \n" +
                "1) Пойти в лес \n2) Идти на арену" +
                "\nТакже вам допустны некоторые действия. Таким образом вы можете взаимодействовать с окружением. Например:\n" +
                "1) Убежать от волков \n2) Обойти врага \n3) Убить волка\n4) Что здесь есть? \n5) Говорить" +
                "\nИГРОВЫЕ КОМАНДЫ:" +
                "\n1. Инфо - отображает характеристики персонажа" +
                "\n2. Справка или Как играть - отображает Правила и игровые команды" +
                "\n3. Обзор или Что вижу? - отображает информацию о текущей локации" +
                "\n4. и - отображает инвентарь" +
                "\n4. надеть - надеть элемент инвентаря" +
                "\n4. снять - снять элемент инвентаря");
    }
}

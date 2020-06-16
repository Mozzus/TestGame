package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;
import com.test.units.Unit;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Location implements Management {
    public String name;
    public static int state = 0;
    private int number = 0;
    Set<Hero> heroes = new HashSet<>();
    int history = -1;
    int shag = 0;
    int random = (int)(Math.random()*2);
    public Map<Integer, StoryItemBuilder> generalStory = new HashMap<>();
    public Map<Integer, StoryItemBuilder> turnRightStory = new HashMap<>();
    public Map<Integer, StoryItemBuilder> turnLeftStory = new HashMap<>();
    int start = -1;

    public abstract void scopePlace() throws IOException;
    public abstract void toLocation() throws IOException;
    public abstract void addHero();
    abstract void addingHistory();
    public Location getLocation() {
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
        number = 0;
    }

    public void intoPlace(Map<Integer, StoryItemBuilder> historyMap) throws IOException {
        try {
            historyMap.get(history + 1).printStory();
        }
        catch (NullPointerException e) {
            System.out.println("Дальше история не написана, это тупик");
            manage(Game.hero, Game.hero.getHeroLocation());
        }
    }

//    public void multiChoiceStory(Map<Integer, StoryItem> map) throws IOException {
//        try {
//            map.get(history + 1).printStory();
//        }
//        catch (NullPointerException e) {
//            System.out.println("Дальше история не написана, это тупик");
//            manage(Game.hero, Game.hero.getHeroLocation());
//        }
//    }

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
                "\n5. надеть - надеть элемент инвентаря" +
                "\n6. снять - снять элемент инвентаря" +
                "\n7. з - обзор текущих заданий");
    }

    public void setHistory(int history) {
        this.history = history;
    }

    // Добавление описания
    public void addStory (String story, Unit unit, Map<Integer, StoryItemBuilder> map) {
        map.put(start+=1, new StoryItemBuilder().setStory(story).setUnit(unit).setHistory(1));
    }
    // Сюжет со встречей кого нибудь
    public void addStory (String story, String storyIfWent, Unit unit, String storyAfter, Map<Integer, StoryItemBuilder> map) {
        map.put(start+=1, new StoryItemBuilder()
                .setStory(story)
                .setStory2(storyIfWent)
                .setUnit(unit)
                .setStoryAfter(storyAfter)
                .setHistory(2));
    }
    // Случайный сюжет
    public void addStory (String storyRandom1, String storyRandom2, Unit unit, Map<Integer, StoryItemBuilder> map) {
        map.put(start+=1, new StoryItemBuilder()
                .setStory(storyRandom1)
                .setStory2(storyRandom2)
                .setUnit(unit)
                .setHistory(3));
    }

}

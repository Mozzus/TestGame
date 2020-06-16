package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoryItemBuilder implements Management {
    private String story;
    private String story2;
    private String storyAfter;
    private Unit unit;
    private int history;

    private int random = (int)(Math.random()*2);
    int shag = 0;

    public StoryItemBuilder setStory(String story) {
        this.story = story;
        return this;
    }

    public StoryItemBuilder setStory2(String story2) {
        this.story2 = story2;
        return this;
    }

    public StoryItemBuilder setStoryAfter(String storyAfter) {
        this.storyAfter = storyAfter;
        return this;
    }

    public StoryItemBuilder setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public StoryItemBuilder setHistory(int history) {
        this.history = history;
        return this;
    }

    public StoryItem build () {
        return new StoryItem(story, story2, unit, storyAfter, history);
    }

    void printStory() throws IOException {
        if (history == 1) {
            System.out.println(story);
            Game.hero.getHeroLocation().setHistory(Game.hero.getHeroLocation().history+=1);
            addChoice();
        }

        else if (history == 2) {
            if (unit.isAlive() && unit.isEnemy) {
                if (shag == 0) {
                    System.out.println(story);
                    shag = 1;
                }
                else {
                    System.out.println(story2);
                }
            }
            else {
                System.out.println(storyAfter);
                Game.hero.getHeroLocation().setHistory(Game.hero.getHeroLocation().history += 1);
            }

        }

        else if (history == 3) {
            if (random == 1) {
                if (!unit.isEnemy) {
                    System.out.println(story);
                    Game.hero.getHeroLocation().setHistory(Game.hero.getHeroLocation().history += 1);
                    unit = Game.hero;
                }
                else System.out.println(unit.name + "все там же");
            }
            else {
                System.out.println(story2);
                Game.hero.getHeroLocation().setHistory(Game.hero.getHeroLocation().history += 1);
                unit = Game.hero;
            }
        }

        manage(unit, Game.hero.getHeroLocation());
    }


    public void addChoice () throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String act = r.readLine().toLowerCase();

        try {
            if(Integer.parseInt(act) > 0 && act.length() == 1) act = "aklwdjawl";

        }
        catch (NumberFormatException e) {
            if (act.contains("налево")) act = "1";
            if (act.contains("направо")) act = "2";
        }

        switch (act) {
            case "1":
                Game.hero.getHeroLocation().intoPlace(Game.hero.getHeroLocation().turnLeftStory);
                break;
            case "2":
                Game.hero.getHeroLocation().intoPlace(Game.hero.getHeroLocation().turnRightStory);
                break;
        }
    }
}

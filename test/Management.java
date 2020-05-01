package com.test;

import com.test.Locations.*;
import com.test.units.Hero;
import com.test.units.Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.test.Game.hero;
import static com.test.Inventory.showMyInventory;
import static com.test.Locations.Location.info;
import static com.test.PlayStory.battle;

public interface Management {
    Dialog dialog = new Dialog();

    default void manage (Unit unit, Location location) throws IOException {
        hero.changeState();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String act = r.readLine().toLowerCase();

//        Теги интуитивных запросов
        try {
            if(Integer.parseInt(act) > 0 && act.length() == 1) act = "aklwdjawl";

        }
        catch (NumberFormatException e) {
            if (act.contains("убить") || act.contains("ударить себя") || act.contains("напасть")
            ||act.contains("ударить")) act = "1";
            else if (act.contains("убежать")) act = "2";
            else if (act.contains("поговорить")|| act.contains("говорить")) {
                if (act.length() > 11) Dialog.withWho(location, act);
                else act = "3";
            }
            else if (act.contains("правила") || act.contains("как играть")) act = "4";
            else if (act.contains("деревня") || act.contains("деревню")) act = "5";
            else if (act.contains("лес")) act = "6";
            else if (act.contains("таверна") || act.contains("таверну")) act = "7";
            else if (act.contains("что") || act.contains("обзор")) act = "8";
            else if (act.contains("идти") || act.contains("дальше") || act.contains("вперед")) act = "9";
            else if (act.contains("инфо")) act = "10";
            else if (act.contains("арена") || act.contains("арену")) act = "11";
            else if (act.contains("открыть")|| act.contains("сундук")) act = "9";
            else if (act.contains("чаща лес") || act.contains("чащу лес") || act.contains("чащу")
            ||act.contains("чаща") ||act.contains("сойти с дороги") ||act.equals("сойти")) act = "13";
            else if (act.equals("и")) act = "14";
            else if (act.contains("надеть")||act.contains("снять")) {
                if (act.length() > 7) {
                    String i = act.substring(7).toLowerCase();
                    Inventory.whatItem(i);
                    manage(hero, hero.getHeroLocation());
                } else {
                    Inventory.whatItem(act);
                    act = "15";
                }
            }
            else if (act.contains("выйти")) act = "16";
            else if (act.contains("назад")|| act.contains("вернуться")) act = "17";
            else if (act.equals("з")) act = "18";
        }
        switch (act) {
            case "1" :
                if (unit == hero) {
                    System.out.println("Ты не можешь ударить себя");
                    manage(unit, location);
                }
                else {
                    System.out.println("Вы решили напасть и битва завертелась..");
                    if (battle(unit)) {
                        hero.setExperience(hero.getExperience() + unit.givingExp());
                        System.out.println("Вы убили " + unit.name + ". Опыт + " + unit.givingExp());
                        manage(hero, location);
                    } else {
                        System.out.println("Вас убили. КОНЕЦ ИГРЫ");
                        System.exit(0);
                    }
                }
                break;
            case "2" :
                System.out.println("Вы убегаете от " + unit.name);
                Village.getInstance().toLocation();
                break;
            case "3" :
                Dialog.withWho(location,null);
                break;
            case "4" :
                info();
                manage(unit, location);
                break;
            case "5" :
                if (this == Village.getInstance()) System.out.println("Вы итак находитесь в " + location.name);
                else {
                    Hero.lastLocation = location;
                    Village.getInstance().toLocation();
                }
                manage(unit, location);
                break;
            case "6" :
                if (this == Forest.getInstance()) System.out.println("Вы итак находитесь в " + location.name);
                else if (this == Taverna.getInstance()|| this == Arena.getInstance())
                    System.out.println("Из этой локации нельзя сразу попасть в лес");
                else {
                    Hero.lastLocation = location;
                    Forest.getInstance().toLocation();
                }
                manage(unit, location);
                break;
            case "7" :
                if (this == Forest.getInstance()) System.out.println("Из этой локации нельзя сразу попасть в таверну");
                else {
                    Hero.lastLocation = location;
                    Taverna.getInstance().toLocation();
                }
                manage(unit, location);
                break;
            case "8" :
                location.scopePlace();
                break;
            case "9" :
                location.intoPlace();
                break;
            case "10" :
                hero.info();
                manage(unit, location);
                break;
            case "11" :
                if (this == Forest.getInstance()|| this == Taverna.getInstance())
                    System.out.println("Из этой локации нельзя сразу попасть на арену");
                else {
                    Hero.lastLocation = location;
                    Arena.getInstance().toLocation();
                }
                manage(unit, location);
                break;
            case "12" :
//                System.out.println("Сундук закрыт, отмычек у вас нет");
//                manage(unit, location);
                break;
            case "13" :
                System.out.println("Вы направляетесь в глушь, деревьев много и слышны звуки зверей");
                Forest.history = 6;
                location.intoPlace();
                break;
            case "14" :
                showMyInventory();
                manage(unit, location);
                break;
            case "15" :
                manage(unit, location);
                break;
            case "16" :
                Village.getInstance().toLocation();
                break;
            case "17" :
                Hero.toLastLocation();
                break;
            case "18" :
                Tasks.showTasks();
                manage(hero, hero.getHeroLocation());
                break;
            default:
                System.out.println("Не ясно что вы хотите, повторите команду");
                manage(unit, location);
        }
    }

    static void manageDiolog(Hero someone) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String act = r.readLine().toLowerCase();

        try {
            if(Integer.parseInt(act) > 0 && act.length() == 1) act = "aklwdjawl";

        }
        catch (NumberFormatException e) {
            if (act.contains("привет")) act = "0";
            else if (act.contains("задание") || act.contains("задания") || act.contains("помощь")) act = "1";
            else if (act.contains("новости") || act.contains("слухи") || act.contains("что слышно")) act = "2";
            else if (act.contains("место") || act.contains("местах") || act.contains("месте")) act = "3";
            else if (act.contains("пока") || act.contains("завершить")) act = "4";
            else if (act.contains("арена") || act.contains("драться") || act.contains("арене")
                    || act.contains("арену")) act = "5";
            else if (act.contains("убить") || act.contains("драться с")) act = "6";
            else if (act.contains("как дела") || act.contains("как жизнь")) act = "7";
            else if (act.contains("дракон")) act = "8";
            else if (act.contains("спать") || act.contains("сон")) act = "9";

            switch (act) {
                case "0":
                    dialog.privet(someone);
                    break;
                case "1":
                    dialog.haveTask(someone);
                    break;
                case "2":
                    dialog.whatNew(someone);
                    break;
                case "3":
                    dialog.aboutPlace(someone);
                    break;
                case "4":
                    dialog.closeDialog(someone);
                    break;
                case "5":
                    dialog.igraNaArene(someone);
                    break;
                case "6":
                    System.out.println("Вы решили напасть и битва завертелась..");
                    if (battle(someone)) {
                        hero.setExperience(hero.getExperience() + someone.givingExp());
                        System.out.println("Вы убили " + someone.name + ". Опыт + " + someone.givingExp());
                        someone.setAlive(false);
                        dialog.closeDialog(hero);
                    } else {
                        System.out.println("Вас убили. КОНЕЦ ИГРЫ");
                        System.exit(0);
                    }
                    break;
                case "7":
                    dialog.howAreYou(someone);
                    break;
                case "8":
                    dialog.aboutDragon(someone);
                    break;
                case "9":
                    dialog.goToSleep(someone);
                    break;
                default:
                    System.out.println("Не ясно что вы хотите этим сказать");
                    manageDiolog(someone);
                    break;
            }
        }
    }

}

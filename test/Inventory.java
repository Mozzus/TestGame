package com.test;

import com.test.units.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static List<Item> myInventory = new ArrayList<>();
    static Item dagger = new Item("Кинжал", 1, false);
    public static Item sword = new Item("Меч", 2, false);
    private static StringBuilder whatOn = new StringBuilder("Надето");

    public static void addToInventory(Item item) {
        System.out.println(item.getName() + " добавлен в ваш инвентарь");
        myInventory.add(item);
    }
    public static void showMyInventory () {
        System.out.println("Ваш инвентарь:");
        if (myInventory.isEmpty()) System.out.println("Там ничего нет");
        else {
            for (Item x : myInventory) {
                if (x.isON())
                    System.out.println(x.getName() + ", урон: " + x.getPower() + " " + whatOn);
                else System.out.println(x.getName() + ", урон: " + x.getPower());
            }
        }
    }

    public static void putItem(Item item) throws IOException {
        for (Item x : myInventory) {
            if (x.isON()) {
                System.out.println("Вы не можете надеть больше вещей!");
                Hero.toPresentLocation();
            }
        }
        System.out.println("Вы надели " + item.getName());
        item.setOn(true);
        Game.hero.setPower(Game.hero.getPower() + item.getPower());
    }

    public static void takeOffItem (Item item) {
        System.out.println("Вы сняли " + item.getName());
        item.setOn(false);
        Game.hero.setPower(Game.hero.getPower() - item.getPower());
    }

    public static void whatItem (String name) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        Item what;
        String off;
        String on;

        if (name.contains("надеть")) {
            System.out.println("Что вы хотите надеть?");
            on = r.readLine().toLowerCase();
        }
        else on = name;
        if (name.contains("снять")){
            System.out.println("Что вы хотите снять?");
            off = r.readLine().toLowerCase();
        }
        else off = name;

            for (Item x : myInventory) {
                    if (x.getName().toLowerCase().contains(on)) {
                        what = x;
                        putItem(what);
                    }
                    else if (x.getName().toLowerCase().contains(off)) {
                        what = x;
                        takeOffItem(what);
                    }
        }
    }
}

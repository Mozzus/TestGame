package com.test;

import com.test.Locations.Location;
import com.test.units.Dragon;
import com.test.units.Hero;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static com.test.Locations.Taverna.vasiliy;

public class Game {
    public static Dragon dragon;
    public static Hero hero;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        dragon = new Dragon();
        Location.info();
        System.out.println("\n \t Добро пожаловать в сказочный мир героев, волшебников и чудесных королевств!");
        System.out.println("Вы совсем не понимаете что происходит, вы только что проснулись в какой то таверне." +
                "\nНа вас смотрит незнакомец и обращается к вам: " + "\n" +
                "\t- Я нашел тебя в заваленной ошметками дохлых крыс пещере, не знаю что ты там делал, " +
                " \n \tно я посчитал что тебя нужно спасти, меня зовут Василий, а как тебя называть странник?");

        hero = new Hero(reader.readLine());
        hero.info();
        System.out.println("Итак, приятно познакомиться " + hero.name + ". Пойдем выпьем пива, и обсудим кое что.");
        Thread.sleep(1000);
        System.out.println("Спускаетесь к барной стойке...");
        Thread.sleep(4000);
        System.out.println("Вы пьете пиво, " + vasiliy.name + " заводит с вами разговор:");
        System.out.println("- В окрестностях видели дракона, нужно что то с этим сделать");
        System.out.println("Напишите букву для ответа: \n" +
                "а) Я пойду в лес поищу дракона, не беспокойтесь \n" +
                "б) Мне это не интересно, спасибо за информацию");
        String otvet = reader.readLine();
        if (otvet.equals("а")) {
            Thread.sleep(1000);
            System.out.println("- Отлично, вижу ты парень крепкий, и подходишь для этого дела, держи этот кинжал, поможет в дороге");
            Tasks.addTask("Нужно найти дракона");
            Inventory.addToInventory(Inventory.dagger);
        }
        else {
            Thread.sleep(1000);
            System.out.println("- Ну что ж бывай, бродяга");
        }
//        Thread.sleep(3000);
        System.out.println("Итак вы допили пиво");

        PlayStory.startGame();
    }
}

package com.test;

import com.test.Locations.Arena;
import com.test.Locations.Location;
import com.test.Locations.Taverna;
import com.test.Locations.Village;
import com.test.units.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.test.Locations.Arena.Gektor;
import static com.test.Locations.Arena.Norris;
import static com.test.Locations.Taverna.vasiliy;
import static com.test.Locations.Village.chester;

public class Dialog implements Management {


    public void privet (Hero hero) throws IOException
    {
        if (hero == vasiliy) {
            System.out.println("- И тебе привет путник");
            Management.manageDiolog(hero);
        }
        else if (hero == Gektor) {
            System.out.println("Ну привет, что тебе нужно?");
            Management.manageDiolog(hero);
        }
        else if (hero == chester) {
            System.out.println("Привет, я здешний дровосек. Меня зовут Честер");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public void haveTask (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- Есть у меня для тебя кое что. Нужно найти меч, на нем выгравировано мои имя, я его " +
                    "\nв лесу где то потерял");
            Tasks.addTask("Найти меч Василия и отдать ему его. Потерял где то в лесу.");
            Management.manageDiolog(hero);
        }
        else if (hero == chester) {
            System.out.println("Слушай, есть у меня для тебя работенка, меня мучают волки в этом лесу, не дают рубить " +
                    "\nдрова. Если ты убьешь волка, я тебе за это щедро заплачу");
            Tasks.addTask("Честера мучают волки, нужно убить волка и принести его тушу в доказательство");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void whatNew (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- В соседней деревне говорят видели дикую ВепроЧушку, теперь у них все сидят по домам и \n" +
                    "ждут когда придет спаситель");
            Management.manageDiolog(hero);
        }
        else if (hero == chester) {
            System.out.println("Моя жинка говорит шо шлюх развелось последнее время, стоят частенько у края проселочных дорог." +
                    "\nУжас то какой!");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void aboutPlace (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- Ой ну это деревня под названием Камнеши, жителей мало, одно радует, что Арена есть");
            Management.manageDiolog(hero);
        }
        else if (hero == chester) {
            System.out.println("Деревня как деревня, мне тут нравится, главное деревьев много поблизости");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void howAreYou (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- Да у меня все зашибись, лишь бы пиво не кончалось, ха ха, ухххааха");
            Management.manageDiolog(hero);
        }
        else if (hero == chester) {
            System.out.println("Не на что жаловаться, жизнь кипит своим чередом");
            Management.manageDiolog(hero);
        }
        else if (hero == Gektor) {
            System.out.println("Слышь, глиста кусок, дела у прокурора, а у меня так - делишки, и вообще" +
                    "\nпшел отсюда пока шбан тебе не проломил, ишь чего про дела спросил, гадская морда");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void igraNaArene (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- На арене можно подзаработать");
            Management.manageDiolog(hero);
        }
        else if (hero == Gektor) {
            System.out.println("Арена пока закрыта, тут нечего делать");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void aboutDragon (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- Послушай, дракона видели в здешнем лесу, он гонялся за здешней овцой, и теперь нет у " +
                    "\nу нас овцы, ой до слез аж. Ладно вообщем говорят дракон полетел затем в сторону Тарта");
            Management.manageDiolog(hero);
        }
        else if (hero == chester) {
            System.out.println("Да, слыхал я о драконе, но ничего путного тебе не скажу, однако в таком виде тебе дракона не убить");
            Management.manageDiolog(hero);
        }
        else if (hero == Norris) {
            System.out.println("Шо? ты охренел про это спрашивать? это была моя овца, хренов дракон ее сожрал. " +
                    "\nНе напоминай мне об этом и своей ослиной мордой не свети тут!");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void goToSleep (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("Хорошо, на ключ от комнаты, иди поспи");
            Game.hero.setHealth(Game.hero.getMaxHealth());
            System.out.println("Вы выспались и поправили здоровье");
            manage(Game.hero, Game.hero.getHeroLocation());
        }
        else if (hero == chester) {
            System.out.println("Не, не могу с тобой спать, жинка не одобрит");
            Management.manageDiolog(hero);
        }
        else if (hero == Norris) {
            System.out.println("Ща из арены вылетишь, бродяга ");
            Management.manageDiolog(hero);
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public  void closeDialog (Hero hero) throws IOException {
        if (hero == vasiliy) {
            System.out.println("- Ну пока");
            System.out.println("Разговор завершен, что будете делать дальше?");
            manage(Game.hero, hero.getHeroLocation());
        }
        else if (hero == chester) {
            System.out.println("Ну и ты бывай мил чиловек");
            manage(Game.hero, hero.getHeroLocation());
        }
        else if (hero == Gektor) {
            System.out.println("Досвидос парень");
            manage(Game.hero, hero.getHeroLocation());
        }
        else if (hero == Norris) {
            System.out.println("Проваливай");
            manage(Game.hero, hero.getHeroLocation());
        }
        else if (hero == Game.hero) {
            System.out.println("Вы скрываетесь в таверне");
            manage(Game.hero, hero.getHeroLocation());
        }
        else {
            System.out.println("Мне не о чем с тобой говорить, проваливай!");
            Management.manageDiolog(hero);
        }
    }

    public static void withWho(Location location, String names) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name;
        if (names == null) {
            System.out.println("С кем вы хотите поговорить? ");
            location.whoIsHere();
            name = r.readLine().toLowerCase();
        }
        else name = names;

        try {
            if(Integer.parseInt(name) > 0 && name.length() == 1) name = "aklwdjawl";

        }
        catch (NumberFormatException e) {
            if (name.contains("василием") || name.contains("василий")) name = "0";
            if (name.contains("гектор") || name.contains("гектором")) name = "2";
            if (name.contains("норрис") || name.contains("норрисом")) name = "3";
            if (name.contains("честер") || name.contains("честером")) name = "4";
            if (name.contains("ни с кем") || name.contains("не хочу")) name = "1";
            switch (name) {
                case "0":
                    if (location == Taverna.getInstance()) {
                        System.out.println("Вы подходите к Василию, ваши слова?");
                        Management.manageDiolog(vasiliy);
                    } else {
                        System.out.println("Таких здесь нет или вы ошиблись с именем");
                        withWho(location, null);
                    }
                    break;
                case "1":
                    System.out.println("Вы ни с кем не говорите");
                    location.toLocation();
                    break;
                case "2":
                    if (location == Arena.getInstance()) {
                        System.out.println("Вы подходите к Гектору, ваши слова?");
                        Management.manageDiolog(Gektor);
                    } else {
                        System.out.println("Таких здесь нет или вы ошиблись с именем");
                        withWho(location, null);
                    }
                    break;
                case "3":
                    if (location == Arena.getInstance()) {
                        System.out.println("Вы подходите к Норрису, ваши слова?");
                        Management.manageDiolog(Arena.Norris);
                    } else {
                        System.out.println("Таких здесь нет или вы ошиблись с именем");
                        withWho(location, null);
                    }
                    break;
                case "4":
                    if (location == Village.getInstance()) {
                        System.out.println("Вы подходите к Честеру, ваши слова?");
                        Management.manageDiolog(chester);
                    } else {
                        System.out.println("Таких здесь нет или вы ошиблись с именем");
                        withWho(location, null);
                    }
                    break;
                default:
                    System.out.println("Таких здесь нет, возможно вы ошиблись");
                    withWho(location, null);
                    break;
            }
        }
    }
}

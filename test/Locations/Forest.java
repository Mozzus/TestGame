package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;
import com.test.units.Unit;
import com.test.units.Wolf;

import java.io.IOException;

public class Forest extends Location implements Management {
    private static final Forest instance = new Forest();
    public static int history = 0;
    private static int shag = 0;
    private static Wolf wolf = new Wolf();
    private int random = (int)(Math.random()*2);


    public static Forest getInstance() {
        return instance;
    }

    private Forest(){
        name = "Лес";
    }

    @Override
    public void toLocation() throws IOException {
        System.out.println("Итак вы в лесу, здесь холодно, вы идете по дороге, оглядываясь по сторонам. Что дальше?");
        Hero.heroLocation = this;
        manage(Game.hero, this);
    }

    @Override
    public void intoPlace () throws IOException {
        Hero razb = new Hero("Чурка");
        if(wolf.isAlive()) history = 0;
        switch (history) {
            case 0:
                if (shag == 0) {
                    System.out.println("Становится все холоднее, вы замечаете у края дороги волка, он отгрызает у зайца голову, но в этот \n" +
                            "момент он видит вас, бросает зайца и мееееедленного направляется к вам. Ваши действия?");
                    shag = 1;
                    history = 1;
                }
                else  {
                    System.out.println("Волк никуда не делся, лежит себе у дороги, полизывает лапу");
                    history = 1;
                }
            manage(wolf, this);
            break;
            case 1:
                System.out.println("Волк побежден, его мертвая туша валяется среди кустов, вы можете идти по дороге дальше," +
                        "\nсойти с дороги и поискать что нибудь интересное в чаще леса или вернуться назад");
                history = 2;
                manage(Game.hero, this);
                break;
            case 2:
                if (random == 1) {
                    System.out.println("Вы встречаете путника");
                    System.out.println("А ну иди сюда падла, ща вытрясу из тебя все монеты");
                    history = 3;
                    manage(razb, this);
                }
                else {
                    System.out.println("На вас напала стая диких пум и окружила вас");
                    System.out.println("Ан нет, показалось, это всего лишь зайцы.");
                    history = 5;
                }
                manage(Game.hero, this);
                break;
            case 3:
                if (!razb.isAlive()) System.out.println("Эта чурка все еще здесь, точит свой кинжал возле дерева");
                else System.out.println("Чурка валяется у дерева, вокруг никого, только кусты и деревья");
                history = 5;
                    manage(Game.hero, this);
                break;
            case 5:
                System.out.println("Дальше тупик, дорога завалена");
                manage(Game.hero, this);
                break;
            case 6:
                System.out.println("Вы замечаете как из за кустов появляется Норрис");
                System.out.println("- Тоби пизда, ты мне не нравишься");
                System.out.println("- Норрис направляется к вам с мечом");
                manage(Arena.Norris, this);
                history = 5;
                break;
        }
    }

    @Override
    public void scopePlace() throws IOException {
        System.out.println("Лес как лес, но есть в нем что то, таинственное, звери и пугающая живность тут нередко\n" +
                "встречаются. Этот лес ведет в Тарт, королевство сапфировых рудников. Но путь не близкий, и полон опасностей.");
        manage(Game.hero, this);
    }

    @Override
    public void addHero() {

    }
}

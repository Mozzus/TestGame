package com.test.Locations;

import com.test.Game;
import com.test.Management;
import com.test.units.Hero;
import com.test.units.Unit;
import com.test.units.Wolf;

import java.io.IOException;

public class Forest extends Location implements Management {
    private static final Forest instance = new Forest();
    private Unit unit;
    private static Wolf wolf = new Wolf();



    public static Forest getInstance() {
        return instance;
    }

    private Forest(){
        name = "Лес";
        addingHistory();
    }

    @Override
    public void toLocation() throws IOException {
        System.out.println("Итак вы в лесу, здесь холодно, вы идете по дороге, оглядываясь по сторонам. Что дальше?");
        Hero.heroLocation = this;
        manage(Game.hero, this);
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

    @Override
    void addingHistory() {
        addStory("Становится все холоднее, вы замечаете у края дороги волка, он отгрызает у зайца голову, но в этот \n" +
                "момент он видит вас, бросает зайца и мееееедленного направляется к вам. Ваши действия?", "" +
                "Волк никуда не делся, лежит себе у дороги, полизывает лапу", Forest.wolf, "Волк побежден, его мертвая туша " +
                "валяется среди кустов, вы можете идти по дороге дальше," +
                "\nсойти с дороги и поискать что нибудь интересное в чаще леса или вернуться назад", generalStory);

        Hero razb = new Hero("Чурка");
        razb.setEnemy(true);

        addStory("Вы встречаете путника\n" +
                "А ну иди сюда падла, ща вытрясу из тебя все монеты", "На вас напала стая диких пум и окружила вас\n" +
                "Ан нет, показалось, это всего лишь зайцы.", razb, generalStory);
        addStory("Эта чурка все еще здесь, точит свой кинжал возле дерева", "Эх чурка, чурка, так и поджидает здесь",
                razb, "Чурка валяется у дерева, вокруг никого, только кусты и деревья", generalStory);
    }
}

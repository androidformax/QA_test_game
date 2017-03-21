package tk.macrodev.game;

import tk.macrodev.game.actions.Action;
import tk.macrodev.game.actions.AttackAction;
import tk.macrodev.game.actions.DowngradeAction;
import tk.macrodev.game.actions.UpgradeAction;

import java.util.Random;

import static tk.macrodev.game.actions.GenerateRandom.generateRandom;

/**
 * Created by androidformax on 20.03.2017.
 */
public class LogicGame {
    /**
     * Метод для генерации случайного числа 0 или 1 для определений выбора команд и ударов.
     *
     */
    public class GenerateRandom {
        public Random random = new Random();

        public double generateRandom(int i) {
            return Math.abs(random.nextInt()) % i;
        }
    }

    /**
     * Точка входа
     *
     */
    public static void main(String[] args) {

        Character magElf = new Character(Character.Type.GENERAL, 100);
        magElf.load(new AttackAction(10, Action.Type.MAGIC_ATTACK));
        magElf.load(new UpgradeAction(Action.Type.UPGRADE));

        Character archerElf = new Character(Character.Type.GENERAL, 100);
        archerElf.load(new AttackAction(7, Action.Type.BOW_ATTACK));
        archerElf.load(new AttackAction(3, Action.Type.ATTACK));

        Character warriorElf = new Character(Character.Type.GENERAL, 100);
        warriorElf.load(new AttackAction(15, Action.Type.ATTACK));

        Character magHuman = new Character(Character.Type.GENERAL, 100);
        magHuman.load(new AttackAction(4, Action.Type.MAGIC_ATTACK));
        magHuman.load(new UpgradeAction(Action.Type.UPGRADE));

        Character archerHuman = new Character(Character.Type.GENERAL, 100);
        archerHuman.load(new AttackAction(5, Action.Type.BOW_ATTACK));
        archerHuman.load(new AttackAction(3, Action.Type.ATTACK));

        Character warriorHuman = new Character(Character.Type.GENERAL, 100);
        warriorHuman.load(new AttackAction(18, Action.Type.ATTACK));

        Character shamanOrc = new Character(Character.Type.GENERAL, 100);
        shamanOrc.load(new DowngradeAction(Action.Type.DOWNGRADE));
        magHuman.load(new UpgradeAction(Action.Type.UPGRADE));

        Character archerOrc = new Character(Character.Type.GENERAL, 100);
        archerOrc.load(new AttackAction(3, Action.Type.BOW_ATTACK));
        archerOrc.load(new AttackAction(2, Action.Type.ATTACK));

        Character goblinOrc = new Character(Character.Type.GENERAL, 100);
        warriorHuman.load(new AttackAction(20, Action.Type.ATTACK));

        Character necromancerUndead = new Character(Character.Type.GENERAL, 100);
        necromancerUndead.load(new DowngradeAction(Action.Type.DOWNGRADE));
        necromancerUndead.load(new UpgradeAction(Action.Type.UPGRADE));

        Character hunterUndead = new Character(Character.Type.GENERAL, 100);
        archerOrc.load(new AttackAction(3, Action.Type.BOW_ATTACK));
        archerOrc.load(new AttackAction(2, Action.Type.ATTACK));

        Character zombieUndead = new Character(Character.Type.GENERAL, 100);
        warriorHuman.load(new AttackAction(20, Action.Type.ATTACK));
        /**
         * Отряды
         */

        double newRndGood = generateRandom(1);
        if (newRndGood == 0) {
            Character[] elfs = {magElf, archerElf, archerElf, archerElf,warriorElf,warriorElf,warriorElf,warriorElf};

        } else {
            Character[] humans = {magHuman, archerHuman, archerHuman, archerHuman,warriorHuman,warriorHuman,warriorHuman,warriorHuman};
        }

        double newRndBad = generateRandom(1);

        if (newRndBad == 0) {

            Character[] orcs = {shamanOrc, archerOrc, archerOrc, archerOrc,goblinOrc,goblinOrc,goblinOrc,goblinOrc};

        } else {

            Character[] undeads = {necromancerUndead, hunterUndead, hunterUndead, hunterUndead,zombieUndead,zombieUndead,zombieUndead,zombieUndead};

        }

    }


}

//        Character[] elfs = {magElf, archerElf, archerElf, archerElf,warriorElf,warriorElf,warriorElf,warriorElf};
//        Character[] humans = {magHuman, archerHuman, archerHuman, archerHuman,warriorHuman,warriorHuman,warriorHuman,warriorHuman};
//        Character[] orcs = {shamanOrc, archerOrc, archerOrc, archerOrc,goblinOrc,goblinOrc,goblinOrc,goblinOrc};
//        Character[] undeads = {necromancerUndead, hunterUndead, hunterUndead, hunterUndead,zombieUndead,zombieUndead,zombieUndead,zombieUndead};

//           Пример создания списка, если захочу вернуться к спискам.
//            List<Character> undeads = new ArrayList<>();
//            undeads.add(necromancerUndead);
//            undeads.add(hunterUndead);
//            undeads.add(hunterUndead);
//            undeads.add(hunterUndead);
//            undeads.add(zombieUndead);
//            undeads.add(zombieUndead);
//            undeads.add(zombieUndead);
//            undeads.add(zombieUndead);

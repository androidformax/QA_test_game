package tk.macrodev.game;

import tk.macrodev.game.actions.Action;
import tk.macrodev.game.actions.AttackAction;
import tk.macrodev.game.actions.DowngradeAction;
import tk.macrodev.game.actions.UpgradeAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static tk.macrodev.game.LogicGame.RaceHuman.ARCHER;
import static tk.macrodev.game.LogicGame.RaceHuman.MAG;
import static tk.macrodev.game.LogicGame.RaceHuman.WARRIOR;
import static tk.macrodev.game.LogicGame.RaceOrk.GOBLIN;
import static tk.macrodev.game.LogicGame.RaceOrk.SHAMAN;

/**
 * Created by androidformax on 22.03.2017.
 */
public class LogicGame {

    final Random rm = new Random();

    public void run() {

        int command1 = rm.nextInt(1);

            List<Character> elfs = new ArrayList<>();
            elfs.add(this.createElf(RaceElf.MAG));
            elfs.add(this.createElf(RaceElf.ARCHER));
            elfs.add(this.createElf(RaceElf.ARCHER));
            elfs.add(this.createElf(RaceElf.ARCHER));
            elfs.add(this.createElf(RaceElf.WARRIOR));
            elfs.add(this.createElf(RaceElf.WARRIOR));
            elfs.add(this.createElf(RaceElf.WARRIOR));
            elfs.add(this.createElf(RaceElf.WARRIOR));


            List<Character> humans = new ArrayList<>();
            humans.add(this.createHuman(MAG));
            humans.add(this.createHuman(ARCHER));
            humans.add(this.createHuman(ARCHER));
            humans.add(this.createHuman(ARCHER));
            humans.add(this.createHuman(WARRIOR));
            humans.add(this.createHuman(WARRIOR));
            humans.add(this.createHuman(WARRIOR));
            humans.add(this.createHuman(WARRIOR));

            List<Character> orcs = new ArrayList<>();
            orcs.add(this.createOrk(SHAMAN));
            orcs.add(this.createOrk(RaceOrk.ARCHER));
            orcs.add(this.createOrk(RaceOrk.ARCHER));
            orcs.add(this.createOrk(RaceOrk.ARCHER));
            orcs.add(this.createOrk(RaceOrk.GOBLIN));
            orcs.add(this.createOrk(RaceOrk.GOBLIN));
            orcs.add(this.createOrk(RaceOrk.GOBLIN));
            orcs.add(this.createOrk(RaceOrk.GOBLIN));


            List<Character> undeads = new ArrayList<>();
            undeads.add(this.createUndead(RaceUndead.NECROMANCER));
            undeads.add(this.createUndead(RaceUndead.HUNTER));
            undeads.add(this.createUndead(RaceUndead.HUNTER));
            undeads.add(this.createUndead(RaceUndead.HUNTER));
            undeads.add(this.createUndead(RaceUndead.ZOMBIE));
            undeads.add(this.createUndead(RaceUndead.ZOMBIE));
            undeads.add(this.createUndead(RaceUndead.ZOMBIE));
            undeads.add(this.createUndead(RaceUndead.ZOMBIE));

        List<Character> komanda1;
        List<Character> komanda2;

        if (command1 == 0) {
            komanda1 = elfs;
        } else {
            komanda1 = humans;
        }
        int command2 = rm.nextInt(1);
        if (command2 == 0) {
            komanda2 = orcs;
        }else{
           komanda2 = undeads;
        }

        // реализация боя, через if с рендомом?
            //fight

        Character who = komanda1.get(rm.nextInt(komanda1.size()));
        Character to = komanda2.get(rm.nextInt(komanda2.size()));
        who.action(
                Action.Type.values()[Action.Type.values().length],
                to
        );
    }

    Character createElf(RaceElf race) {
        Character character = null;
        if (race == RaceElf.MAG) {
            character = this.buildMagElf();
        }

        if (race == RaceElf.ARCHER) {
            character = this.buildArcherElf();
        }

        if (race == RaceElf.WARRIOR) {
            character = this.buildWarriorElf();
        }

        return character;
    }

    Character createHuman(RaceHuman race) {
        Character character = null;
        if (race == MAG) {
            character = this.buildMagHuman();
        }
        if (race == ARCHER) {
            character = this.buildArcherHuman();
        }

        if (race == WARRIOR) {
            character = this.buildWarriorHuman();
        }

        return character;
    }

    Character createOrk(RaceOrk race) {
        Character character = null;
        if (race == SHAMAN) {
            character = this.buildShamanOrc();
        }
        if (race == RaceOrk.ARCHER) {
            character = this.buildArcherOrc();
        }
        if (race == GOBLIN) {
            character = this.buildGoblinOrc();
        }

        return character;
    }

    Character createUndead(RaceUndead race) {
        Character character = null;
        if (race == RaceUndead.NECROMANCER) {
            character = this.buildNecromancerUndead();
        }
        if (race == RaceUndead.HUNTER) {
            character = this.buildHunterUndead();
        }
        if (race == RaceUndead.ZOMBIE) {
            character = this.buildZombieUndead();
        }

        return character;
    }

    /**
     * Списки Персонажей каждой рассы.
     */
    enum RaceElf {
        MAG,
        ARCHER,
        WARRIOR

    }

    enum RaceHuman {
        MAG,
        ARCHER,
        WARRIOR

    }

    enum RaceOrk {
        SHAMAN,
        ARCHER,
        GOBLIN

    }

    enum RaceUndead {
        NECROMANCER,
        HUNTER,
        ZOMBIE
    }

    /**
     * Создание персонажей, с видами атак присущими каждому персонажу.
     */
    Character buildMagElf() {
        Character magElf = new Character(Character.Type.GENERAL, 100);
        magElf.load(new AttackAction(10, Action.Type.MAGIC_ATTACK));
        magElf.load(new UpgradeAction(Action.Type.UPGRADE));

        return magElf;
    }

    Character buildArcherElf() {
        Character archerElf = new Character(Character.Type.GENERAL, 100);
        archerElf.load(new AttackAction(7, Action.Type.BOW_ATTACK));
        archerElf.load(new AttackAction(3, Action.Type.ATTACK));

        return archerElf;
    }

    Character buildWarriorElf() {
        Character warriorElf = new Character(Character.Type.GENERAL, 100);
        warriorElf.load(new AttackAction(15, Action.Type.ATTACK));

        return warriorElf;
    }

    Character buildMagHuman() {
        Character magHuman = new Character(Character.Type.GENERAL, 100);
        magHuman.load(new AttackAction(4, Action.Type.MAGIC_ATTACK));
        magHuman.load(new UpgradeAction(Action.Type.UPGRADE));

        return magHuman;
    }

    Character buildArcherHuman() {
        Character archerHuman = new Character(Character.Type.GENERAL, 100);
        archerHuman.load(new AttackAction(5, Action.Type.BOW_ATTACK));
        archerHuman.load(new AttackAction(3, Action.Type.ATTACK));


        return archerHuman;
    }

    Character buildWarriorHuman() {
        Character warriorHuman = new Character(Character.Type.GENERAL, 100);
        warriorHuman.load(new AttackAction(18, Action.Type.ATTACK));

        return warriorHuman;
    }

    Character buildShamanOrc() {
        Character shamanOrc = new Character(Character.Type.GENERAL, 100);
        shamanOrc.load(new DowngradeAction(Action.Type.DOWNGRADE));
        shamanOrc.load(new UpgradeAction(Action.Type.UPGRADE));

        return shamanOrc;
    }

    Character buildArcherOrc() {
        Character archerOrc = new Character(Character.Type.GENERAL, 100);
        archerOrc.load(new AttackAction(3, Action.Type.BOW_ATTACK));
        archerOrc.load(new AttackAction(2, Action.Type.ATTACK));
        return archerOrc;
    }

    Character buildGoblinOrc() {
        Character goblinOrc = new Character(Character.Type.GENERAL, 100);
        goblinOrc.load(new AttackAction(20, Action.Type.ATTACK));

        return goblinOrc;
    }

    Character buildNecromancerUndead() {
        Character necromancerUndead = new Character(Character.Type.GENERAL, 100);
        necromancerUndead.load(new DowngradeAction(Action.Type.DOWNGRADE));
        necromancerUndead.load(new UpgradeAction(Action.Type.UPGRADE));

        return necromancerUndead;
    }


    Character buildHunterUndead() {
        Character hunterUndead = new Character(Character.Type.GENERAL, 100);
        hunterUndead.load(new AttackAction(3, Action.Type.BOW_ATTACK));
        hunterUndead.load(new AttackAction(2, Action.Type.ATTACK));

        return hunterUndead;
    }


    Character buildZombieUndead() {
        Character zombieUndead = new Character(Character.Type.GENERAL, 100);
        zombieUndead.load(new AttackAction(20, Action.Type.ATTACK));

        return zombieUndead;
    }

}

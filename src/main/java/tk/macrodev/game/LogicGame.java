package tk.macrodev.game;

import tk.macrodev.game.actions.Action;
import tk.macrodev.game.actions.AttackAction;
import tk.macrodev.game.actions.DowngradeAction;
import tk.macrodev.game.actions.UpgradeAction;

/**
 * Created by androidformax on 20.03.2017.
 */
public class LogicGame {
    public void run() {
        Character magElf = new Character(Character.Type.GENERAL, 100);
        magElf.load(new AttackAction(10,Action.Type.MAGIC_ATTACK));
        magElf.load(new UpgradeAction(Action.Type.UPGRADE));

        Character archerElf = new Character(Character.Type.GENERAL, 100);
        archerElf.load(new AttackAction(7, Action.Type.BOW_ATTACK));
        archerElf.load(new AttackAction(3, Action.Type.ATTACK));

        Character warriorElf = new Character(Character.Type.GENERAL, 100);
        warriorElf.load(new AttackAction(15, Action.Type.ATTACK));

        Character magHuman = new Character(Character.Type.GENERAL, 100);
        magHuman.load(new AttackAction(4,Action.Type.MAGIC_ATTACK));
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

    }
}

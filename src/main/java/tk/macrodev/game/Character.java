package tk.macrodev.game;

import tk.macrodev.game.actions.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androidformax on 20.03.2017.
 */

public class Character {
    private Type type;
    private int damage;
    private int hp;

    private List<Action> actions = new ArrayList<Action>();

    public Character(Type type, int hp) {
        this.type = type;
        this.hp = hp;

    }

    public void load(Action action) {
        this.actions.add(action);
    }

    public void changeType(Type type) {
        this.type = type;
    }

    public void beAttacked(int hp) {
        this.hp = this.hp - hp;
    }

    public void beUpgraded(int damage) {
        this.damage = this.damage + (damage/2);
        if (this.type != Type.PRIVILEGE) {this.type = Type.PRIVILEGE;}
    }

    public void beDowngraded(int damage) {
        this.damage = this.damage  - (damage/2);
        if (this.type != Type.GENERAL) {this.type = Type.GENERAL;}
    }

    public void action(Action.Type type, Character to) {
        actions.stream().filter(a -> a.getType() == type)
                .findFirst().get().execute(this, to);
    }

    public enum Type {
        GENERAL, PRIVILEGE
    }
}

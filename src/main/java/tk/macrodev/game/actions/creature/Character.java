package tk.macrodev.game.actions.creature;

import tk.macrodev.game.actions.action.ActionAttack;
import tk.macrodev.game.actions.action.Attack;
import tk.macrodev.game.actions.race.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class Character implements Creature {

    private Race race;
    private Type type;
    private int hp;

    private List<Attack> attacks;

    public Character() {
        race = null;
        type = null;
        hp = 0;
        attacks = new ArrayList<Attack>();
    }

    public Attack getAttack() {
        int i = new Random().nextInt(this.attacks.size());
        Attack action = this.attacks.get(i);

        return action;
    }

    public void executeAttack(Character to, Attack attack) {

        attack.execute(this, to);

        if(this.getType() == Type.PRIVILEGE)
            this.downgrade();
    }

    public void beAttacked(int hp) {
        this.hp = this.hp - hp;
    }

    public void upgrade() {
        for(Attack attack: attacks){
            if(attack instanceof ActionAttack){
                ActionAttack actionAttack = (ActionAttack) attack;
                actionAttack.upDamage();
            }
        }
        if (this.type != Type.PRIVILEGE) {this.type = Type.PRIVILEGE;}
    }

    public void downgrade() {
        for(Attack attack: attacks){
            if(attack instanceof ActionAttack){
                ActionAttack actionAttack = (ActionAttack) attack;
                actionAttack.downDamage();
            }
        }
        if (this.type != Type.GENERAL) {this.type = Type.GENERAL;}
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void addAttacks(Attack attack) {
        this.attacks.add(attack);
    }


}

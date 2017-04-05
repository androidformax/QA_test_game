package tk.macrodev.game.actions.action;

import tk.macrodev.game.actions.creature.Character;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */


public class ActionAttack implements Attack {

    private int damage;
    private AttackType type;

    public ActionAttack(int damage, AttackType type) {
        this.damage = damage;
        this.type = type;
    }

    public ActionAttack() {

    }

    @Override
    public void execute(Character who, Character to) {
        StringBuilder sb = new StringBuilder();
        sb.append(who.getRace()).append("[").append(who.getHp()).append("]");
        sb.append(" make attack by '").append(type).append("' to ");
        sb.append(to.getRace()).append(" [").append(to.getHp()).append("] and inflicted damage ");
        sb.append("\t");
        sb.append(this.damage).append(" hp ");
        sb.append("\t");

        to.beAttacked(this.damage);

        if(to.getHp()<=0)
            sb.append(to.getRace()).append( " is dead.");
        else
            sb.append(to.getRace()).append( " is still alive.");


        System.out.println(sb.toString());

    }

    public void upDamage() {
        this.damage = this.damage + (this.damage/2);
    }

    public void downDamage() {
        this.damage = this.damage - (this.damage/2);
    }

}

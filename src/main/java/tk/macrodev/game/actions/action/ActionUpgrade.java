package tk.macrodev.game.actions.action;

import tk.macrodev.game.actions.creature.Character;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class ActionUpgrade implements Attack {

    private AttackType type;

    public ActionUpgrade(AttackType type) {
        this.type = type;
    }

    public ActionUpgrade() {

    }

    @Override
    public void execute(Character who, Character to) {

        StringBuilder sb = new StringBuilder();
        sb.append(who.getRace()).append(" [").append(who.getHp()).append("] ");
        sb.append(" upgrade ").append(" ");
        sb.append(to.getRace()).append(" [").append(to.getHp()).append("] ");

        to.upgrade();


        System.out.println(sb.toString());


    }

    public AttackType getType() {
        return type;
    }

}

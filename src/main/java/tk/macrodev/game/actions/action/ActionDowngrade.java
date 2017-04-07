package tk.macrodev.game.actions.action;

import tk.macrodev.game.actions.creature.Character;

import static tk.macrodev.game.Log.LOG;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class ActionDowngrade implements Attack {

    private AttackType type;

    public ActionDowngrade(AttackType type) {
        this.type = type;
    }

    public ActionDowngrade() {

    }

    @Override
    public void execute(Character who, Character to) {

        StringBuilder sb = new StringBuilder();
        sb.append(who.getRace()).append(" [").append(who.getHp()).append("] ");
        sb.append(" Inflicted a spell and impaired performance of ").append(" ");
        sb.append(to.getRace()).append(" [").append(to.getHp()).append("] ");


        to.downgrade();

        System.out.println(sb.toString());
        LOG.info(sb.toString());
    }

    public AttackType getType() {
        return type;
    }

}

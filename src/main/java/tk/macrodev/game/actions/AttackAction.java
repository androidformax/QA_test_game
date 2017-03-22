package tk.macrodev.game.actions;

import tk.macrodev.game.Character;
/**
 * Created by androidformax on 20.03.2017.
 */
public class AttackAction implements Action {
    private int damage;
    private Action.Type type;

    public AttackAction(int damage, Action.Type type) {
        this.damage = damage;
        this.type = type;
    }

    public AttackAction() {

    }

    @Override
    public Action.Type getType() {
        return this.type;
    }

    @Override
    public void execute(Character who, Character to) {
        to.beAttacked(this.damage);
    }

}

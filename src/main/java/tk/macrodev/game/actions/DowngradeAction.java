package tk.macrodev.game.actions;

import tk.macrodev.game.Character;

/**
 * Created by androidformax on 20.03.2017.
 */
public class DowngradeAction implements Action {
    private Action.Type type;
    private int damage;

    public DowngradeAction( Action.Type type) {
        this.type = type;
    }

    @Override
    public Action.Type getType() {
        return this.type;
    }

    @Override
    public void execute(Character who, Character to) {
        to.beDowngraded(this.damage);
    }
}
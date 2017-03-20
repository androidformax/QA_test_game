package tk.macrodev.game.actions;

import tk.macrodev.game.Character;

/**
 * Created by androidformax on 20.03.2017.
 */
public class UpgradeAction implements Action {
    private Type type;
    private int damage;

    public UpgradeAction( Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    @Override
    public void execute(Character who, Character to) {
        to.beUpgraded(this.damage);
    }
}


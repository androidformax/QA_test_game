package tk.macrodev.game.actions;

import tk.macrodev.game.Character;
/**
 * Created by androidformax on 20.03.2017.
 */
public interface Action {

    default Type getType() {
        return Type.ATTACK;
    }

    void execute(Character who, Character to);

    enum Type {
        ATTACK, UPGRADE, DOWNGRADE, MAGIC_ATTACK, BOW_ATTACK //Виды аттак
    }


}


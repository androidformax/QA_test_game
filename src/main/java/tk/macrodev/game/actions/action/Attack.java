package tk.macrodev.game.actions.action;

import tk.macrodev.game.actions.creature.Character;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public interface Attack {

    void execute(Character who, Character to);

}

package tk.macrodev.game.actions.generator;

import tk.macrodev.game.actions.creature.CreatureType;

import java.util.Random;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class RandomGenerator {

    private Random rm = new Random();

    public int getInt(int size){
        return rm.nextInt(size);
    }

    public CreatureType elfOrHuman(){
        int i = rm.nextInt(2);

        if(i==0)
            return CreatureType.ELF;
        else
            return CreatureType.HUMAN;
    }


    public CreatureType orkOrUndead(){
        int i = rm.nextInt(2);

        if(i==0)
            return CreatureType.ORK;
        else
            return CreatureType.UNDEAD;
    }

    public AttackerType attacker(){
        int i = rm.nextInt(2);

        if(i==0)
            return AttackerType.GROUP1;
        else
            return AttackerType.GROUP2;
    }

}

package tk.macrodev.game.actions.creature;

import tk.macrodev.game.actions.action.*;
import tk.macrodev.game.actions.race.*;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class CreatureBuilder {

    public Character buildElf(Race race){

        Character elf = new Character();
        elf.setRace(race);
        elf.setHp(100);
        elf.setType(Type.GENERAL);
        if(race == ElfRace.ELF_ARCHER){
            elf.addAttacks(new ActionAttack(7, AttackType.SHOOT_BOW));
            elf.addAttacks(new ActionAttack(3, AttackType.ATTACK));
        }else if(race == ElfRace.ELF_MAG){
            elf.addAttacks(new ActionAttack(10, AttackType.ATTACK));
            elf.addAttacks(new ActionUpgrade(AttackType.UPGRADE));
        }else if(race == ElfRace.ELF_WARRIOR){
            elf.addAttacks(new ActionAttack(15, AttackType.SWORD));
        }

        return elf;
    }

    public Character buildHuman(Race race){

        Character human = new Character();
        human.setRace(race);
        human.setHp(100);
        human.setType(Type.GENERAL);
        if(race == HumanRace.HUMAN_ARCHER){
            human.addAttacks(new ActionAttack(5, AttackType.SHOOT_BOW));
            human.addAttacks(new ActionAttack(3, AttackType.ATTACK));
        }else if(race == HumanRace.HUMAN_MAG){
            human.addAttacks(new ActionAttack(4, AttackType.MAGIC_ATTACK));
            human.addAttacks(new ActionUpgrade(AttackType.UPGRADE));
        }else if(race == HumanRace.HUMAN_WARRIOR){
            human.addAttacks(new ActionAttack(18, AttackType.ATTACK));
        }

        return human;
    }

    public Character buildOrk(Race race){

        Character ork = new Character();
        ork.setRace(race);
        ork.setHp(100);
        ork.setType(Type.GENERAL);
        if(race == OrkRace.ORK_ARCHER){
            ork.addAttacks(new ActionAttack(3, AttackType.SHOOT_BOW));
            ork.addAttacks(new ActionAttack(2, AttackType.ATTACK));
        }else if(race == OrkRace.ORK_SHAMAN){
            ork.addAttacks(new ActionUpgrade(AttackType.UPGRADE));
            ork.addAttacks(new ActionDowngrade(AttackType.DOWNGRADE));
        }else if(race == OrkRace.ORK_GOBLIN){
            ork.addAttacks(new ActionAttack(20, AttackType.ATTACK));
        }

        return ork;
    }


    public Character buildUndead(Race race){

        Character undead = new Character();
        undead.setRace(race);
        undead.setHp(100);
        undead.setType(Type.GENERAL);
        if(race == UndeadRace.UNDEAD_HUNTER){
            undead.addAttacks(new ActionAttack(3, AttackType.SHOOT_BOW));
            undead.addAttacks(new ActionAttack(2, AttackType.ATTACK));
        }else if(race == UndeadRace.UNDEAD_NECROMANCER){
            undead.addAttacks(new ActionUpgrade(AttackType.UPGRADE));
            undead.addAttacks(new ActionDowngrade(AttackType.DOWNGRADE));
        }else if(race == UndeadRace.UNDEAD_ZOMBIE){
            undead.addAttacks(new ActionAttack(20, AttackType.ATTACK));
        }

        return undead;
    }

}

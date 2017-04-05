package tk.macrodev.game;

import tk.macrodev.game.actions.creature.Character;
import tk.macrodev.game.actions.creature.CreatureBuilder;
import tk.macrodev.game.actions.creature.CreatureType;
import tk.macrodev.game.actions.creature.Type;
import tk.macrodev.game.actions.generator.AttackerType;
import tk.macrodev.game.actions.generator.RandomGenerator;
import tk.macrodev.game.actions.race.ElfRace;
import tk.macrodev.game.actions.race.HumanRace;
import tk.macrodev.game.actions.race.OrkRace;
import tk.macrodev.game.actions.race.UndeadRace;

import java.util.ArrayList;

/**
 * Created by androidformax
 *
 * @autor Maksym Naumenko.
 * @since: 03.04.2017
 */
public class PlayGame {

    ArrayList<Character> l1 = new ArrayList<>();
    ArrayList<Character> l2 = new ArrayList<>();

    RandomGenerator randomGenerator = new RandomGenerator();

    public void run(){

        boolean isCont = true;

        do {
            Character who;
            Character to;

            AttackerType attackerType = randomGenerator.attacker();

            if (attackerType == AttackerType.GROUP1) {
                who = getCharacter(l1);
                to = getCharacter(l2);
            } else {
                who = getCharacter(l2);
                to = getCharacter(l1);
            }

            who.attack(to);

            if(to.getHp() < 0){
                if (attackerType == AttackerType.GROUP1) {
                    l2.remove(to);
                } else {
                    l1.remove(to);
                }
            }

            if(l1.size()==0 || l2.size()==0)
                isCont = false;


        }while (isCont);


        System.out.println("finished!");
    }

    private Character getCharacter(ArrayList<Character> list){

        ArrayList<Character> l = new ArrayList<>();

        for (Character ch: list) {
            if(ch.getType() == Type.PRIVILEGE)
                l.add(ch);
        }

        if(l.size()>0)
            return l.get(randomGenerator.getInt(l.size()));
        else
            return list.get(randomGenerator.getInt(list.size()));

    }

    public void load() {

        CreatureBuilder creatureBuilder = new CreatureBuilder();

        if (randomGenerator.elfOrHuman() == CreatureType.ELF) {
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_MAG));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_ARCHER));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_ARCHER));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_ARCHER));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_WARRIOR));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_WARRIOR));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_WARRIOR));
            l1.add(creatureBuilder.buildElf(ElfRace.ELF_WARRIOR));
        } else {
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_MAG));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_ARCHER));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_ARCHER));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_ARCHER));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_WARRIOR));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_WARRIOR));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_WARRIOR));
            l1.add(creatureBuilder.buildHuman(HumanRace.HUMAN_WARRIOR));
        }

        if (randomGenerator.orkOrUndead() == CreatureType.ORK) {
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_SHAMAN));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_ARCHER));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_ARCHER));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_ARCHER));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_GOBLIN));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_GOBLIN));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_GOBLIN));
            l2.add(creatureBuilder.buildOrk(OrkRace.ORK_GOBLIN));
        } else {
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_NECROMANCER));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_HUNTER));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_HUNTER));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_HUNTER));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_ZOMBIE));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_ZOMBIE));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_ZOMBIE));
            l2.add(creatureBuilder.buildUndead(UndeadRace.UNDEAD_ZOMBIE));
        }

    }

}
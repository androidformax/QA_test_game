package tk.macrodev.game;

import tk.macrodev.game.actions.action.ActionUpgrade;
import tk.macrodev.game.actions.action.Attack;
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

import static tk.macrodev.game.Log.LOG;

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

        StringBuilder info = new StringBuilder();
        info.append(l1.get(0).toString()).append( " fight against ")
                .append(l2.get(0).toString());

        System.out.println(info.toString());
        LOG.info(info.toString());

        do {
            Character who;
            Character to;

            AttackerType attackerType = randomGenerator.attacker();

            if (attackerType == AttackerType.GROUP1) {
                who = getCharacter(l1);
            } else {
                who = getCharacter(l2);
            }

            Attack attack = who.getAttack();
            if(attack instanceof ActionUpgrade){
                if (attackerType == AttackerType.GROUP1) {
                    to = getCharacter(l1);
                } else {
                    to = getCharacter(l2);
                }
            }else{
                if (attackerType == AttackerType.GROUP1) {
                    to = getCharacter(l2);
                } else {
                    to = getCharacter(l1);
                }
            }

            who.executeAttack(to, attack);

            if(to.getHp() < 0){
                if (attackerType == AttackerType.GROUP1) {
                    l2.remove(to);
                } else {
                    l1.remove(to);
                }
            }

            if(l1.size()==0){
                Character winner = l2.get(0);
                System.out.println( winner.toString() + " race win!");
                LOG.info(winner.toString() + " race win!");
                isCont = false;
            }

            if(l2.size()==0){
                Character winner = l1.get(0);

                System.out.println( winner.toString() + " race win!");
                LOG.info(winner.toString() + " race win!");

                isCont = false;
            }

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

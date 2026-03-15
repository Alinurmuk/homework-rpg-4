package com.narxoz.rpg.battle;
import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.CombatNode;
import java.util.Random;

public class RaidEngine {
    private Random random = new Random(1L);

    public RaidEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public RaidResult runRaid(CombatNode teamA, CombatNode teamB, Skill sA, Skill sB) {
        RaidResult res = new RaidResult();
        int round = 0;
        res.addLine("--- Battle Start: " + teamA.getName() + " vs " + teamB.getName() + " ---");

        while (teamA.isAlive() && teamB.isAlive() && round < 50) {
            round++;
            res.addLine("\nRound " + round);
            
            res.addLine(teamA.getName() + " attacks with " + sA.getSkillName());
            sA.cast(teamB);

            if (teamB.isAlive()) {
                res.addLine(teamB.getName() + " attacks with " + sB.getSkillName());
                sB.cast(teamA);
            }
        }

        res.setRounds(round);
        res.setWinner(teamA.isAlive() ? teamA.getName() : teamB.getName());
        res.addLine("\nWinner: " + res.getWinner());
        return res;
    }
}
package com.narxoz.rpg;
import com.narxoz.rpg.battle.*;
import com.narxoz.rpg.bridge.*;
import com.narxoz.rpg.composite.*;

public class Main {
    public static void main(String[] args) {
        PartyComposite squad = new PartyComposite("Frontline");
        squad.add(new HeroUnit("Knight", 100, 20));
        squad.add(new HeroUnit("Archer", 80, 15));

        RaidGroup army = new RaidGroup("Crusaders");
        army.add(squad);
        army.add(new HeroUnit("Wizard", 60, 40));

        EnemyUnit boss = new EnemyUnit("Dragon", 800, 50);

        Skill meteor = new AreaSkill("Meteor", 40, new FireEffect());
        Skill claw = new SingleTargetSkill("Claw", 35, new ShadowEffect());

        System.out.println("--- INITIAL ---");
        army.printTree("");
        boss.printTree("");

        RaidEngine engine = new RaidEngine().setRandomSeed(42L);
        RaidResult result = engine.runRaid(army, boss, meteor, claw);

        System.out.println("\n--- LOG ---");
        result.getLog().forEach(System.out::println);

        System.out.println("\n--- FINAL ---");
        army.printTree("");
        boss.printTree("");
    }
}
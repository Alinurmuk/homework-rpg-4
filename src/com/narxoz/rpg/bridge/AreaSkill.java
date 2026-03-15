package com.narxoz.rpg.bridge;
import com.narxoz.rpg.composite.CombatNode;

public class AreaSkill extends Skill {
    public AreaSkill(String name, int bp, EffectImplementor eff) { super(name, bp, eff); }
    @Override
    public void cast(CombatNode target) {
        if (target != null && target.isAlive()) {
            target.takeDamage(resolvedDamage());
        }
    }
}
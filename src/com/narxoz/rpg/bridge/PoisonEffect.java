package com.narxoz.rpg.bridge;
public class PoisonEffect implements EffectImplementor {
    @Override public int computeDamage(int bp) { return (int)(bp * 0.8); }
    @Override public String getEffectName() { return "Poison"; }
}
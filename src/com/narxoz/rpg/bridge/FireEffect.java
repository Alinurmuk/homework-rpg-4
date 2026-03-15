package com.narxoz.rpg.bridge;
public class FireEffect implements EffectImplementor {
    @Override public int computeDamage(int bp) { return (int)(bp * 1.2); }
    @Override public String getEffectName() { return "Fire"; }
}
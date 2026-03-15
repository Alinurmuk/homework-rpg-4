package com.narxoz.rpg.bridge;
public class IceEffect implements EffectImplementor {
    @Override public int computeDamage(int bp) { return (int)(bp * 1.1); }
    @Override public String getEffectName() { return "Ice"; }
}
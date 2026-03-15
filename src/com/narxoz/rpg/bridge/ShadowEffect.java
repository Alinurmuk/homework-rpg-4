package com.narxoz.rpg.bridge;
public class ShadowEffect implements EffectImplementor {
    @Override public int computeDamage(int bp) { return (int)(bp * 1.3); }
    @Override public String getEffectName() { return "Shadow"; }
}
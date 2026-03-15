package com.narxoz.rpg.bridge;
public class LightningEffect implements EffectImplementor {
    @Override public int computeDamage(int bp) { return (int)(bp * 1.5); }
    @Override public String getEffectName() { return "Lightning"; }
}
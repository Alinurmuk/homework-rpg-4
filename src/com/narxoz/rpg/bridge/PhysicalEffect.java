package com.narxoz.rpg.bridge;
public class PhysicalEffect implements EffectImplementor {
    @Override public int computeDamage(int bp) { return bp; }
    @Override public String getEffectName() { return "Physical"; }
}
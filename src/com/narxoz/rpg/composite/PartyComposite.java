package com.narxoz.rpg.composite;
import java.util.*;

public class PartyComposite implements CombatNode {
    private final String name;
    private final List<CombatNode> children = new ArrayList<>();

    public PartyComposite(String name) { this.name = name; }
    public void add(CombatNode node) { children.add(node); }
    public void remove(CombatNode node) { children.remove(node); }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return children.stream().mapToInt(CombatNode::getHealth).sum(); }
    @Override public int getAttackPower() { return children.stream().filter(CombatNode::isAlive).mapToInt(CombatNode::getAttackPower).sum(); }
    @Override public boolean isAlive() { return children.stream().anyMatch(CombatNode::isAlive); }
    @Override public List<CombatNode> getChildren() { return Collections.unmodifiableList(children); }

    @Override
    public void takeDamage(int amount) {
        List<CombatNode> alive = children.stream().filter(CombatNode::isAlive).toList();
        if (!alive.isEmpty()) {
            int splitDamage = amount / alive.size();
            alive.forEach(child -> child.takeDamage(splitDamage));
        }
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "+ Group: " + name + " [Total HP: " + getHealth() + ", ATK: " + getAttackPower() + "]");
        for (CombatNode child : children) child.printTree(indent + "  ");
    }
}
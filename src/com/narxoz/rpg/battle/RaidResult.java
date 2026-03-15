package com.narxoz.rpg.battle;
import java.util.*;

public class RaidResult {
    private String winner;
    private int rounds;
    private final List<String> log = new ArrayList<>();
    public String getWinner() { return winner; }
    public void setWinner(String w) { this.winner = w; }
    public int getRounds() { return rounds; }
    public void setRounds(int r) { this.rounds = r; }
    public void addLine(String line) { log.add(line); }
    public List<String> getLog() { return Collections.unmodifiableList(log); }
}
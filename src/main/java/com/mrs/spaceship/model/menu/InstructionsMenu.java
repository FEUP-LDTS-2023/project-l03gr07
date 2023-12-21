package com.mrs.spaceship.model.menu;

import java.util.Arrays;
import java.util.List;

public class InstructionsMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public InstructionsMenu() { this.entries = Arrays.asList("⬤", "⬤"); }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public int getCurrentEntry() { return currentEntry; }
    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedStay() { return isSelected(0); }

    public boolean isSelectedExit() { return isSelected(1); }

    public int getNumberEntries() {
        return this.entries.size();
    }

}

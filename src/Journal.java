package com.mycompany.mentalproject;

import java.util.ArrayList;
import java.util.List;

class JournalEntry {
    String date;
    String content;

    public JournalEntry(String date, String content) {
        this.date = date;
        this.content = content;
    }

    void display() {
        System.out.println("Date: " + this.date);
        System.out.println("Note: " + this.content);
    }
}

public class Journal {
    List<JournalEntry> entries;

    public Journal() {
        this.entries = new ArrayList<>();
    }

    void addEntry(String date, String content) {
        this.entries.add(new JournalEntry(date, content));
        System.out.println("[SUCCESS] Journal entry added successfully! (" + date + ")");
    }

    void showAllEntries() {
        System.out.println("\n--- JOURNAL ENTRIES ---");
        if (entries.isEmpty()) {
            System.out.println("Journal is currently empty, start writing!");
            return;
        }
        
        for (JournalEntry entry : entries) {
            entry.display();
            System.out.println("--------------------");
        }
    }
}

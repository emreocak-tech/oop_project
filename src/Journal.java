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
        System.out.println("📅 Tarih: " + this.date);
        System.out.println("📝 Not: " + this.content);
    }
}

public class Journal {
    List<JournalEntry> entries;

    public Journal() {
        this.entries = new ArrayList<>();
    }

    void addEntry(String date, String content) {
        this.entries.add(new JournalEntry(date, content));
        System.out.println("✅ Günlük kaydı başarıyla eklendi! (" + date + ")");
    }

    void showAllEntries() {
        System.out.println("\n--- 📖 GÜNLÜK KAYITLARI ---");
        if (entries.isEmpty()) {
            System.out.println("Günlük şu an boş, yazmaya başla!");
            return;
        }
        
        for (JournalEntry entry : entries) {
            entry.display();
            System.out.println("--------------------");
        }
    }
}

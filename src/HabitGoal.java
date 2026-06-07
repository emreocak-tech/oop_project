
package com.mycompany.mentalproject;


public class HabitGoal extends Goal {
    String habitName;
    int streakCount;

    public HabitGoal(String title, int targetCount, String habitName) {
        super(title, targetCount);
        this.habitName = habitName;
        this.streakCount = 0;
    }

    void incrementProgress() {
        this.currentProgress++;
        this.streakCount++;
        System.out.println("📈 [" + this.habitName + "] İlerleme kaydedildi! Mevcut: " 
                           + this.currentProgress + "/" + this.targetCount 
                           + " (Seri: " + this.streakCount + ")");
    }
}

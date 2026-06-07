
package com.mycompany.mentalproject;

public abstract class Goal {
    String title;
    int targetCount;
    int currentProgress;

    public Goal(String title, int targetCount) {
        this.title = title;
        this.targetCount = targetCount;
        this.currentProgress = 0;
    }

    boolean isComplete() {
        return this.currentProgress >= this.targetCount;
    }

    double getProgressPercent() {
        if (this.targetCount == 0) return 0.0;
        return ((double) this.currentProgress / this.targetCount) * 100;
    }
}
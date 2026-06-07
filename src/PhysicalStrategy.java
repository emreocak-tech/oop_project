
package com.mycompany.mentalproject;

class PhysicalStrategy extends CopingStrategy {
    String exercise;

    public PhysicalStrategy(String name, String category, String exercise) {
        super(name, category);
        this.exercise = exercise;
    }

    @Override
    void apply() {
        System.out.println("🏃 Harekete geç: " + this.exercise);
    }
}
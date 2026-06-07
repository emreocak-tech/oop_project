
package com.mycompany.mentalproject;

public class CognitiveStrategy extends CopingStrategy {
    String thoughtReframing;

    public CognitiveStrategy(String name, String category, String thoughtReframing) {
        super(name, category);
        this.thoughtReframing = thoughtReframing;
    }

    @Override
    void apply() {
        System.out.println("🧠 Düşünceni değiştir: " + this.thoughtReframing);
    }
}

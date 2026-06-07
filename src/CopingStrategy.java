
package com.mycompany.mentalproject;

public abstract class CopingStrategy {
    String name;
    String category;

    public CopingStrategy(String name, String category) {
        this.name = name;
        this.category = category;
    }

    abstract void apply();
}

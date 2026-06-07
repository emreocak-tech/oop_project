package com.mycompany.mentalproject;

public abstract class Activity implements Command {
    String name;
    int duration;
    String description;
    
    void complete() {
        System.out.println("✅ [" + this.name + "] aktivitesi başarıyla tamamlandı!");
    }
}

package com.mycompany.mentalproject;

public class BreathingExercise extends Activity {
    String pattern;
    int cycleCount;

    @Override
    public void execute(String[] optionalParameters) {
        
        super.name = optionalParameters[0];
        super.duration = Integer.parseInt(optionalParameters[1]);  
        super.description = optionalParameters[2];
        pattern = optionalParameters[3];
        cycleCount = Integer.parseInt(optionalParameters[4]);
        
        System.out.println("Nefes egzersizi başlıyor... (Ritim: " + this.pattern + ", Tekrar: " + this.cycleCount + ")");
        
        super.complete();
    }
}


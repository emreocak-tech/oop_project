package com.mycompany.mentalproject;

import java.util.Random;

public class Advices implements Command {
        
    Random random = new Random();
    
    String[] advices = new String[]{
        "If you teach a man to fish, you feed him for one day. If you feed him to the fishes then he’ll never be hungry again.",
        "Trust dogs. They always know who to stay away from.",
        "If you attempt to rob a bank, you will have no trouble with rent or bills for the next ten years, whether you are successful or not."
    };
    
    @Override
    public void execute(String[] optionalParameters)
    {
        System.out.println(advices[random.nextInt(advices.length)]);
    }
    
    
    
}

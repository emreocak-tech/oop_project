package com.mycompany.mentalproject;

import java.util.Random;

public class Advices implements Command {
        
    Random random = new Random();
    
    String[] advices = new String[]{
        "If you teach a man to fish, you feed him for one day. If you feed him to the fishes then he'll never be hungry again.",
        "Trust dogs. They always know who to stay away from.",
        "If you attempt to rob a bank, you will have no trouble with rent or bills for the next ten years, whether you are successful or not.",
        "The early bird might get the worm, but the second mouse gets the cheese.",
        "If at first you don't succeed, skydiving is definitely not for you.",
        "Always write your code as if the person who ends up maintaining it is a violent psychopath who knows where you live.",
        "They say what doesn't kill you makes you stronger. So theoretically, failing a heavy squat is just rapid character development.",
        "Whenever life gets too hard, just remember: at least you are not trying to dodge roll through a poison swamp right now.",
        "Before you marry a person, you should first make them use a computer with slow internet to see who they really are.",
        "To err is human. To blame it on a compiler shows true developer potential.",
        "If you think nobody cares if you are alive, try missing a couple of credit card payments.",
        "Never put off till tomorrow what you can completely ignore forever.",
        "A clear conscience is usually the sign of a bad memory.",
        "Money cannot buy happiness, but it is much more comfortable to cry in a sports car than on a bicycle.",
        "I intend to live forever. So far, so good."
    };
    
    @Override
    public void execute(String[] optionalParameters)
    {
        System.out.println(advices[random.nextInt(advices.length)]);
    }
    
}

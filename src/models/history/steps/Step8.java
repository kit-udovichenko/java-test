package models.history.steps;

import models.history.StepBase;

public class Step8 extends StepBase {
    public Step8() {
        super("The little fox waited a little, and the bees scattered. \n" +
                "The little fox collected honey without any problems. \n" +
                "Suddenly he realized that he was very hungry. What to do?");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. Eat a little and take a break.");
        System.out.println("2. Hurry up and take the honey to Little Bear.");
    }

    @Override
    public void firstChoose() {
        var stepLost3 = new StepLost3();
        stepLost3.startStep();
    }

    @Override
    public void secondChoose() {
        var step9 = new Step9();
        step9.startStep();
    }
}

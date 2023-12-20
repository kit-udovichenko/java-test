package models.history.steps;

import models.history.StepBase;

public class Step5 extends StepBase {
    public Step5() {
        super("The wolf turned out to be quite friendly but could not help. \n" +
                "He just said that the little fox should not wander through the forest alone. And what should I do now?");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. The wolf is right.");
        System.out.println("2. Search for Little Squirrel alone.");
    }

    @Override
    public void firstChoose() {
        var stepFinal = new StepFinal();
        stepFinal.startStep();
    }

    @Override
    public void secondChoose() {
        var stepLost1 = new StepLost1();
        stepLost1.startStep();
    }
}

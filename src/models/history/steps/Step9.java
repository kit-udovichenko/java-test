package models.history.steps;

import models.history.StepBase;

public class Step9 extends StepBase {
    public Step9() {
        super("The satisfied Little Bear told Little Fox that he knew the Squirrel family very well and was sure that Little Little Squirrel would never go deep into the forest. \n" +
                "He assured Little Fox that Squirrels don't get into trouble and that Owls can't be trusted, and he also tried to persuade Little Fox to return home.");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. The little bear doesn’t know anything; we need to continue the search.");
        System.out.println("2. Maybe he's right and Little Fox is just panicking.");
    }

    @Override
    public void firstChoose() {
        var stepLost1 = new StepLost1();
        stepLost1.startStep();
    }

    @Override
    public void secondChoose() {
        var stepFinal = new StepFinal();
        stepFinal.startStep();
    }
}

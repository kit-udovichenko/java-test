package models.history.steps;

import models.history.StepBase;

public class Step6 extends StepBase {
    public Step6() {
        super("In the depths of the forest, the Little Fox met the Little Bear. \n" +
                "The lazy Little Bear was ready to tell everything he knew if the Little Fox brought him honey.");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. No, too much time has been spent, we need to move on.");
        System.out.println("2. We need to take this chance and get some honey.");
    }

    @Override
    public void firstChoose() {
        var stepLost1 = new StepLost1();
        stepLost1.startStep();
    }

    @Override
    public void secondChoose() {
        var step7 = new Step7();
        step7.startStep();
    }
}

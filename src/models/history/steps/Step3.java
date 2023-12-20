package models.history.steps;

import models.history.StepBase;

public class Step3 extends StepBase {
    public Step3() {
        super("While Little Fox was making a decision, the forest inhabitants dispersed in all directions. \n" +
                "Only the Owl and the Wolf remained. \n" +
                "But the Owl can have memory problems, and the Wolf can get very angry due to questions. Whom to choose?");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. Ask Owl.");
        System.out.println("2. Ask Wolf.");
    }

    @Override
    public void firstChoose() {
        var step4 = new Step4();
        step4.startStep();
    }

    @Override
    public void secondChoose() {
        var step5 = new Step5();
        step5.startStep();
    }
}

package models.history.steps;

import models.history.StepBase;

public class Step7 extends StepBase {
    public Step7() {
        super("The little fox quickly found honey, but a swarm of angry bees was flying around. \n" +
                "The little fox was always afraid of bees, but he was also afraid of not finding a friend.");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. Wait till the bees fly away.");
        System.out.println("2. Try to steal the honey immediately.");
    }

    @Override
    public void firstChoose() {
        var step8 = new Step8();
        step8.startStep();
    }

    @Override
    public void secondChoose() {
        var stepLost2 = new StepLost2();
        stepLost2.startStep();
    }
}

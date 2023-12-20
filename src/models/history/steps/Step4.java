package models.history.steps;

import models.history.StepBase;

public class Step4 extends StepBase {
    public Step4() {
        super("The Owl did not want to speak for a long time, but in the end, she said that she saw a frightened Little Squirrel running deep into the forest. \n" +
                "All forest dwellers know that in the depths of the forest it is dangerous, if Little Squirrel is there, he urgently needs help.");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. Trust the Owl and go deep into the forest.");
        System.out.println("2. We need to take this chance and get some honey.");
    }

    @Override
    public void firstChoose() {
        var step6 = new Step6();
        step6.startStep();
    }

    @Override
    public void secondChoose() {
        var stepLost1 = new StepLost1();
        stepLost1.startStep();
    }
}

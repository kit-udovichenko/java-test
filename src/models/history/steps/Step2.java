package models.history.steps;

import models.history.StepBase;

import java.util.Scanner;

public class Step2 extends StepBase {
    public Step2() {
        super("All the forest inhabitants were busy with their own affairs and did not pay attention to the Little Fox and his problem. \n" +
                "But suddenly someone saw Little Squirrel... Little Fox didn’t know what to do. Help him.");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. Try to find out about Little Squirrel from the forest inhabitants.");
        System.out.println("2. Search for Little Squirrel alone");
    }

    @Override
    public void firstChoose() {
        var step3 = new Step3();
        step3.startStep();
    }

    @Override
    public void secondChoose() {
        var stepLost1 = new StepLost1();
        stepLost1.startStep();
    }
}

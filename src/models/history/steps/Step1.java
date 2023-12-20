package models.history.steps;

import models.history.StepBase;

public class Step1 extends StepBase {
    public Step1() {
        super("Every morning Little Fox woke up, had breakfast, and went to see Little Squirrel. \n" +
                "This morning was no exception. Little Fox came to their usual meeting place, but Little Squirrel was not there. \n" +
                "The little fox waited and waited but his friend didn’t come. The little squirrel has not missed a single meeting yet. \n" +
                "“Suddenly he got into trouble” thought the Little Fox. What should the Little Fox do?\n");
    }

    @Override
    public void getWriteAllWays() {
        System.out.println("1. Return back");
        System.out.println("2. Go for search");
    }

    @Override
    public void firstChoose() {
        var stepFinal = new StepFinal();
        stepFinal.startStep();
    }

    @Override
    public void secondChoose() {
        var step2 = new Step2();
        step2.startStep();
    }
}
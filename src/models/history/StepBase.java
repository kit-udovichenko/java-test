package models.history;

import models.menu.Menu;
import models.menu.MenuView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StepBase {
    public StepBase(String description) {

        Description = description;
        NameForSave = this.getClass().getName();
    }

    private String Description;

    public String NameForSave;

    //Start step 1
    public void startStep(){
        commonText();
        getWriteAllWays();

        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.hasNext()) {
                chooseWay(scanner.nextInt());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    //Common text for all steps
    private void commonText() {
        System.out.println(Description);
        System.out.println("-----------------");
        System.out.println("| 3. Go to menu |");
        System.out.println("-----------------");
        System.out.println("Choose you way:");
    }

    //Write ways of step
    protected void getWriteAllWays() {
    }

    ///Choose way
    private void chooseWay(Integer wayNumber) {
        switch (wayNumber) {
            case 3:
                var menu = new Menu(MenuView.Continue, this);
                menu.writeMenuAndStart();
                break;
            case 1:
                firstChoose();
                break;
            case 2:
                secondChoose();
                break;
        }
    }

    //First section choise
    protected void firstChoose(){
    }

    //Second section choise
    protected void secondChoose(){
    }
}

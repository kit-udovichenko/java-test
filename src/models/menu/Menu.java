package models.menu;

import models.history.StepBase;
import models.history.steps.Step1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//List of menu
public class Menu {
    public Menu(MenuView view, StepBase currentStep) {

        MenuView = view;
        CurrentStep = currentStep;
    }

    private StepBase CurrentStep;

    //View if menu
    private MenuView MenuView;

    //Change view menu from start to continue and reverse
    public void changeView() {
        MenuView = MenuView == models.menu.MenuView.Start ? models.menu.MenuView.Continue : models.menu.MenuView.Start;
    }

    //Write in console sections of menu and start
    public void writeMenuAndStart() {
        if (MenuView == models.menu.MenuView.Start) {
            System.out.println("1. " + menuSections.get(MenuType.StartGame));
            System.out.println("2. " + menuSections.get(MenuType.LoadGame));
            System.out.println("3. " + menuSections.get(MenuType.Exit));
        } else {
            System.out.println("1. " + menuSections.get(MenuType.ContinueGame));
            System.out.println("2. " + menuSections.get(MenuType.SaveGame));
            System.out.println("3. " + menuSections.get(MenuType.LoadGame));
            System.out.println("4. " + menuSections.get(MenuType.StartNewGame));
            System.out.println("5. " + menuSections.get(MenuType.Exit));
        }

        listeningKeyBoard();
    }

    private void listeningKeyBoard() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Select the menu item: ");
            chooseMenuItem(MenuType.values()[scanner.nextInt()]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Map<MenuType, String> menuSections = new HashMap<>(){{
        put(MenuType.StartGame, "Start game");
        put(MenuType.LoadGame, "Load game");
        put(MenuType.Exit, "Exit");
        put(MenuType.ContinueGame, "Continue game");
        put(MenuType.SaveGame, "Save game");
        put(MenuType.StartNewGame, "Start new game");
    }};

    //Choose section menu
    public void chooseMenuItem(MenuType menuSection) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (MenuView == models.menu.MenuView.Continue) {
            switch (menuSection)
            {
                case StartGame:
                    menuSection = MenuType.ContinueGame;
                    break;
                case LoadGame:
                    menuSection = MenuType.SaveGame;
                    break;
                case Exit:
                    menuSection = MenuType.LoadGame;
                    break;
                case ContinueGame:
                    menuSection = MenuType.StartNewGame;
                    break;
                case SaveGame:
                    menuSection = MenuType.Exit;
                    break;
            }
        }

        switch (menuSection) {
            case StartGame:
            case StartNewGame:
                var step1 = new Step1();
                step1.startStep();
                break;
            case ContinueGame:
                if (CurrentStep != null) {
                    CurrentStep.startStep();
                } else {
                    System.out.println("You cant continue game.");
                    var menu = new Menu(MenuView.Start, null);
                    menu.writeMenuAndStart();
                }
                break;
            case SaveGame:
                SaveGame(CurrentStep);
                break;
            case LoadGame:
                LoadGame();
                break;
            case Exit:
            case None:
                System.exit(0);
        }
    }

    private String CreateSavePath(String nameFile) {
        return "src/saves/" + nameFile +".save";
    }

    private void SaveGame(StepBase currentStep) {
        String nameFile = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write name of file for save:");
            nameFile = scanner.nextLine();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (nameFile == null) {
            SaveGame(currentStep);
            return;
        }

        var path = CreateSavePath(nameFile);
        File f = new File(path);
        if(f.exists() && !f.isDirectory()) {
            System.out.println("File with this name is exist. Try another filename.");
            SaveGame(currentStep);
            return;
        }

        try (ObjectOutputStream output2 = new ObjectOutputStream(new FileOutputStream(path))) {
            output2.writeObject(currentStep.NameForSave);
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void LoadGame() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String nameFile = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write name of file for load:");
            nameFile = scanner.nextLine();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        if (nameFile == null || nameFile == "") {
            LoadGame();
            return;
        }

        var path = CreateSavePath(nameFile);
        File f = new File(path);
        if(!f.exists()) {
            System.out.println("File with this name is not exist. Try another filename.");
            LoadGame();
            return;
        }
        String stepSaved = null;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))){
            stepSaved = (String) input.readObject();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        CreateStep(stepSaved);
    }

    private void CreateStep(String nameForSave) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(nameForSave);
        StepBase date = (StepBase) clazz.newInstance();
        date.startStep();
    }
}

import models.menu.Menu;
import models.menu.MenuView;

public class Main {
    public static void main(String[] args) {
        var menu = new Menu(MenuView.Start, null);
        menu.writeMenuAndStart();
    }
}
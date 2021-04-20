package Panel;

import Main.Display;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    //КОНСТАНТЫ
    public static final int MAIN_WIDTH = GamePanel.GAME_WIDTH + MenuPanel.MENU_WIDTH;
    public static final int MAIN_HEIGHT = 500;

    //конструктор
    public MainPanel() {
        createGUI(true, MAIN_WIDTH, MAIN_HEIGHT);
    }

    //создание интерфейса
    private void createGUI(Boolean isVisible, int width, int height) {
        //параметры
        this.setSize(width, height);
        this.setVisible(isVisible);
        //магия
        this.setLayout(null);
        //добавление дочерних панелей
        this.add(new MenuPanel());
        this.add(new GamePanel());
    }
}
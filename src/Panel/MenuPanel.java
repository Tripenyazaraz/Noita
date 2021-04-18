package Panel;

import javax.swing.*;

public class MenuPanel extends JPanel {

    //КОНСТАНТЫ
    public static int WIDTH = 300;
    public static int HEIGHT = MainPanel.HEIGHT;

    //конструктор
    public MenuPanel() {
        createGUI(true, WIDTH, HEIGHT);
    }

    //создание интерфейса
    public void createGUI(Boolean isVisible, int gameWidth, int gameHeight) {
        this.setSize(gameWidth, gameHeight);     //задать размер игровой панели
        this.setVisible(isVisible);              //показать игровую панель
    }
}
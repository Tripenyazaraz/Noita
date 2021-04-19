package Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    //КОНСТАНТЫ
    public final static int WIDTH = 300;
    public final static int HEIGHT = MainPanel.HEIGHT;

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


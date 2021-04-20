package Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    //КОНСТАНТЫ
    public static final int MENU_WIDTH = 300;
    public static final int MENU_HEIGHT = MainPanel.MAIN_HEIGHT;

    //конструктор
    public MenuPanel() {
        createGUI(true, MENU_WIDTH, MENU_HEIGHT);
    }

    private void createGUI(Boolean isVisible, int width, int height) {
        //параметры
        this.setSize(width, height);
        this.setVisible(isVisible);
        this.setLocation(GamePanel.GAME_WIDTH, 0);
        //цвет
        this.setBackground(Color.BLUE);
    }
}
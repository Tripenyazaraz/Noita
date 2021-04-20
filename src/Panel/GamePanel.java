package Panel;

import Main.Display;
import Pixel.PixelInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class GamePanel extends JPanel {
    //КОНСТАНТЫ
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = MainPanel.MAIN_HEIGHT;

    //конструктор
    public GamePanel() {
        createGUI(true, GAME_WIDTH, GAME_HEIGHT);
    }

    private void createGUI(Boolean isVisible, int width, int height) {
        //параметры
        this.setSize(width, height);
        this.setVisible(isVisible);
        //цвет
        this.setBackground(Color.RED);
    }
}
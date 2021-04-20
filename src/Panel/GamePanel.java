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

public class GamePanel extends JPanel implements ActionListener {
    //таймер
    Timer timer = new Timer(20, this);

    //КОНСТАНТЫ
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = MainPanel.MAIN_HEIGHT;
    //переменные
    private Image img1 = new ImageIcon("Textures/Pixel/Powder/texture_Sand.jpg").getImage();
    private Image img2 = new ImageIcon("Textures/Pixel/Powder/texture_Sand.jpg").getImage();
    private Image img3 = new ImageIcon("Textures/Pixel/Powder/texture_Sand.jpg").getImage();

    //конструктор
    public GamePanel() {
        createGUI(true, GAME_WIDTH, GAME_HEIGHT);
        timer.start();
    }

    private void createGUI(Boolean isVisible, int width, int height) {
        //параметры
        this.setSize(width, height);
        this.setVisible(isVisible);
        this.setBackground(Color.RED);
    }

    public void paint(Graphics g) {
        this.setBackground(Color.RED);
        g.drawImage(img1, 0, 0, 10, 10, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
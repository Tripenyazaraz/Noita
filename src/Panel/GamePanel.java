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
    Timer timer = new Timer(20,  this);

    //КОНСТАНТЫ
    public static final int GAME_WIDTH = 500;
    public static final int GAME_HEIGHT = MainPanel.MAIN_HEIGHT;
    //переменные
    private Image img1 = new ImageIcon("Textures/Pixel/Powder/texture_Sand.jpg").getImage();
    private Image imgBG = new ImageIcon("Textures/GamePanelBG.jpg").getImage();

    //конструктор
    public GamePanel() {
        createGUI(true, GAME_WIDTH, GAME_HEIGHT);
        timer.start();
    }

    private void createGUI(Boolean isVisible, int width, int height) {
        //параметры
        this.setSize(width, height);
        this.setVisible(isVisible);
        this.setLocation(0 , 0);

        JButton button = new JButton("я тоже");
        button.setSize(150,50);
        button.setLocation(50,50);
        button.setVisible(true);
        this.add(button);
    }

    public void paint(Graphics g) {
        g.drawImage(imgBG, 0, 0, this.getWidth(), this.getHeight(), null);
        g.drawImage(img1, 0, 0, 10, 10, null);
        super.paintComponents(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
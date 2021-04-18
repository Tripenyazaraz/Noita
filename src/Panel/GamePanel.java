package Panel;

import Main.Display;
import Pixel.PixelInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements ActionListener {

    //КОНСТАНТЫ
    public static int WIDTH = 500;
    public static int HEIGHT = MainPanel.HEIGHT;

    //ПЕРЕМЕННЫЕ
    Timer timerDraw = new Timer(20, this);                                      //объяявление таймера
    Image bgImage = new ImageIcon("textures/texture_GamePanelBG.jpg").getImage();    //текстура бг

    //тестовая ебала
    PixelInterface[] array = new PixelInterface[100];

    //конструктор
    public GamePanel() {
        createGUI(true, WIDTH, HEIGHT);
    }

    //создание интерфейса
    public void createGUI(Boolean isVisible, int gameWidth, int gameHeight) {
        this.setSize(gameWidth, gameHeight);     //задать размер игровой панели
        this.setVisible(isVisible);              //показать игровую панель
        timerDraw.start();                       //запуск таймера

        //действие при клике мышкой
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                generate();
            }
        });
    }

    //прорисовка
    public void paint(Graphics g) {
        g.drawImage(bgImage, 0, 0, WIDTH, HEIGHT, null);          //рисует бг
    }

    //это выполняется по таймеру
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    //тестовая ебала
    public void generate() {
        for(int i = 0; i < 10; i++){
            if (i % 2 == 0)
                array[i] = new Pixel.Gas.Steam();
            else
                array[i] = new Pixel.Liquid.Water();
            array[i].generate();
        }
    }
}
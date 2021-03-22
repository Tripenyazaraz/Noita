package Panel;

import Main.Display;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements ActionListener {

    //MainPanel panel;      //я не знаю зачем это но пока работает и без этого
    Timer timerDraw = new Timer(20, this);                                  //объяявление таймера
    Image bgImage = new ImageIcon("textures/texture_GamePanelBG.jpg").getImage();                 //текстура бг

    //конструктор
    public GamePanel(MainPanel panel) {
        this.setSize(Display.panelGameWidth, Display.panelHeight);          //задать размер игровой панели
        this.setVisible(true);                                              //показать игровую панель
        timerDraw.start();                                                  //запуск таймера
        //this.panel = panel;       //я не знаю зачем это но пока работает и без этого

        //действие при клике мышкой
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Пиксель был сгенерирован");
            }
        });
    }

    //прорисовка
    public void paint(Graphics g) {
        g.drawImage(bgImage, 0, 0, Display.panelGameWidth, Display.panelHeight, null);          //рисует бг
    }

    //это выполняется по таймеру
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
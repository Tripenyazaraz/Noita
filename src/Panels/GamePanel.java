package Panels;

import Main.Display;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {

    MainPanel panel;
    Timer timerDraw = new Timer(20, this);
    Image bgImage = new ImageIcon("textures/BG.jpg").getImage();

    public GamePanel(MainPanel panel) {
        this.setSize(Display.panelGameWidth, Display.panelHeight);
        this.setVisible(true);
        timerDraw.start();
        this.panel = panel;
    }

    public void paint(Graphics g) {
        g.drawImage(bgImage, 0, 0, Display.panelGameWidth, Display.panelHeight, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
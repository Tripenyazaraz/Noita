import Pixels.Sand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JPanel implements ActionListener {

    Timer timerDraw = new Timer(20, this);
    JFrame frame;

    public Main(JFrame frame) {
        timerDraw.start();
        frame.setSize(Display.panelWidth, Display.panelHeight);
        this.frame = frame;

        frame.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("типо писок");
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(Display.bgImage, 0, 0, Display.panelWidth, Display.panelHeight, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    Timer timer = new Timer(20, this);
    Image bgImage = new ImageIcon("textures/BG.jpg").getImage();
    JFrame frame;

    public Main(JFrame frame) {
        timer.start();
        this.frame = frame;
    }

    public void paint(Graphics g) {
        g.drawImage(bgImage, 0, 0, Display.panelWidth, Display.panelHeight, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

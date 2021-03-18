import javax.swing.*;
import java.awt.*;

public class Display {

    public static int panelWidth = 700;
    public static int panelHeight = 700;
    public static Image bgImage = new ImageIcon("textures/BG.jpg").getImage();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Noita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(panelWidth+300, panelHeight);
        frame.setResizable(false);
        frame.add(new Main(frame));
        frame.setVisible(true);
    }
}

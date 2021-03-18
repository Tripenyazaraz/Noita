import javax.swing.*;

public class Display {

    public static int panelWidth = 700;
    public static int panelHeight = 700;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Noita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(panelWidth+300, panelHeight);
        frame.setResizable(false);
        frame.add(new Main(frame));
        frame.setVisible(true);
    }
}

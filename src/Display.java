import javax.swing.*;

public class Display {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Noita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setResizable(false);
        frame.add(new Main(frame));
        frame.setVisible(true);
    }
}

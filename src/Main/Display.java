package Main;

import Panel.GamePanel;
import Panel.MainPanel;

import javax.swing.*;

public class Display {

    public static void main(String[] args) {
        createMainFrame(true, true, MainPanel.WIDTH, MainPanel.HEIGHT);
    }

    public static void createMainFrame(Boolean isResizable, Boolean isVisible, int mainWidth, int mainHeight) {
        //объявление главной рамки
        JFrame MainFrame = new JFrame("Noita");                       //название в рамке
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          //операция закрытия окны при нажатии на крестик
        MainFrame.setResizable(isResizable);                                     //запретить изменение размеров окна

        //размеры рамки
        MainFrame.setSize(mainWidth, mainHeight);

        //появление главной рамки
        MainFrame.setVisible(isVisible);

        //добавление общей панели
        MainFrame.add(new MainPanel());
    }
}
package Main;

import Panel.MainPanel;

import javax.swing.*;

public class Display {

    //размеры панелей
    public static int panelHeight = 500;
    public static int panelGameWidth = 500;
    public static int panelMenuWidth = 300;

    public static void main(String[] args) {
        //объявление главной рамки
        JFrame mainFrame = new JFrame("Noita");                       //название в рамке
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          //операция закрытия окны при нажатии на крестик
        mainFrame.setResizable(false);                                     //запретить изменение размеров окна

        //размеры рамки
        mainFrame.setSize(panelGameWidth + panelMenuWidth, panelHeight);

        //появление главной рамки
        mainFrame.setVisible(true);

        //добавление общей панели
        mainFrame.add(new MainPanel(mainFrame));
    }
}
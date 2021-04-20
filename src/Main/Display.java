package Main;

import Panel.GamePanel;
import Panel.MainPanel;
import com.sun.tools.javac.Main;

import javax.swing.*;

public class Display {
    //НАЧАЛО
    public static void main(String[] args) {
        CreateGUI(true,false, MainPanel.MAIN_WIDTH, MainPanel.MAIN_HEIGHT);
    }

    private static void CreateGUI(Boolean isVisible, Boolean isResizable, int width, int height) {
        //создание рамки, её параметры
        JFrame MainFrame = new JFrame("Noita");
        MainFrame.setResizable(isResizable);
        MainFrame.setSize(width, height);
        MainFrame.setVisible(isVisible);
        //добавление панели
        MainFrame.add(new MainPanel());
    }
}
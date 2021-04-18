package Panel;

import Main.Display;
import javax.swing.*;

public class MainPanel extends JPanel {

    //константы
    public static int HEIGHT = 500;
    public static int WIDTH = GamePanel.WIDTH + MenuPanel.WIDTH;

    //конструктор
    public MainPanel() {
        createGUI(true, WIDTH, HEIGHT);
    }

    //создание интерфейса
    public void createGUI(Boolean isVisible, int mainWidth, int mainHeight) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));     //определить расположение дочерних панелей
        this.setSize(mainWidth, mainHeight);                             //размер главной панели
        this.setVisible(isVisible);                                      //появление главной панели
        this.add(new GamePanel());                                       //добавление игровой панели
        this.add(new MenuPanel());                                       //добавление панели меню
    }
}

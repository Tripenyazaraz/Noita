package Panel;

import Main.Display;
import javax.swing.*;

public class MainPanel extends JPanel {
    //конструктор
    public MainPanel(JFrame frame) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));                                  //определить расположение дочерних панелей
        this.setSize(Display.panelGameWidth + Display.panelMenuWidth, Display.panelHeight);     //размер главной панели
        this.setVisible(true);                                                                        //появление главной панели
        this.add(new GamePanel(this));          //добавление игровой панели
        this.add(new MenuPanel(this));          //добавление панели меню
    }
}

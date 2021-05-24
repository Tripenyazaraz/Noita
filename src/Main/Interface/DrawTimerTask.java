package Main.Interface;

import Main.Engine;
import Main.Noita_UI;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.TimerTask;

public class DrawTimerTask extends TimerTask {
    GraphicsContext gc;

    public DrawTimerTask(GraphicsContext gc, Engine engine) {
        this.gc = gc;
    }

    @Override
    public void run() {
        draw(gc);
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, Noita_UI.GAME_PANEL_WIDTH, Noita_UI.HEIGHT);
    }
}

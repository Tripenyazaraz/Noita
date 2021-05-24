package Main.Interface;

import Main.Engine;
import Main.Noita_UI;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.TimerTask;
import Particle.*;

public class DrawTimerTask extends TimerTask {
    GraphicsContext gc;
    Engine engine;

    public DrawTimerTask(GraphicsContext gc, Engine engine) {
        this.gc = gc;
        this.engine = engine;
    }

    @Override
    public void run() {
        draw(gc);
    }

    public void draw(GraphicsContext gc) {
        engine.step();
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, Noita_UI.GAME_PANEL_WIDTH, Noita_UI.HEIGHT);
        gc.setFill(Color.RED);
        for(int y = 0; y < Engine.width; y++) {
            for(int x = 0; x < Engine.height; x++) {
                if ((Engine.field[x][y] instanceof Sand)|(Engine.field[x][y] instanceof Stone)) {
                    gc.fillRect(x, y, 2, 2);
                }
            }
        }
    }
}

package Main.Interface;

import Main.Engine;
import Main.Noita_UI;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.TimerTask;
import Particle.*;

public class DrawTimerTask extends TimerTask {
    GraphicsContext gc;
    Engine engine = Noita_UI.engine;

    public DrawTimerTask(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void run() {
        engine.step();
        draw(gc);
    }

    public void draw(GraphicsContext gc) {
        Platform.runLater(()->{
            gc.fillRect(0, 0, Noita_UI.GAME_PANEL_WIDTH, Noita_UI.HEIGHT);
            for(int y = 0; y < Engine.width-1; y++) {
                for(int x = 0; x < Engine.height-1; x++) {
                         if (Engine.field[x][y] == null) { gc.setFill(Color.GRAY); }
                    else if (Engine.field[x][y] instanceof Sand)  { gc.setFill(Color.YELLOW); }
                    else if (Engine.field[x][y] instanceof Water) { gc.setFill(Color.BLUE); }
                    else if (Engine.field[x][y] instanceof Steam) { gc.setFill(Color.WHITE); }
                    else if (Engine.field[x][y] instanceof Stone) { gc.setFill(Color.LIGHTGRAY); }
                    //else if (Engine.field[x][y] instanceof Acid) { gc.setFill(Color.GREEN); }
                    //else if (Engine.field[x][y] instanceof Oil)  { gc.setFill(Color.BLACK); }
                    //else if (Engine.field[x][y] instanceof Wood) { gc.setFill(Color.BROWN); }
                    //else if (Engine.field[x][y] instanceof Fire) { gc.setFill(Color.RED); }
                    gc.fillRect(x,y,1,1);
                }
            }
        });

    }
}

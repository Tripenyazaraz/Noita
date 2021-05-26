package Main.Interface;

import Main.Engine;
import Main.Noita;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.TimerTask;
import Particle.*;

public class DrawTimerTask extends TimerTask {
    GraphicsContext gc;
    Engine engine = Noita.engine;

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
            gc.fillRect(0, 0, Noita.GAME_WIDTH, Noita.HEIGHT);
            for(int y = 0; y < Engine.height; y++) {
                for(int x = 0; x < Engine.width; x++) {
                         if (Engine.field[x][y] == null)           gc.setFill(Color.SILVER);  //TAN
                    else if (Engine.field[x][y] instanceof Sand)   gc.setFill(Color.YELLOW);
                    else if (Engine.field[x][y] instanceof Water)  gc.setFill(Color.BLUE);
                    else if (Engine.field[x][y] instanceof Steam)  gc.setFill(Color.rgb(198,215,215));
                    else if (Engine.field[x][y] instanceof Stone)  gc.setFill(Color.rgb(91,85,77));
                    else if (Engine.field[x][y] instanceof Acid)   gc.setFill(Color.LIMEGREEN);
                    else if (Engine.field[x][y] instanceof Oil)    gc.setFill(Color.rgb(43,7,49));
                    else if (Engine.field[x][y] instanceof Wood)   gc.setFill(Color.rgb(115, 67, 16));
                    else if (Engine.field[x][y] instanceof Fire)  { if (Math.random() < 0.5) gc.setFill(Color.ORANGERED);
                                                                    else                     gc.setFill(Color.ORANGE); }
                    gc.fillRect(x,y,1,1);
                }
            }
        });
    }
}

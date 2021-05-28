package Main;
import Particle.*;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Engine {
    public static int width = Noita.GAME_WIDTH;
    public static int height = Noita.HEIGHT;
    public static BaseParticle[][] field = new BaseParticle[width][height];
    Integer[] rx = new Integer[width];

    public Engine() {
        for(int x = 0; x <= width-1; x++) {
            rx[x]=x;
        }
    }

    //шаг физики
    public void step() {
        List<Integer> intList = Arrays.asList(rx);
        Collections.shuffle(intList);
        intList.toArray(rx);
        for(int y = height-1; y >= 0; y--) {
            for(int x = 0; x <= width-1; x++) {
                if (field[rx[x]][y] != null) {
                    field[rx[x]][y].update();
                }
            }
        }
    }

    //очищение
    public void clean() {
        for(int y = height-1; y >= 0; y--) {
            for(int x = 0; x <= width-1; x++) {
                field[x][y] = null;
            }
        }
    }

    //создание частицы
    public void createParticle(String particleName, int x, int y) {
        switch (particleName) {
            case ("erase") -> Engine.field[x][y] = null;
            case ("sand")  -> Engine.field[x][y] = new Sand( x,y);
            case ("water") -> Engine.field[x][y] = new Water(x,y);
            case ("steam") -> Engine.field[x][y] = new Steam(x,y);
            case ("stone") -> Engine.field[x][y] = new Stone(x,y);
            case ("acid")  -> Engine.field[x][y] = new Acid( x,y);
            case ("oil")   -> Engine.field[x][y] = new Oil(  x,y);
            case ("wood")  -> Engine.field[x][y] = new Wood( x,y);
            case ("fire")  -> {if (Engine.field[x][y] == null)   Engine.field[x][y] = new Fire(x,y);
                               else if (Engine.field[x][y].fuel) Engine.field[x][y] = new Fire(x,y);}
        }
    }

    //прорисовка
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

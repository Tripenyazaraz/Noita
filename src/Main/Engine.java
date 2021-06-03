package Main;

import Particle.*;
import Particle.Particles.Gas.Smoke;
import Particle.Particles.Gas.Steam;
import Particle.Particles.Liquid.Acid;
import Particle.Particles.Liquid.Oil;
import Particle.Particles.Liquid.Water;
import Particle.Particles.Solid.ImmovableSolid.Glass;
import Particle.Particles.Solid.MovableSolid.Salt;
import Particle.Particles.Solid.MovableSolid.Sand;
import Particle.Particles.Solid.ImmovableSolid.Stone;
import Particle.Particles.Solid.ImmovableSolid.Wood;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Engine {
    //CONSTANTS
    public static int width = Noita.GAME_WIDTH;
    public static int height = Noita.HEIGHT;
    public static AbstractParticle[][] field = new AbstractParticle[width][height];

        //empty
    public static final Color emptyColor = Color.BLACK;
        //gases
    public static final Color smokeColor = Color.rgb(88,88,88);
    public static final Color steamColor = Color.rgb(198,215,215);
        //liquids
    public static final Color acidColor  = Color.LIMEGREEN;
    public static final Color oilColor   = Color.rgb(43,7,49);
    public static final Color waterColor = Color.BLUE;
        //immovable solids
    public static final Color glassColor = Color.rgb(207,209,209);
    public static final Color stoneColor = Color.rgb(91,85,77);
    public static final Color woodColor  = Color.rgb(115,67,16);
        //movable solids
    public static final Color saltColor  = Color.WHITESMOKE;
    public static final Color sandColor  = Color.YELLOW;
        //fire
    public static final Color fireColor1 = Color.ORANGERED;
    public static final Color fireColor2 = Color.ORANGE;

    //VARIABLES
    Integer[] rx = new Integer[width];
    Integer[] ry = new Integer[height];


    public Engine() {
        for(int x = 0; x <= width-1; x++) rx[x]=x;
        for(int y = 0; y <= height-1; y++) ry[y]=y;
    }

    //шаг физики
    public void step() {
        if (Noita.toClean) {
            clean();
        } else {
            List<Integer> yList = Arrays.asList(ry);
            Collections.shuffle(yList);
            yList.toArray(ry);
            for(int y = height-1; y >= 0; y--) {
                List<Integer> xList = Arrays.asList(rx);
                Collections.shuffle(xList);
                xList.toArray(rx);
                for(int x = 0; x <= width-1; x++)
                    if (field[rx[x]][ry[y]] != null)
                        if (Math.random() < 0.8) field[rx[x]][ry[y]].update();
            }
        }
    }

    //очищение
    public void clean() {
            for (int y = height - 1; y >= 0; y--) {
                for (int x = 0; x <= width - 1; x++) {
                    field[x][y] = null;
                }
            }
            Noita.toClean = false;
    }

    //создание частицы
    public void createParticle(String particleName, int x, int y) {
        switch (particleName) {
            case ("erase") -> Engine.field[x][y] = null;
                //Gases
            case ("smoke") -> Engine.field[x][y] = new Smoke(x,y);
            case ("steam") -> Engine.field[x][y] = new Steam(x,y);
                //Liquids
            case ("acid")  -> Engine.field[x][y] = new Acid( x,y);
            case ("oil")   -> Engine.field[x][y] = new Oil(  x,y);
            case ("water") -> Engine.field[x][y] = new Water(x,y);
                //Immovable solids
            case ("glass") -> Engine.field[x][y] = new Glass(x,y);
            case ("stone") -> Engine.field[x][y] = new Stone(x,y);
            case ("wood")  -> Engine.field[x][y] = new Wood( x,y);
                //Movable solids
            case ("salt") -> Engine.field[x][y] = new Salt(x,y);
            case ("sand") -> Engine.field[x][y] = new Sand(x,y);
                //Fire
            case ("fire") -> Engine.field[x][y] = new Fire(x,y);
        }
    }

    //прорисовка
    public void draw(GraphicsContext gc) {
        Platform.runLater(()->{
            gc.fillRect(0, 0, Noita.GAME_WIDTH, Noita.HEIGHT);
            for(int y = 0; y < Engine.height; y++) {
                for(int x = 0; x < Engine.width; x++) {
                        //Empty
                    if (Engine.field[x][y] == null) gc.setFill(emptyColor);
                        //Gases
                    else if (Engine.field[x][y] instanceof Smoke) gc.setFill(smokeColor);
                    else if (Engine.field[x][y] instanceof Steam) gc.setFill(steamColor);
                        //Liquids
                    else if (Engine.field[x][y] instanceof Acid)  gc.setFill(acidColor);
                    else if (Engine.field[x][y] instanceof Oil)   gc.setFill(oilColor);
                    else if (Engine.field[x][y] instanceof Water) gc.setFill(waterColor);
                        //Immovable solids
                    else if (Engine.field[x][y] instanceof Glass) gc.setFill(glassColor);
                    else if (Engine.field[x][y] instanceof Stone) gc.setFill(stoneColor);
                    else if (Engine.field[x][y] instanceof Wood)  gc.setFill(woodColor);
                        //Movable solids
                    else if (Engine.field[x][y] instanceof Salt)  gc.setFill(saltColor);
                    else if (Engine.field[x][y] instanceof Sand)  gc.setFill(sandColor);
                        //Fire
                    else if (Engine.field[x][y] instanceof Fire) { if (Math.random() < 0.5) gc.setFill(fireColor1);
                                                                   else                     gc.setFill(fireColor2); }

                    gc.fillRect(x,y,1,1);
                }
            }
        });
    }
}

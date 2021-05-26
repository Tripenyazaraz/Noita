package Main;
import Particle.*;

public class Engine {
    public static int width = Noita.GAME_WIDTH;
    public static int height = Noita.HEIGHT;
    public static BaseParticle[][] field = new BaseParticle[width][height];

    //шаг физики
    public void step() {
        for(int y = height-1; y >= 0; y--) {
            for(int x = 0; x < width; x++) {
                if (field[x][y] != null) {
                    field[x][y].update();
                }
            }
        }
    }

    //очищение
    public void clean() {
        for(int y = height-1; y >= 0; y--) {
            for(int x = 0; x < width; x++) {
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
            case ("fire")  -> Engine.field[x][y] = new Fire( x,y);
        }
    }
}

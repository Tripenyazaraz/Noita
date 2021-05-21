package Main;
import Particle.*;

public class Engine {
    public static int height = 7;
    public static int width = 7;
    public static ParticleInterface[][] field = new ParticleInterface[width][height];

    //шаг физики
    public void step() {
        for(int y = height-1; y >= 0; y--) {
            for(int x = 0; x < width; x++) {
                if (field[x][y] != null) {
                    field[x][y].update(x,y);
                }
            }
        }
    }

    //прорисовка
    public void draw() {
        for(int y = 0; y < height; y++) {
            System.out.println();
            for(int x = 0; x < width; x++) {
                if (field[x][y] == null) {
                    System.out.print("0 ");
                } else {
                    System.out.print("K ");
                }
            }
        }
        //отступы
        System.out.println();
        System.out.println();
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
            case ("sand")  -> Engine.field[x][y] = new Sand( x, y);
            case ("water") -> Engine.field[x][y] = new Water(x, y);
            case ("steam") -> Engine.field[x][y] = new Steam(x, y);
            case ("stone") -> Engine.field[x][y] = new Stone(x, y);
            /*
            case ("acid")  -> Engine.field[x][y] = new Acid( x, y);
            case ("oil")   -> Engine.field[x][y] = new Oil(  x, y);
            case ("wood")  -> Engine.field[x][y] = new Wood( x, y);
            case ("fire")  -> Engine.field[x][y] = new Fire( x, y);
            */
        }
    }
}

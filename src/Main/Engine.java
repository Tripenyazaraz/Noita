package Main;
import Particle.*;

public class Engine {
    public static int width = Noita_UI.GAME_PANEL_WIDTH;
    public static int height = Noita_UI.HEIGHT;
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

    //прорисовка (ТОЛЬКО ДЛЯ КОНСОЛЬНОГО ИНТЕРФЕЙСА)
    public void draw() {
        for(int y = 0; y < height; y++) {
            System.out.println();
            for (int x = 0; x < width; x++) {
                if (field[x][y] == null) { System.out.print("0 "); }
                else if (field[x][y] instanceof Sand)  { System.out.print("S "); }
                else if (field[x][y] instanceof Water) { System.out.print("W "); }
                else if (field[x][y] instanceof Steam) { System.out.print("G "); }
                else if (field[x][y] instanceof Stone) { System.out.print("R "); }
                /*
                else if (field[x][y] instanceof Acid) { System.out.print("A "); }
                else if (field[x][y] instanceof Oil)  { System.out.print("O "); }
                else if (field[x][y] instanceof Wood) { System.out.print("D "); }
                else if (field[x][y] instanceof Fire) { System.out.print("F "); }
                */
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

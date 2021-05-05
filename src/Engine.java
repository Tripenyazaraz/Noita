public class Engine {
    public static int height = 3;
    public static int width = 3;
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
            System.out.println("");
            for(int x = 0; x < width; x++) {
                if (field[x][y] == null) {
                    System.out.print("0 ");
                } else {
                    System.out.print("K ");
                }
            }
        }
    }
}

public class Sand extends BaseParticle implements ParticleInterface {
    //конструктор
    public Sand(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public void update(int x, int y) {
        if (Engine.field[x][y+1] == null) {
            this.setY(this.getY()+1);
            Engine.field[x][y+1] = Engine.field[x][y];
            Engine.field[x][y] = null;
        }
        else if (Engine.field[x-1][y+1] == null) {
            this.setX(this.getX()-1);
            this.setY(this.getY()-1);
            Engine.field[x-1][y+1] = Engine.field[x][y];
            Engine.field[x][y] = null;
        }
        else if (Engine.field[x+1][y+1] == null) {
            this.setX(this.getX() + 1);
            this.setY(this.getY() - 1);
            Engine.field[x+1][y+1] = Engine.field[x][y];
            Engine.field[x][y] = null;
        }
    }
}
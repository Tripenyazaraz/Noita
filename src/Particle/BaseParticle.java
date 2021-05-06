package Particle;

import Main.*;

public class BaseParticle {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void moveTo(int x, int y) {
        Engine.field[x][y] = Engine.field[this.getX()][this.getY()];
        Engine.field[this.getX()][this.getY()] = null;
        this.setX(x);
        this.setY(y);
    }

    public Boolean isEmpty(int x, int y) {
        if ((x <= Engine.width-1) & (y <= Engine.height-1) & (x >= 0) & (y >= 0)) {
            return (Engine.field[x][y] == null);
        } else return false;
    }
}

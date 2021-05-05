package Particle;

import Main.Engine;

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
}

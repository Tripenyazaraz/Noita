package Particle;

import Main.*;

import java.util.Random;

public class BaseParticle {
    public int x;
    public int y;

    public void update() {}

    public void moveTo(int x, int y) {
        Engine.field[x][y] = Engine.field[this.x][this.y];
        Engine.field[this.x][this.y] = null;
        this.x = x;
        this.y = y;
    }

    public void swapWith(int x, int y) {
        int a = 0;
        int b = 0;
        Engine.field[x][y].moveTo(a,b);
        int oldX = this.x;
        int oldY = this.y;
        Engine.field[this.x][this.y].moveTo(x,y);
        Engine.field[a][b].moveTo(oldX,oldY);
    }

    public Boolean is(String name, int x, int y) {
        if ((x <= Engine.width-1) & (y <= Engine.height-1) & (x >= 0) & (y >= 0)) {
                 if (name.equalsIgnoreCase("empty")) return Engine.field[x][y] == null;
            else if (name.equalsIgnoreCase("sand"))  return Engine.field[x][y] instanceof Sand;
            else if (name.equalsIgnoreCase("water")) return Engine.field[x][y] instanceof Water;
            else if (name.equalsIgnoreCase("steam")) return Engine.field[x][y] instanceof Steam;
            else if (name.equalsIgnoreCase("stone")) return Engine.field[x][y] instanceof Stone;
//            else if (name.equalsIgnoreCase("acid")) return Engine.field[x][y] instanceof Acid;
//            else if (name.equalsIgnoreCase("oil"))  return Engine.field[x][y] instanceof Oil;
//            else if (name.equalsIgnoreCase("wood")) return Engine.field[x][y] instanceof Wood;
//            else if (name.equalsIgnoreCase("fire")) return Engine.field[x][y] instanceof Fire;
            else return false;
        } else return false;
    }
}

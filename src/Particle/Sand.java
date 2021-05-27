package Particle;

import Main.*;

public class Sand extends BaseParticle {
    //конструктор
    public Sand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        Boolean down      = is("empty",x,  y+1);
        Boolean downLeft  = is("empty",x-1,y+1);
        Boolean downRight = is("empty",x+1,y+1);

        int k = 1;
        if (Math.random() < 0.5) k = -1;

             if (down)                  Engine.field[x][y].moveTo(x,  y+1);
        else if (downLeft & downRight)  Engine.field[x][y].moveTo(x+k,y+1);
        else if (downLeft)              Engine.field[x][y].moveTo(x-1,y+1);
        else if (downRight)             Engine.field[x][y].moveTo(x+1,y+1);
    }
}
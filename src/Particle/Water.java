package Particle;

import Main.*;

public class Water extends BaseParticle implements ParticleInterface {
    //конструктор
    public Water(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(int x, int y) {
        Boolean down      = isEmpty(   x,   y+1);
        Boolean left      = isEmpty(x-1,    y  );
        Boolean right     = isEmpty(x+1,    y  );
        Boolean downLeft  = isEmpty(x-1, y+1);
        Boolean downRight = isEmpty(x+1, y+1);

             if (down)      Engine.field[x][y].moveTo(   x,   y+1);
        else if (downLeft)  Engine.field[x][y].moveTo(x-1, y+1);
        else if (downRight) Engine.field[x][y].moveTo(x+1, y+1);
        else if (left)      Engine.field[x][y].moveTo(x-1,    y  );
        else if (right)     Engine.field[x][y].moveTo(x+1,    y  );
    }
}

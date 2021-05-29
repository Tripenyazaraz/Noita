package Particle.Particles.Gas;

import Main.Engine;
import Particle.Particles.AbstractGas;

public class Steam extends AbstractGas {
    public int velocity = 3;

    public Steam(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        Boolean up      = is("empty",x,  y-1);
        Boolean left    = is("empty",x-1,y);
        Boolean right   = is("empty",x+1,y);
        Boolean upLeft  = is("empty",x-1,y-1);
        Boolean upRight = is("empty",x+1,y-1);

        int k = 1;
        if (Math.random() < 0.5) k = -1;

             if (up)               Engine.field[x][y].moveTo(x,y-1);
        else if (upLeft & upRight) Engine.field[x][y].moveTo(x+k,y-1);
        else if (upLeft)           Engine.field[x][y].moveTo(x-1,y-1);
        else if (upRight)          Engine.field[x][y].moveTo(x+1,y-1);
        else if (left & right)     Engine.field[x][y].moveTo(x+k,y);
        else if (left)             Engine.field[x][y].moveTo(x-1,y);
        else if (right)            Engine.field[x][y].moveTo(x+1,y);
    }
}

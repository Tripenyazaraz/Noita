package Particle.Particles.Solid.MovableSolid;

import Main.*;
import Particle.Particles.Solid.AbstractMovableSolid;

public class Sand extends AbstractMovableSolid {
    public static int velocity = 3;

    public Sand(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        Boolean downEmpty      = is("empty",x,  y+1);
        Boolean downLeftEmpty  = is("empty",x-1,y+1);
        Boolean downRightEmpty = is("empty",x+1,y+1);

        Boolean downPassable      = is("liquid",x,  y+1) | is("gas",x,  y+1);
        Boolean downLeftPassable  = is("liquid",x-1,y+1) | is("gas",x-1,y+1);
        Boolean downRightPassable = is("liquid",x+1,y+1) | is("gas",x+1,y+1);

        int k = 1;
        if (Math.random() < 0.5) k = -1;

             if (downEmpty)    Engine.field[x][y].moveTo(  x,y+1);
        else if (downPassable) Engine.field[x][y].swapWith(x,y+1);

        else if (downLeftEmpty & downRightEmpty)       Engine.field[x][y].moveTo(  x+k,y+1);
        else if (downLeftPassable & downRightPassable) Engine.field[x][y].swapWith(x+k,y+1);

        else if (downLeftEmpty)    Engine.field[x][y].moveTo(  x-1,y+1);
        else if (downLeftPassable) Engine.field[x][y].swapWith(x-1,y+1);

        else if (downRightEmpty)    Engine.field[x][y].moveTo(  x+1,y+1);
        else if (downRightPassable) Engine.field[x][y].swapWith(x+1,y+1);
    }
}
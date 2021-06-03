package Particle.Particles.Solid;

import Main.Engine;
import Particle.Particles.AbstractSolid;

public abstract class AbstractMovableSolid extends AbstractSolid {
    public double swapChance = 0.4;

    public AbstractMovableSolid(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        boolean downEmpty      = is("empty",x,  y+1);
        boolean downLeftEmpty  = is("empty",x-1,y+1);
        boolean downRightEmpty = is("empty",x+1,y+1);

        boolean downPassable      = is("liquid",x,  y+1) | is("gas",x,  y+1);
        boolean downLeftPassable  = is("liquid",x-1,y+1) | is("gas",x-1,y+1);
        boolean downRightPassable = is("liquid",x+1,y+1) | is("gas",x+1,y+1);

        int k = (Math.random() < 0.5) ? 1 : -1;

        if (downEmpty) Engine.field[x][y].moveTo(x,y+1);
        else if (downPassable &
                (Math.random() < swapChance)) Engine.field[x][y].swapWith(x,y+1);

        else if (downLeftEmpty &
                downRightEmpty) Engine.field[x][y].moveTo(x+k,y+1);
        else if (downLeftPassable &
                downRightPassable &
                (Math.random() < swapChance)) Engine.field[x][y].swapWith(x+k,y+1);

        else if (downLeftEmpty) Engine.field[x][y].moveTo(x-1,y+1);
        else if (downLeftPassable &
                (Math.random() < swapChance)) Engine.field[x][y].swapWith(x-1,y+1);

        else if (downRightEmpty) Engine.field[x][y].moveTo(x+1,y+1);
        else if (downRightPassable &
                (Math.random() < swapChance)) Engine.field[x][y].swapWith(x+1,y+1);
    }
}

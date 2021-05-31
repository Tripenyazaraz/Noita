package Particle.Particles.Liquid;

import Main.*;
import Particle.Particles.AbstractLiquid;

public class Water extends AbstractLiquid {
    public int velocity = 5;
    public int density = 5;

    public Water(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        Boolean downEmpty      = is("empty",x  ,y+1);
        Boolean leftEmpty      = is("empty",x-1,y);
        Boolean rightEmpty     = is("empty",x+1,y);
        Boolean downLeftEmpty  = is("empty",x-1,y+1);
        Boolean downRightEmpty = is("empty",x+1,y+1);

        Boolean downLiquid      = is("liquid",x  ,y+1);
        Boolean leftLiquid      = is("liquid",x-1,y);
        Boolean rightLiquid     = is("liquid",x+1,y);
        Boolean downLeftLiquid  = is("liquid",x-1,y+1);
        Boolean downRightLiquid = is("liquid",x+1,y+1);

        int k = 1;
        if (Math.random() < 0.5) k = -1;

        if (downEmpty) Engine.field[x][y].moveTo(x,y+1);
        else if (downLeftEmpty & downRightEmpty) Engine.field[x][y].moveTo(x+k,y+1);
        else if (downLeftEmpty)          Engine.field[x][y].moveTo(x-1,y+1);
        else if (downRightEmpty)         Engine.field[x][y].moveTo(x+1,y+1);
        else if (leftEmpty & rightEmpty) Engine.field[x][y].moveTo(x+k,y);
        else if (leftEmpty)              Engine.field[x][y].moveTo(x-1,y);
        else if (rightEmpty)             Engine.field[x][y].moveTo(x+1,y);
    }
}

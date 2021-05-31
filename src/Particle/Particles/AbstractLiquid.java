package Particle.Particles;

import Main.Engine;
import Particle.AbstractParticle;

public class AbstractLiquid extends AbstractParticle {
    public AbstractLiquid(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        Boolean downEmpty      = is("empty",x  ,y+1);
        Boolean downLeftEmpty  = is("empty",x-1,y+1);
        Boolean downRightEmpty = is("empty",x+1,y+1);
        Boolean leftVelocityEmpty  = is("empty",x-this.getVelocity(),y);
        Boolean rightVelocityEmpty = is("empty",x+this.getVelocity(),y);
        Boolean leftEmpty      = is("empty",x-1,y);
        Boolean rightEmpty     = is("empty",x+1,y);

        Boolean downLiquid      = is("liquid",x  ,y+1);
        Boolean downLeftLiquid  = is("liquid",x-1,y+1);
        Boolean downRightLiquid = is("liquid",x+1,y+1);
        Boolean leftLiquid      = is("liquid",x-1,y);
        Boolean rightLiquid     = is("liquid",x+1,y);

        int k = 1;
        if (Math.random() < 0.5) k = -1;
        int velMove = this.getVelocity();
        if (Math.random() < 0.5) velMove = -this.getVelocity();

        if (downEmpty) Engine.field[x][y].moveTo(x,y+1);

        else if (downLeftEmpty &
                downRightEmpty) Engine.field[x][y].moveTo(x+k,y+1);
        else if (downLeftEmpty)  Engine.field[x][y].moveTo(x-1,y+1);
        else if (downRightEmpty) Engine.field[x][y].moveTo(x+1,y+1);

        else if (leftVelocityEmpty &
                rightVelocityEmpty) Engine.field[x][y].moveTo(x+velMove,y);
        else if (leftVelocityEmpty)  Engine.field[x][y].moveTo(x-this.getVelocity(),y);
        else if (rightVelocityEmpty) Engine.field[x][y].moveTo(x+this.getVelocity(),y);

        else if (leftEmpty &
                rightEmpty) Engine.field[x][y].moveTo(x+k,y);
        else if (leftEmpty)  Engine.field[x][y].moveTo(x-1,y);
        else if (rightEmpty) Engine.field[x][y].moveTo(x+1,y);
    }
}

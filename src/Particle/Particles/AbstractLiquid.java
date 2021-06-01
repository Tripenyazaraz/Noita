package Particle.Particles;

import Main.Engine;
import Particle.AbstractParticle;

public class AbstractLiquid extends AbstractParticle {
    public double swapChance = 0.4;

    public AbstractLiquid(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        boolean downEmpty      = is("empty",x  ,y+1) ;
        boolean downLeftEmpty  = is("empty",x-1,y+1);
        boolean downRightEmpty = is("empty",x+1,y+1);
        boolean leftEmpty      = is("empty",x-1,y);
        boolean rightEmpty     = is("empty",x+1,y);
        boolean leftVelocityEmpty  = is("empty",x-this.getVelocity(),y);
        boolean rightVelocityEmpty = is("empty",x+this.getVelocity(),y);

        boolean downLiquid      = is("liquid",x  ,y+1);
        boolean downLeftLiquid  = is("liquid",x-1,y+1);
        boolean downRightLiquid = is("liquid",x+1,y+1);
        boolean leftLiquid      = is("liquid",x-1,y);
        boolean rightLiquid     = is("liquid",x+1,y);
        boolean leftVelocityLiquid  = is("empty",x-this.getVelocity(),y);
        boolean rightVelocityLiquid = is("empty",x+this.getVelocity(),y);

        int k = (Math.random() < 0.5) ? 1 : -1;
        int velocityMove = (Math.random() < 0.5) ? this.getVelocity() : -this.getVelocity();

        if (downEmpty) Engine.field[x][y].moveTo(x,y+1);

        else if (downLeftEmpty &
                downRightEmpty) Engine.field[x][y].moveTo(x+k,y+1);
        else if (downLeftEmpty)  Engine.field[x][y].moveTo(x-1,y+1);
        else if (downRightEmpty) Engine.field[x][y].moveTo(x+1,y+1);

        else if (leftVelocityEmpty &
                rightVelocityEmpty) Engine.field[x][y].moveTo(x+velocityMove,y);
        else if (leftVelocityEmpty)  Engine.field[x][y].moveTo(x-this.getVelocity(),y);
        else if (rightVelocityEmpty) Engine.field[x][y].moveTo(x+this.getVelocity(),y);

        else if (leftEmpty &
                rightEmpty) Engine.field[x][y].moveTo(x+k,y);
        else if (leftEmpty)  Engine.field[x][y].moveTo(x-1,y);
        else if (rightEmpty) Engine.field[x][y].moveTo(x+1,y);
    }
}

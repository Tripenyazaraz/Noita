package Particle.Particles;

import Main.Engine;
import Particle.AbstractParticle;

public class AbstractGas extends AbstractParticle {
    public AbstractGas(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        boolean upEmpty      = is("empty",x,  y-1);
        boolean upLeftEmpty  = is("empty",x-1,y-1);
        boolean upRightEmpty = is("empty",x+1,y-1);
        boolean leftEmpty    = is("empty",x-1,y);
        boolean rightEmpty   = is("empty",x+1,y);
        boolean leftVelocityEmpty  = is("empty",x-this.getVelocity(),y);
        boolean rightVelocityEmpty = is("empty",x+this.getVelocity(),y);

        int k = (Math.random() < 0.5) ? 1 : -1;
        int velocityMove = (Math.random() < 0.5) ? this.getVelocity() : -this.getVelocity();

        if (upEmpty) Engine.field[x][y].moveTo(x,y-1);

        else if (upLeftEmpty &
                upRightEmpty)  Engine.field[x][y].moveTo(x+k,y-1);
        else if (upLeftEmpty)  Engine.field[x][y].moveTo(x-1,y-1);
        else if (upRightEmpty) Engine.field[x][y].moveTo(x+1,y-1);

        else if (leftVelocityEmpty &
                rightVelocityEmpty)  Engine.field[x][y].moveTo(x+velocityMove,y);
        else if (leftVelocityEmpty)  Engine.field[x][y].moveTo(x-this.getVelocity(),y);
        else if (rightVelocityEmpty) Engine.field[x][y].moveTo(x+this.getVelocity(),y);

        else if (leftEmpty &
                rightEmpty)  Engine.field[x][y].moveTo(x+k,y);
        else if (leftEmpty)  Engine.field[x][y].moveTo(x-1,y);
        else if (rightEmpty) Engine.field[x][y].moveTo(x+1,y);
    }
}
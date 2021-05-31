package Particle.Particles;

import Main.Engine;
import Particle.AbstractParticle;

public class AbstractGas extends AbstractParticle {
    public AbstractGas(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        Boolean upEmpty      = is("empty",x,  y-1);
        Boolean upLeftEmpty  = is("empty",x-1,y-1);
        Boolean upRightEmpty = is("empty",x+1,y-1);
        Boolean leftEmpty    = is("empty",x-1,y);
        Boolean rightEmpty   = is("empty",x+1,y);
        Boolean leftVelocityEmpty  = is("empty",x-this.getVelocity(),y);
        Boolean rightVelocityEmpty = is("empty",x+this.getVelocity(),y);

        int k = 1;
        if (Math.random() < 0.5) k = -1;
        int velMove = this.getVelocity();
        if (Math.random() < 0.5) velMove = -this.getVelocity();

        if (upEmpty)      Engine.field[x][y].moveTo(x,y-1);

        else if (upLeftEmpty &
                upRightEmpty) Engine.field[x][y].moveTo(x+k,y-1);
        else if (upLeftEmpty)  Engine.field[x][y].moveTo(x-1,y-1);
        else if (upRightEmpty) Engine.field[x][y].moveTo(x+1,y-1);

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

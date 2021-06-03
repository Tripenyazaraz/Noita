package Particle.Particles;

import Main.Engine;
import Particle.AbstractParticle;

public abstract class AbstractGas extends AbstractParticle {
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

        boolean upPassable      = checkDensity(x  ,y-1);
        boolean upLeftPassable  = checkDensity(x-1,y-1);
        boolean upRightPassable = checkDensity(x+1,y-1);
        boolean leftPassable      = checkDensity(x-1,y);
        boolean rightPassable     = checkDensity(x+1,y);
        boolean leftVelocityPassable  = checkDensity(x-this.getVelocity(),y);
        boolean rightVelocityPassable = checkDensity(x+this.getVelocity(),y);

        int k = (Math.random() < 0.5) ? 1 : -1;
        int velocityMove = (Math.random() < 0.5) ? this.getVelocity() : -this.getVelocity();

            //UP
        if (upEmpty | upPassable) Engine.field[x][y].swapWith(x,y-1);
            //UP BOTH
        else if ((upLeftEmpty & upRightEmpty) |
                (upLeftPassable & upRightPassable)) Engine.field[x][y].swapWith(x+k,y-1);
            //UP LEFT & RIGHT
        else if (upLeftEmpty | upLeftPassable)   Engine.field[x][y].swapWith(x-1,y-1);
        else if (upRightEmpty | upRightPassable) Engine.field[x][y].swapWith(x+1,y-1);
            //LEFT VELOCITY BOTH
        else if ((leftVelocityEmpty & rightVelocityEmpty) |
                (leftVelocityPassable & rightVelocityPassable)) Engine.field[x][y].swapWith(x+velocityMove,y);
            //LEFT & RIGHT VELOCITY
        else if (leftVelocityEmpty | leftVelocityPassable)   Engine.field[x][y].swapWith(x-this.getVelocity(),y);
        else if (rightVelocityEmpty | rightVelocityPassable) Engine.field[x][y].swapWith(x+this.getVelocity(),y);
            //BOTH
        else if ((leftEmpty & rightEmpty) |
                (leftPassable & rightPassable)) Engine.field[x][y].swapWith(x+k,y);
            //LEFT & RIGHT
        else if (leftEmpty | leftPassable)   Engine.field[x][y].swapWith(x-1,y);
        else if (rightEmpty | rightPassable) Engine.field[x][y].swapWith(x+1,y);
    }

    public Boolean checkDensity(int x, int y) {
        if (is("liquid",x,y) | is("gas",x,y)) {
            if (Engine.field[x][y] == null) return false;
            if (Engine.field[this.x][this.y] == null) return false;
            return Engine.field[x][y].getDensity() < Engine.field[this.x][this.y].getDensity();
        } else return false;
    }
}

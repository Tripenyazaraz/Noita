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

        boolean downPassable      = checkDensity(x  ,y+1);
        boolean downLeftPassable  = checkDensity(x-1,y+1);
        boolean downRightPassable = checkDensity(x+1,y+1);
        boolean leftPassable      = checkDensity(x-1,y);
        boolean rightPassable     = checkDensity(x+1,y);
        boolean leftVelocityPassable  = checkDensity(x-this.getVelocity(),y);
        boolean rightVelocityPassable = checkDensity(x+this.getVelocity(),y);

        int k = (Math.random() < 0.5) ? 1 : -1;
        int velocityMove = (Math.random() < 0.5) ? this.getVelocity() : -this.getVelocity();

            //DOWN
        if (downEmpty | downPassable) Engine.field[x][y].swapWith(x,y+1);
            //DOWN BOTH
        else if ((downLeftEmpty & downRightEmpty) |
                (downLeftPassable & downRightPassable)) Engine.field[x][y].swapWith(x+k,y+1);
            //DOWN LEFT & RIGHT
        else if (downLeftEmpty | downLeftPassable)   Engine.field[x][y].swapWith(x-1,y+1);
        else if (downRightEmpty | downRightPassable) Engine.field[x][y].swapWith(x+1,y+1);
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
            return Engine.field[x][y].getDensity() < Engine.field[this.x][this.y].getDensity();
        } else return false;
    }
}

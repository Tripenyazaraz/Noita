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

//        if (upEmpty) Engine.field[x][y].moveTo(x,y-1);
//
//        else if (upLeftEmpty &
//                upRightEmpty)  Engine.field[x][y].moveTo(x+k,y-1);
//        else if (upLeftEmpty)  Engine.field[x][y].moveTo(x-1,y-1);
//        else if (upRightEmpty) Engine.field[x][y].moveTo(x+1,y-1);
//
//        else if (leftVelocityEmpty &
//                rightVelocityEmpty)  Engine.field[x][y].moveTo(x+velocityMove,y);
//        else if (leftVelocityEmpty)  Engine.field[x][y].moveTo(x-this.getVelocity(),y);
//        else if (rightVelocityEmpty) Engine.field[x][y].moveTo(x+this.getVelocity(),y);
//
//        else if (leftEmpty &
//                rightEmpty)  Engine.field[x][y].moveTo(x+k,y);
//        else if (leftEmpty)  Engine.field[x][y].moveTo(x-1,y);
//        else if (rightEmpty) Engine.field[x][y].moveTo(x+1,y);
    }

    public Boolean checkDensity(int x, int y) {
        if (is("liquid",x,y) | is("gas",x,y)) {
            return Engine.field[x][y].getDensity() < Engine.field[this.x][this.y].getDensity();
        } else return false;
    }
}

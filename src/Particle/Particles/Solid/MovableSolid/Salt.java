package Particle.Particles.Solid.MovableSolid;

import Main.Engine;
import Main.Noita;
import Particle.Particles.Solid.AbstractMovableSolid;

public class Salt extends AbstractMovableSolid {
    public int velocity = 3;
    public static double dissolveChance = 0.04;
    public static double incWaterAmountChance = 0.25;

    public Salt(int x, int y) {
        super(x, y);
    }

    public int getVelocity() {
        return this.velocity;
    }

    @Override
    public void update() {
        super.update();
        event();
    }

    public void event() {
        if (Math.random() < dissolveChance)
            if (is("water",x-1,y-1) | is("water",x  ,y-1) | is("water",x+1,y-1) | is("water",x-1,y  ) |
                    is("water",x+1,y  ) | is("water",x-1,y+1) | is("water",x  ,y+1) | is("water",x+1,y+1))
                if (Math.random() < incWaterAmountChance)
                    Noita.engine.createParticle("water",x,y);
                else Engine.field[x][y] = null;
    }
}

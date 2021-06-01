package Particle.Particles.Liquid;

import Main.Engine;
import Particle.Fire;
import Particle.Particles.AbstractLiquid;

public class Water extends AbstractLiquid {
    public int velocity = 5;
    public int density = 5;

    public Water(int x, int y) {
        super(x, y);
    }

    @Override
    public int getVelocity() {
        return this.velocity;
    }
    @Override
    public int getDensity() {
        return this.density;
    }

    @Override
    public void update() {
        super.update();
        event();
    }

    public void event() {

    }
}

package Particle.Particles.Liquid;

import Main.Engine;
import Particle.Particles.AbstractLiquid;

public class Oil extends AbstractLiquid {
    public int velocity = 2;
    public double flammability = 0.03;
    public int density = 1;

    public Oil(int x, int y) {
        super(x, y);
    }

    public int getDensity() {
        return this.density;
    }

    public int getVelocity() {
        return this.velocity;
    }

    public double getFlammability() {
        return this.flammability;
    }

    @Override
    public void update() {
        super.update();
        event();
    }

    public void event() {

    }
}
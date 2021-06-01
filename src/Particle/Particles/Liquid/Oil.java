package Particle.Particles.Liquid;

import Particle.Particles.AbstractLiquid;

public class Oil extends AbstractLiquid {
    public double flammability = 0.01;
    public int velocity = 2;
    public int density = 1;

    public Oil(int x, int y) {
        super(x, y);
    }

    @Override
    public double getFlammability() {
        return this.flammability;
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
package Particle.Particles.Gas;

import Main.Engine;
import Particle.Particles.AbstractGas;

public class Smoke extends AbstractGas {
    public int velocity = 3;
    public int density = 3;

    public Smoke(int x, int y) {
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

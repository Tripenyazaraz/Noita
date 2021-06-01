package Particle.Particles.Gas;

import Particle.Particles.AbstractGas;

public class Steam extends AbstractGas {
    public int velocity = 3;
    public int density = -1;

    public Steam(int x, int y) {
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

package Particle.Particles.Solid.ImmovableSolid;

import Particle.Particles.Solid.AbstractImmovableSolid;

public class Wood extends AbstractImmovableSolid {
    public double flammability = 0.02;

    public Wood(int x, int y) {
        super(x, y);
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
package Particle.Particles.Solid.ImmovableSolid;

import Particle.Particles.Solid.AbstractImmovableSolid;

public class Wood extends AbstractImmovableSolid {
    public double flammability = 0.004;
    public double acidability = 0.005;

    public Wood(int x, int y) {
        super(x, y);
    }

    @Override
    public double getFlammability() {
        return this.flammability;
    }
    @Override
    public double getAcidability() {
        return this.acidability;
    }

    @Override
    public void update() {
        super.update();
        event();
    }

    public void event() {

    }
}
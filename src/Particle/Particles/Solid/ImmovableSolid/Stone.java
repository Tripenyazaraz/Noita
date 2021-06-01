package Particle.Particles.Solid.ImmovableSolid;

import Particle.Particles.Solid.AbstractImmovableSolid;

public class Stone extends AbstractImmovableSolid {
    public double acidability = 0.002;

    public Stone(int x, int y) {
        super(x, y);
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
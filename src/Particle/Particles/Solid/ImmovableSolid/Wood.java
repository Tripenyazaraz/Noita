package Particle.Particles.Solid.ImmovableSolid;

import Particle.Particles.Solid.AbstractImmovableSolid;

public class Wood extends AbstractImmovableSolid {
    public int flammability = 3;

    public Wood(int x, int y) {
        super(x, y);
    }

    public int getFlammability() {
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
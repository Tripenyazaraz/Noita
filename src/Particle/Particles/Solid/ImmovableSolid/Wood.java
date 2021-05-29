package Particle.Particles.Solid.ImmovableSolid;

import Particle.Particles.Solid.AbstractImmovableSolid;

public class Wood extends AbstractImmovableSolid {
    public static int flammability = 3;

    public Wood(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        //i am stay still
    }
}
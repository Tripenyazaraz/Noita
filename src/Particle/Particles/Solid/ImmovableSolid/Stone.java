package Particle.Particles.Solid.ImmovableSolid;

import Particle.Particles.Solid.AbstractImmovableSolid;

public class Stone extends AbstractImmovableSolid {
    public Stone(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        //i am stay still
    }
}
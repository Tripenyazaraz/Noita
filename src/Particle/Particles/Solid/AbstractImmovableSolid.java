package Particle.Particles.Solid;

import Particle.Particles.AbstractSolid;

public class AbstractImmovableSolid extends AbstractSolid {
    public AbstractImmovableSolid(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        //i am stay still
    }
}
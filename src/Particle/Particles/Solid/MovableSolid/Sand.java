package Particle.Particles.Solid.MovableSolid;

import Main.*;
import Particle.Particles.Solid.AbstractMovableSolid;

public class Sand extends AbstractMovableSolid {
    public int velocity = 3;

    public Sand(int x, int y) {
        super(x, y);
    }

    public int getVelocity() {
        return this.velocity;
    }

    @Override
    public void update() {
        super.update();
        event();
    }

    public void event() {

    }
}
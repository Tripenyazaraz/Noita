package Particle.Particles.Solid.MovableSolid;

import Main.*;
import Particle.Particles.Solid.AbstractMovableSolid;

public class Sand extends AbstractMovableSolid {
    public double acidability = 0.007;
    public int velocity = 3;

    public Sand(int x, int y) {
        super(x, y);
    }


    @Override
    public double getAcidability() {
        return this.acidability;
    }
    @Override
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
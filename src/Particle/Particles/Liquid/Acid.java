package Particle.Particles.Liquid;

import Main.Engine;
import Particle.Particles.AbstractLiquid;

public class Acid extends AbstractLiquid {
    public int velocity = 5;
    public int density = 10;

    public Acid(int x, int y) {
        super(x, y);
    }

    public int getDensity() {
        return this.density;
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
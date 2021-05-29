package Particle;

import Main.Engine;

public class Fire extends AbstractParticle {
    public static int velocity = 1;

    public Fire(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        if (Math.random() < 0.05) {
            Engine.field[x][y] = null;
        }
    }
}
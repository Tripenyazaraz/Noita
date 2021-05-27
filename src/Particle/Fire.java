package Particle;

import Main.Engine;

public class Fire extends BaseParticle {
    //конструктор
    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        if (Math.random() < 0.05) {
            Engine.field[x][y] = null;
        }
    }
}
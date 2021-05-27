package Particle;

public class Wood extends BaseParticle {
    //конструктор
    public Wood(int x, int y) {
        this.x = x;
        this.y = y;
        this.fuel = true;
    }

    @Override
    public void update() {
        //i am stay still
    }
}
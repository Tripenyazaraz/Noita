package Particle;

public class Oil extends BaseParticle {
    //конструктор
    public Oil(int x, int y) {
        this.x = x;
        this.y = y;
        this.fuel = true;
    }

    @Override
    public void update() {
        //i am stay still
    }
}
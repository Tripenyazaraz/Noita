package Particle;

public class Stone extends BaseParticle {
    //конструктор
    public Stone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        //i am stay still
    }
}
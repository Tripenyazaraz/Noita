package Particle;

public class Stone extends BaseParticle implements ParticleInterface {
    //конструктор
    public Stone(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(int x, int y) {
        //i am stay still
    }
}
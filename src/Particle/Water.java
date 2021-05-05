package Particle;

public class Water extends BaseParticle implements ParticleInterface {
    //конструктор
    public Water(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(int x, int y) {
        System.out.println("water");
    }
}

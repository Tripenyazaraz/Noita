public class Steam extends BaseParticle implements ParticleInterface {
    //конструктор
    public Steam(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(int x, int y) {
        System.out.println("steam");
    }
}

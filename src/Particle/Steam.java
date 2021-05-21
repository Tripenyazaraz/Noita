package Particle;

public class Steam extends BaseParticle implements ParticleInterface {
    //конструктор
    public Steam(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(int x, int y) {
        //есть большая проблема с поведением газов потому что проверка идёт снизу вверх и это ебёт их в жопу,
        //а если проверять сверху вниз то ебать в жопу будет всё кроме газов
        //в каком-то из видосов было решение этой проблемы, но оно сложное
        System.out.println("steam");
    }
}

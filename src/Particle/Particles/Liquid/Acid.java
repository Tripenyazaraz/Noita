package Particle.Particles.Liquid;

import Main.Engine;
import Main.Noita;
import Particle.Particles.AbstractLiquid;

public class Acid extends AbstractLiquid {
    public int velocity = 5;
    public int density = 10;

    public Acid(int x, int y) {
        super(x, y);
    }

    @Override
    public int getVelocity() {
        return this.velocity;
    }
    @Override
    public int getDensity() {
        return this.density;
    }

    @Override
    public void update() {
        super.update();
        event();
    }

    public void event() {
        check(x-1,y-1);
        check(x  ,y-1);
        check(x+1,y-1);

        check(x-1,y  );
        check(x+1,y  );

        check(x-1,y+1);
        check(x  ,y+1);
        check(x+1,y+1);
    }

    public void check(int x, int y) {
        if (is("solid",x,y))
            if (Engine.field[x][y].getAcidability() > 0)
                if (Math.random() < Engine.field[x][y].getAcidability())
                    Engine.field[x][y] = null;
    }
}
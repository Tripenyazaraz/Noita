package Particle;

import Main.Engine;
import Main.Noita;

public class Fire extends AbstractParticle {
    public static int velocity = 5;

    public Fire(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        boolean death = true;

        for (int k = 1; k < velocity; k++) {
            if (!(check(x-k,y-k))) death = false;
            if (!(check(x  ,y-k))) death = false;
            if (!(check(x+k,y-k))) death = false;

            if (!(check(x-k,y  ))) death = false;
            if (!(check(x+k,y  ))) death = false;

            if (!(check(x-k,y+k))) death = false;
            if (!(check(x  ,y+k))) death = false;
            if (!(check(x+k,y+k))) death = false;
        }

        if (death && Math.random() < 0.05) {
            Engine.field[x][y] = null;
        }
    }

    public Boolean check(int x, int y) {
        if (is("not empty",x,y)) {
            if (Engine.field[x][y].getFlammability() > 0) {
                if (Math.random() < Engine.field[x][y].getFlammability()) {
                    Noita.engine.createParticle("fire", x, y);
//                    Noita.engine.createParticle("smoke",this.x,this.y);
                }
                return false;
            } else return true;
        } else return true;
    }
}

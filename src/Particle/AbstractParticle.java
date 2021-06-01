package Particle;

import Main.*;
import Particle.Particles.AbstractGas;
import Particle.Particles.AbstractLiquid;
import Particle.Particles.AbstractSolid;
import Particle.Particles.Gas.Smoke;
import Particle.Particles.Gas.Steam;
import Particle.Particles.Liquid.Acid;
import Particle.Particles.Liquid.Oil;
import Particle.Particles.Liquid.Water;
import Particle.Particles.Solid.AbstractImmovableSolid;
import Particle.Particles.Solid.MovableSolid.Salt;
import Particle.Particles.Solid.MovableSolid.Sand;
import Particle.Particles.Solid.ImmovableSolid.Stone;
import Particle.Particles.Solid.ImmovableSolid.Wood;

public class AbstractParticle {
    public int x;
    public int y;
    public double flammability = 0;
    public double acidability = 0;
    public int velocity = 1;
    public int density = 0;

    public AbstractParticle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {}

    public void moveTo(int x, int y) {
        if (Engine.field[this.x][this.y] != null) {
            Engine.field[x][y] = Engine.field[this.x][this.y];
            Engine.field[this.x][this.y] = null;
            this.x = x;
            this.y = y;
        }
    }

//    public int moveCheck() {
//
//    }
//
//    public void moveConfirm() {
//
//    }

    public void swapWith(int x, int y) {
        if (Engine.field[this.x][this.y] != null) {
            if (Engine.field[x][y] != null) {
                int a = 0;
                int b = 0;
                Engine.field[x][y].moveTo(a, b);
                int oldX = this.x;
                int oldY = this.y;
                Engine.field[this.x][this.y].moveTo(x, y);
                Engine.field[a][b].moveTo(oldX, oldY);
            } else moveTo(x,y);
        }
    }

    public Boolean is(String name, int x, int y) {
        if ((x <= Engine.width-1) & (y <= Engine.height-1) & (x >= 0) & (y >= 0)) {
            if (name.equalsIgnoreCase("empty")) return Engine.field[x][y] == null;
            else if (name.equalsIgnoreCase("not empty")) return Engine.field[x][y] != null;
                //Gases
            else if (name.equalsIgnoreCase("gas"))   return Engine.field[x][y] instanceof AbstractGas;
            else if (name.equalsIgnoreCase("smoke")) return Engine.field[x][y] instanceof Smoke;
            else if (name.equalsIgnoreCase("steam")) return Engine.field[x][y] instanceof Steam;
                //Liquids
            else if (name.equalsIgnoreCase("liquid")) return Engine.field[x][y] instanceof AbstractLiquid;
            else if (name.equalsIgnoreCase("acid"))   return Engine.field[x][y] instanceof Acid;
            else if (name.equalsIgnoreCase("oil"))    return Engine.field[x][y] instanceof Oil;
            else if (name.equalsIgnoreCase("water"))  return Engine.field[x][y] instanceof Water;
                //Solid
            else if (name.equalsIgnoreCase("solid")) return Engine.field[x][y] instanceof AbstractSolid;
                //Immovable solids
            else if (name.equalsIgnoreCase("immovable solid")) return Engine.field[x][y] instanceof AbstractImmovableSolid;
            else if (name.equalsIgnoreCase("stone"))           return Engine.field[x][y] instanceof Stone;
            else if (name.equalsIgnoreCase("wood"))            return Engine.field[x][y] instanceof Wood;
                //Movable solids
            else if (name.equalsIgnoreCase("movable solid")) return Engine.field[x][y] instanceof AbstractImmovableSolid;
            else if (name.equalsIgnoreCase("salt"))          return Engine.field[x][y] instanceof Salt;
            else if (name.equalsIgnoreCase("sand"))          return Engine.field[x][y] instanceof Sand;
                //Fire
            else if (name.equalsIgnoreCase("fire")) return Engine.field[x][y] instanceof Fire;
            else return false;
        } else return false;
    }

    public double getFlammability() {
        return this.flammability;
    }

    public double getAcidability() {
        return this.acidability;
    }

    public int getDensity() {
        return this.density;
    }

    public int getVelocity() {
        return this.velocity;
    }
}

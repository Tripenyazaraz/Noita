public class Sand extends BaseParticle implements ParticleInterface {
    //конструктор
    public Sand(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public void update(int x, int y) {
        //если частица не на нижней границе то
        if (y != Engine.height-1) {
            //если снизу от частицы пусто то
            if (Engine.field[x][y+1] == null) {
                //переместить частицу вниз
                Engine.field[x][y].moveTo(x,y+1);
            }
            //иначе если частица не у левого края то
            else if (x != 0) {
                //если слева снизу от частицы пусто то
                if (Engine.field[x-1][y+1] == null) {
                    //переместить частицу влева вниз
                    Engine.field[x][y].moveTo(x-1,y+1);
                }
                //иначе если частица не у правого края то
                else if (x != Engine.width-1) {
                    //если справа снизу от частицы пусто то
                    if (Engine.field[x + 1][y + 1] == null) {
                        //переместить частицу справа вниз
                        Engine.field[x][y].moveTo(x+1,y+1);
                    }
                }
            }
            //иначе если частица не у правого края то
            else if (x != Engine.width-1) {
                //если справа снизу от частицы пусто то
                if (Engine.field[x + 1][y + 1] == null) {
                    //переместить частицу справа вниз
                    Engine.field[x][y].moveTo(x+1,y+1);
                }
            }
        }
    }
}
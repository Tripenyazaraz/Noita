import Pixel.*;
import Pixel.Gas.Steam;
import Pixel.Liquid.Water;
import Pixel.Powder.Sand;

public class Engine {
    //переменные
    PixelInterface[] field = new PixelInterface[100];

    //конструктор
    public Engine() {
        System.out.println("конструктор");
    }

    //один ход
    public void updateField() {
        System.out.println("ход");
    }

    //создание пикселя
    public void generatePixel(int pixelType) {
        //выбор пикселя
        if (pixelType == 1) {
            field[1] = new Sand();
        } else if (pixelType == 2) {
            field[1] = new Water();
        } else if (pixelType == 3) {
            field[1] = new Steam();
        } else {
            System.out.println("температура");
        }

        field[1].generate();
    }
}

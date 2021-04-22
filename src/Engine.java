import Pixel.*;
import Pixel.Gas.Steam;
import Pixel.Liquid.Water;
import Pixel.Powder.Sand;

public class Engine {
    //переменные
    BasePixel[] field = new BasePixel[100];

    //конструктор
    public Engine() {
        System.out.println("конструктор");
    }

    //один ход
    public void updateField() {
        System.out.println("ход");
    }

    //создание пикселя
    public void generatePixel(BasePixel blanc) {
        field[1] = blanc;
    }
}

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
    public void generatePixel(String pixelName, int i) {
        switch (pixelName) {
            case "Steam" -> field[i] = new Steam();
            case "Water" -> field[i] = new Water();
            case "Sand" -> field[i] = new Sand();
            default -> System.out.println("Нет пикселя с таким именем");
        }
    }
}
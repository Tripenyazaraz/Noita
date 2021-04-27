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
    public void generatePixel(String pixelName, int x, int y, int i) {
        switch (pixelName) {
            case "Steam" -> field[i] = new Steam(x, y);
            case "Water" -> field[i] = new Water(x, y);
            case "Sand" -> field[i] = new Sand(x, y);
            default -> System.out.println("Нет пикселя с таким именем");
        }
        System.out.println(field[i].getX());
        System.out.println(field[i].getY());
    }
}
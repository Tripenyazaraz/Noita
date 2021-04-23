import Pixel.BasePixel;
import Pixel.Gas.Steam;
import Pixel.Liquid.Water;
import Pixel.Powder.Sand;

public class Noita {
    //переменные
    public static String currentPixelName = "none";  //текущий выбранный пиксель
    public static BasePixel currentPixel;

    public static void main(String[] args) {
        Engine mainEngine = new Engine();  //создание основного движка

        currentPixelName = "Steam";                         //выбор пикселя (это должно быть в кнопке)
        mainEngine.generatePixel(currentPixelName, 1);   //создание пикселя (это должно быть при клике на поле)
    }
}
import Pixel.BasePixel;
import Pixel.Gas.Steam;
import Pixel.Liquid.Water;
import Pixel.Powder.Sand;

public class Noita {
    //переменные
    public static String currentPixelName = "unchosen";  //текущий выбранный пиксель
    public static int io = 1;

    public static void main(String[] args) {
        Engine mainEngine = new Engine();  //создание основного движка

        choosePixel("Water");                     //выбор пикселя (это должно быть в кнопке)
        mainEngine.generatePixel(currentPixelName, 1);   //создание пикселя (это должно быть при клике на поле)
    }

    //выбор пикселя (будет на кнопках в панели меню)
    public static void choosePixel(String pixelName) {
        switch (pixelName) {
            case "Steam" -> currentPixelName = "Steam";
            case "Water" -> currentPixelName = "Water";
            case "Sand" -> currentPixelName = "Sand";
            default -> System.out.println("Неправильное имя пикселя");
        }
    }
}
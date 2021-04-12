package Pixel.Gas;

import Pixel.PixelInterface;

public class Steam extends BaseGas implements PixelInterface {

    public void generate() {
        System.out.println("пар создан");
    }
}
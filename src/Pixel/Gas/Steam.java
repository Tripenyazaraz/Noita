package Pixel.Gas;

import Pixel.PixelInterface;

public class Steam extends BaseGas implements PixelInterface {

    @Override
    public void generate() {
        System.out.println("пар");
    }
}

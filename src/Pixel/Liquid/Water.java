package Pixel.Liquid;

import Pixel.PixelInterface;

public class Water extends BaseLiquid implements PixelInterface {

    @Override
    public void generate() {
        System.out.println("вода");
    }
}

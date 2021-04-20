package Pixel.Powder;

import Pixel.PixelInterface;

public class Sand extends BasePowder implements PixelInterface {

    @Override
    public void generate() {
        System.out.println("песок");
    }
}

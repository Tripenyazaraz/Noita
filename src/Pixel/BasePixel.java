package Pixel;

public class BasePixel {
    private int x;
    private int y;

    //конструктор
    public BasePixel(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    //геттеры координат
    public int getX() {
      return this.x;
    }
    public int getY() {
        return this.y;
    }
    //сеттеры координат
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
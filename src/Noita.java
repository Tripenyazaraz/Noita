import java.io.IOException;

public class Noita {
    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();
        Engine.field[1][0] = new Sand(1,0);
        Engine.field[1][1] = new Sand(1,1);
        Engine.field[1][2] = new Sand(1,2);


        /* ввод от пользователя
            a - шаг
            b - отрисовка
            с - выход
        */
        char command = 0;
        while (command != 'c') {
            command = (char)System.in.read();
            if (command == 'a') {
                engine.step();
            }
            if (command == 'b') {
                engine.draw();
            }
        }
    }
}
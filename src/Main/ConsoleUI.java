package Main;

import java.util.HashSet;
import java.util.Scanner;

public class ConsoleUI {
    public static void init() {
        Engine engine = new Engine();

        //сканнер для ввода в консоль
        Scanner console = new Scanner(System.in);
        //параметры для создания частицы
        String userInput = "";
        int currentX;
        int currentY;
        //множество названий частиц
        HashSet particleSet = new HashSet();
                particleSet.add("sand");
                particleSet.add("water");
                particleSet.add("steam");
                particleSet.add("stone");
        HashSet commandSet = new HashSet();
                commandSet.add("/exit");
                commandSet.add("/cls");

        //ВЗАИМОДЕЙСТВИЕ С ПОЛЬЗОВАТЕЛЕМ
        while (!(userInput.equals("/exit"))) {
            System.out.print("Введите название пикселя или \"/exit\" для выхода -> ");
            userInput = console.nextLine();       //ввод пользователя
            userInput = userInput.toLowerCase();

            // ---ЕСЛИ ЭТО НАЗВАНИЕ ЧАСТИЦЫ
            if (particleSet.contains(userInput)) {
                engine.step();                                  //шаг физики
                System.out.print("Введите X координату -> ");   //ввод координат
                currentX = console.nextInt();
                System.out.print("Введите Y координату -> ");
                currentY = console.nextInt();
                engine.createParticle(userInput,currentX,currentY); //генерация частицы
                engine.draw();        //прорисовка
                console.nextLine();   //магия ебаного сканнера

            // ---ЕСЛИ ВВОД НЕПРАВИЛЬНЫЙ
            } else if (!(commandSet.contains(userInput))) {
                System.out.println("Неправильное название частицы!");

           // ---ЕСЛИ ЭТО КОМАНДА /cls
            } else if (userInput.equals("/cls")) {
                engine.clean();  //очищение
                engine.draw();
            }
        }
    }
}

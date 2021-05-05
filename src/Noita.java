import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;

public class Noita {
    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();

        //сканнер для ввода в консоль
        Scanner console = new Scanner(System.in);
        //параметры для создания частицы
        String currentParticleName = null;
        int currentParticleX;
        int currentParticleY;
        //множество названий частиц
        HashSet particleSet = new HashSet();
        particleSet.add("sand");
        particleSet.add("water");
        particleSet.add("steam");

        //ВЗАИМОДЕЙСТВИЕ С ПОЛЬЗОВАТЕЛЕМ
        while (currentParticleName != "exit") {
            System.out.print("Введите название пикселя или exit для выхода -> ");
            currentParticleName = console.nextLine();
            if (currentParticleName.toLowerCase(Locale.ROOT) != "exit") {
                if (particleSet.contains(currentParticleName.toLowerCase(Locale.ROOT))) {
                    //шаг физики
                    engine.step();
                    //ввод X
                    System.out.print("Введите X координату -> ");
                    currentParticleX = console.nextInt();
                    //ввод Y
                    System.out.print("Введите Y координату -> ");
                    currentParticleY = console.nextInt();
                    //создание частицы
                    engine.createParticle(currentParticleName.toLowerCase(Locale.ROOT), currentParticleX, currentParticleY);
                    //прорисовка
                    engine.draw();
                    //отступы
                    System.out.println();
                    System.out.println();
                    //магия ебаного сканнера
                    console.nextLine();
                } else {
                    System.out.println("Неправильное название частицы!");
                }
            }
        }

    }
}
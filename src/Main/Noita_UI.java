package Main;

import Main.Interface.DrawTimerTask;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import java.util.TimerTask;
import java.io.InputStream;
import java.util.Timer;

public class Noita_UI extends Application{
    public static final int GAME_PANEL_WIDTH = 800;
    public static final int MENU_PANEL_WIDTH = 100;
    public static final int HEIGHT = 800;
    Engine engine = new Engine();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        mainStage.getIcons().add(getImage("icon.png"));

        //главная группа
        HBox root = new HBox();
        //канвас и его контекст
        Canvas canvas = new Canvas(GAME_PANEL_WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        //группа для выбора пикселя
        VBox menu = new VBox(10);
        menu.setStyle("-fx-background-color: #5D5D5D;");
        menu.setPadding(new Insets(10,12,0,12));
            //кнопка erase
            Button erase = new Button("Erase");
            erase.setMinSize(60, 10);
            menu.getChildren().add(erase);
            //кнопка sand
            Button sand = new Button("Sand");
            sand.setMinSize(60, 10);
            menu.getChildren().add(sand);
            //кнопка water
            Button water = new Button("Water");
            water.setMinSize(60, 10);
            menu.getChildren().add(water);
            //кнопка steam
            Button steam = new Button("Steam");
            steam.setMinSize(60, 10);
            menu.getChildren().add(steam);
            //кнопка acid
            Button acid = new Button("Acid");
            acid.setMinSize(60, 10);
            menu.getChildren().add(acid);
            //кнопка oil
            Button oil = new Button("Oil");
            oil.setMinSize(60, 10);
            menu.getChildren().add(oil);
            //кнопка wood
            Button wood = new Button("Wood");
            wood.setMinSize(60, 10);
            menu.getChildren().add(wood);
            //кнопка stone
            Button stone = new Button("Stone");
            stone.setMinSize(60, 10);
            menu.getChildren().add(stone);
            //кнопка fire
            Button fire = new Button("Fire");
            fire.setMinSize(60, 10);
            menu.getChildren().add(fire);
        //добавление меню в главную группу
        root.getChildren().add(menu);

        //создание сцены с главной группой
        Scene scene = new Scene(root);                        //создать сцену и добавить в неё группу

        //создание стейджа со сценой
        mainStage.setScene(scene);                            //добавить сцену в стейдж
        mainStage.setTitle("Noita");
        mainStage.setWidth(GAME_PANEL_WIDTH + MENU_PANEL_WIDTH);
        mainStage.setHeight(HEIGHT);
        mainStage.setResizable(false);
        mainStage.show();

        //таймер
        TimerTask timerTask = new DrawTimerTask(gc, engine);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 500);
    }

    //возвращает image объект.
    public Image getImage(String path) {
        InputStream imageStream = this.getClass().getResourceAsStream("/Images/" + path);
        return new Image(imageStream);
    }
}
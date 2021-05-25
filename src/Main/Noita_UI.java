package Main;

import Main.Interface.DrawTimerTask;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.TimerTask;
import java.io.InputStream;
import java.util.Timer;

public class Noita_UI extends Application{
    public static final int GAME_PANEL_WIDTH = 800;
    public static final int MENU_PANEL_WIDTH = 100;
    public static final int HEIGHT = 800;
    public static final int WTF = 39;
    public static Engine engine = new Engine();
    String userInput = "erase";
    int W = 7;
    int H = 7;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        mainStage.getIcons().add(getImage("icon.png"));
        engine.clean();

        //главная группа
        HBox root = new HBox();
        //канвас и его контекст
        Canvas canvas = new Canvas(GAME_PANEL_WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //действие при клике
        EventHandler<MouseEvent> mouseEvent = e -> {
            if ((toInt(e.getX()) >= 0) & (toInt(e.getY()) >= 0) &
                    (toInt(e.getX()) <= GAME_PANEL_WIDTH-1) & (toInt(e.getY()) <= HEIGHT-1))
                for (int i = 0; i < H; i++)
                    for (int j = 0; j < W; j++)
                        if ((toInt(e.getX())-W/2+j >= 0)&(toInt(e.getY())-H/2+i >= 0) &
                                (toInt(e.getX())-W/2+j <= GAME_PANEL_WIDTH-1)&(toInt(e.getY())-H/2+i <= HEIGHT-1))
                        engine.createParticle(userInput,toInt(e.getX())-W/2+j,toInt(e.getY())-H/2+i);
        };
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseEvent);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent);

        root.getChildren().add(canvas);

        //группа для выбора пикселя
        VBox menu = new VBox(10);
        menu.setStyle("-fx-background-color: #5D5D5D;");
        menu.setPadding(new Insets(10,12,0,12));
            //кнопка erase
            Button erase = new Button("Erase");
            erase.setMinSize(60, 10);
            erase.setOnAction(event -> userInput = "erase");
            menu.getChildren().add(erase);
            //кнопка sand
            Button sand = new Button("Sand");
            sand.setMinSize(60, 10);
            sand.setOnAction(event -> userInput = "sand");
            menu.getChildren().add(sand);
            //кнопка water
            Button water = new Button("Water");
            water.setMinSize(60, 10);
            water.setOnAction(event -> userInput = "water");
            menu.getChildren().add(water);
            //кнопка steam
            Button steam = new Button("Steam");
            steam.setMinSize(60, 10);
            steam.setOnAction(event -> userInput = "steam");
            menu.getChildren().add(steam);
            //кнопка stone
            Button stone = new Button("Stone");
            stone.setMinSize(60, 10);
            stone.setOnAction(event -> userInput = "stone");
            menu.getChildren().add(stone);
            //кнопка acid
            Button acid = new Button("Acid");
            acid.setMinSize(60, 10);
            acid.setOnAction(event -> userInput = "acid");
            menu.getChildren().add(acid);
            //кнопка oil
            Button oil = new Button("Oil");
            oil.setMinSize(60, 10);
            oil.setOnAction(event -> userInput = "oil");
            menu.getChildren().add(oil);
            //кнопка wood
            Button wood = new Button("Wood");
            wood.setMinSize(60, 10);
            wood.setOnAction(event -> userInput = "wood");
            menu.getChildren().add(wood);
            //кнопка fire
            Button fire = new Button("Fire");
            fire.setMinSize(60, 10);
            fire.setOnAction(event -> userInput = "fire");
            menu.getChildren().add(fire);
        //добавление меню в главную группу
        root.getChildren().add(menu);

        //создание сцены с главной группой
        Scene scene = new Scene(root);                        //создать сцену и добавить в неё группу

        //создание стейджа со сценой
        mainStage.setScene(scene);                            //добавить сцену в стейдж
        mainStage.setTitle("Noita");
        mainStage.setWidth(GAME_PANEL_WIDTH + MENU_PANEL_WIDTH);
        mainStage.setHeight(HEIGHT+WTF);
        mainStage.setResizable(false);
        mainStage.show();

        //таймер
        TimerTask timerTask = new DrawTimerTask(gc);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 30);
    }

    //возвращает image объект.
    public Image getImage(String path) {
        InputStream imageStream = this.getClass().getResourceAsStream("/Images/" + path);
        return new Image(imageStream);
    }
    //конвертирует Double в int
    public int toInt(Double x) {
        return (int) Math.round(x);
    }
}
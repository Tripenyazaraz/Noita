//--module-path ${PATH_TO_FX} --add-modules javafx.controls,javafx.fxml
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

public class Noita extends Application{
    //CONSTANTS
    public static final int GAME_PANEL_WIDTH = 800;
    public static final int MENU_PANEL_WIDTH = 100;
    public static final int HEIGHT = 800;
    public static final int WTF = 39;

    //variables
    public static Engine engine = new Engine();

    int W = 10; //size of generate particles
    int H = 10;

    int mouseX = 0; //for current mouse position
    int mouseY = 0;

    String whichButton;             //what button is pressed
    String chosenParticle = "sand"; //which particle is chosen
    String toPaste;                 //paste or erase
    Boolean isPressed = false;      //is button pressed
    Timer mouseTimer;               //global timer to mouseClick


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        Canvas canvas = createGUI(mainStage);

        //physics and draw timer
        TimerTask timerTask = new DrawTimerTask(canvas.getGraphicsContext2D());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 50);
    }

    //create all GUI and return canvas
    public Canvas createGUI(Stage mainStage) {
        mainStage.getIcons().add(getImage("/Images/icon1.png"));

        //group and canvas
        HBox root = new HBox();
        Canvas canvas = new Canvas(GAME_PANEL_WIDTH, HEIGHT);

        //mouseTask
        TimerTask mouseTask = new TimerTask() {
            @Override
            public void run() {
                if (isPressed)
                    if ((mouseX >= 0) & (mouseY >= 0) &
                            (mouseX <= GAME_PANEL_WIDTH-1) & (mouseY <= HEIGHT-1)) {
                        switch (whichButton) {
                            case ("PRIMARY") -> toPaste = chosenParticle;
                            case ("SECONDARY") -> toPaste = "erase";
                        }
                        for (int i = 0; i < H; i++)
                            for (int j = 0; j < W; j++)
                                if ((mouseX-W/2+j >= 0)&(mouseY-H/2+i >= 0) &
                                        (mouseX-W/2+j <= GAME_PANEL_WIDTH-1)&(mouseY-H/2+i <= HEIGHT-1))
                                    engine.createParticle(toPaste,mouseX-W/2+j,mouseY-H/2+i);
                    }
            }
        };

        //mouseEvent's
        this.mouseTimer = new Timer();
        this.mouseTimer.scheduleAtFixedRate(mouseTask,0,5);
        EventHandler<MouseEvent> mouseEventStart = e -> {
            isPressed = true;
            mouseX = toInt(e.getX());
            mouseY = toInt(e.getY());
            whichButton = e.getButton().toString();
        };
        EventHandler<MouseEvent> mouseEventStop = e -> {
            isPressed = false;
        };
        EventHandler<MouseEvent> mouseEventMoved = e -> {
            mouseX = toInt(e.getX());
            mouseY = toInt(e.getY());
        };

        //canvass add mouseEvent's
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEventStart);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,mouseEventStop);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,mouseEventMoved);
        root.getChildren().add(canvas);

        //particle menu
        VBox menu = new VBox(10);
        menu.setStyle("-fx-background-color: #5D5D5D;");
        menu.setPadding(new Insets(10,12,0,12));
        //sand button
        Button sand = new Button("Sand");
        sand.setMinSize(60, 10);
        sand.setOnAction(event -> chosenParticle = "sand");
        menu.getChildren().add(sand);
        //water button
        Button water = new Button("Water");
        water.setMinSize(60, 10);
        water.setOnAction(event -> chosenParticle = "water");
        menu.getChildren().add(water);
        //steam button
        Button steam = new Button("Steam");
        steam.setMinSize(60, 10);
        steam.setOnAction(event -> chosenParticle = "steam");
        menu.getChildren().add(steam);
        //stone button
        Button stone = new Button("Stone");
        stone.setMinSize(60, 10);
        stone.setOnAction(event -> chosenParticle = "stone");
        menu.getChildren().add(stone);
        //acid button
        Button acid = new Button("Acid");
        acid.setMinSize(60, 10);
        acid.setOnAction(event -> chosenParticle = "acid");
        menu.getChildren().add(acid);
        //oil button
        Button oil = new Button("Oil");
        oil.setMinSize(60, 10);
        oil.setOnAction(event -> chosenParticle = "oil");
        menu.getChildren().add(oil);
        //wood button
        Button wood = new Button("Wood");
        wood.setMinSize(60, 10);
        wood.setOnAction(event -> chosenParticle = "wood");
        menu.getChildren().add(wood);
        //fire button
        Button fire = new Button("Fire");
        fire.setMinSize(60, 10);
        fire.setOnAction(event -> chosenParticle = "fire");
        menu.getChildren().add(fire);
        //group add particle menu
        root.getChildren().add(menu);

        //scene and stage
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.setTitle("Noita");
        mainStage.setWidth(GAME_PANEL_WIDTH + MENU_PANEL_WIDTH);
        mainStage.setHeight(HEIGHT+WTF);
        mainStage.setResizable(false);
        mainStage.show();

        //return graphics context
        return canvas;
    }
    //return imageStream
    public Image getImage(String path) {
        InputStream imageStream = this.getClass().getResourceAsStream(path);
        return new Image(imageStream);
    }
    //double to int
    public int toInt(Double x) {
        return (int) Math.round(x);
    }
}
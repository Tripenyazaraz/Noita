package Main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.TimerTask;
import java.io.InputStream;
import java.util.Timer;

public class Noita extends Application{
    //CONSTANTS
    public static final int GAME_WIDTH = 500;
    public static final int MENU_WIDTH = 120;
    public static final int HEIGHT = 500;
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 10;
    public static final int ADDITIONAL_CANVAS_SIZE = 37;
    public static final int MEXICAN_WALL = 4;

    public static final Color labelColor = Color.rgb(250,250,250);

    //variables
    public static Engine engine = new Engine();
    public static boolean toClean = false;
    String whichButton;              //what button is pressed
    String chosenParticle = "erase"; //which particle is chosen
    String toPaste;                  //paste or erase
    Boolean isPressed = false;       //is button pressed
    Timer mouseTimer;                //global timer to mouseClick

    int mouseX = 0; //for current mouse position
    int mouseY = 0;
    int W = 10;  //size of generate particles
    int H = 10;
    int stepPerSecond = 3;  //rate of physic step and draw
    int drawPerSecond = 50;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        Canvas canvas = createGUI(mainStage);

        //Draw Task
        TimerTask drawTask = new TimerTask() {
            @Override
            public void run() {
                engine.draw(canvas.getGraphicsContext2D());
            }
        };
        //Draw Timer
        Timer timerDraw = new Timer();
        timerDraw.scheduleAtFixedRate(drawTask,0,drawPerSecond);

        //Physic Task
        TimerTask stepTask = new TimerTask() {
            @Override
            public void run() {
                engine.step();
            }
        };
        //Physic Timer
        Timer timerStep = new Timer();
        timerStep.scheduleAtFixedRate(stepTask,0,stepPerSecond);
        //Close event
        mainStage.setOnCloseRequest(event -> {
            timerStep.cancel();
            timerDraw.cancel();
            Platform.exit();
            System.exit(0);
        });
    }

    //create all GUI and return canvas
    public Canvas createGUI(Stage mainStage) {
        mainStage.getIcons().add(getImage("/Images/icon2.png"));

        //group and canvas
        HBox root = new HBox(MEXICAN_WALL);
        Canvas canvas = new Canvas(GAME_WIDTH, HEIGHT);

        //mouseTask
        TimerTask mouseTask = new TimerTask() {
            @Override
            public void run() {
                if (isPressed)
                    if ((mouseX >= 0) & (mouseY >= 0) &
                            (mouseX <= GAME_WIDTH -1) & (mouseY <= HEIGHT -1)) {
                        switch (whichButton) {
                            case ("PRIMARY") -> toPaste = chosenParticle;
                            case ("SECONDARY") -> toPaste = "erase";
                        }
                        for (int i = 0; i < H; i++)
                            for (int j = 0; j < W; j++)
                                if ((mouseX-W/2+j >= 0)&(mouseY-H/2+i >= 0) &
                                        (mouseX-W/2+j <= GAME_WIDTH -1)&(mouseY-H/2+i <= HEIGHT -1))
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
        EventHandler<MouseEvent> mouseEventStop = e -> isPressed = false;
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
        menu.setStyle("-fx-background-color: #45464a;");
        menu.setPadding(new Insets(10,10,10,12)); //Top 0 0 Left
            //label
            Label label1 = new Label("Choose particle");
            label1.setWrapText(true);
            label1.setTextFill(labelColor);
            menu.getChildren().add(label1);
            //eraseAll button
            Button eraseAll = new Button("ERASE ALL");
            eraseAll.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            eraseAll.setOnAction(event -> toClean = true);
            menu.getChildren().add(eraseAll);
            //Smoke button
            Button btnSmoke = new Button("Smoke");
            btnSmoke.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnSmoke.setOnAction(event -> chosenParticle = "smoke");
            menu.getChildren().add(btnSmoke);
            //Steam button
            Button btnSteam = new Button("Steam");
            btnSteam.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnSteam.setOnAction(event -> chosenParticle = "steam");
            menu.getChildren().add(btnSteam);
            //Acid button
            Button btnAcid = new Button("Acid");
            btnAcid.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnAcid.setOnAction(event -> chosenParticle = "acid");
            menu.getChildren().add(btnAcid);
            //Oil button
            Button btnOil = new Button("Oil");
            btnOil.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnOil.setOnAction(event -> chosenParticle = "oil");
            menu.getChildren().add(btnOil);
            //Water button
            Button btnWater = new Button("Water");
            btnWater.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnWater.setOnAction(event -> chosenParticle = "water");
            menu.getChildren().add(btnWater);
            //Glass button
            Button btnGlass = new Button("Glass");
            btnGlass.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnGlass.setOnAction(event -> chosenParticle = "glass");
            menu.getChildren().add(btnGlass);
            //Stone button
            Button btnStone = new Button("Stone");
            btnStone.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnStone.setOnAction(event -> chosenParticle = "stone");
            menu.getChildren().add(btnStone);
            //Wood button
            Button btnWood = new Button("Wood");
            btnWood.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnWood.setOnAction(event -> chosenParticle = "wood");
            menu.getChildren().add(btnWood);
            //Wood button
            Button btnSalt = new Button("Salt");
            btnSalt.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnSalt.setOnAction(event -> chosenParticle = "salt");
            menu.getChildren().add(btnSalt);
            //Sand button
            Button btnSand = new Button("Sand");
            btnSand.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            btnSand.setOnAction(event -> chosenParticle = "sand");
            menu.getChildren().add(btnSand);
            //fire button
            Button fire = new Button("Fire");
            fire.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
            fire.setOnAction(event -> chosenParticle = "fire");
            menu.getChildren().add(fire);
            //label
            Label label2 = new Label("LMB to create RMB to erase");
            label2.setWrapText(true);
            label2.setTextFill(labelColor);
            menu.getChildren().add(label2);
        //group add particle menu
        root.getChildren().add(menu);

        //scene and stage
        Scene scene = new Scene(root);
        mainStage.setScene(scene);
        mainStage.setTitle("Noita");
        mainStage.setWidth(GAME_WIDTH + MENU_WIDTH + MEXICAN_WALL);
        mainStage.setHeight(HEIGHT + ADDITIONAL_CANVAS_SIZE);
        mainStage.setResizable(false);
        mainStage.show();

        //return canvas
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
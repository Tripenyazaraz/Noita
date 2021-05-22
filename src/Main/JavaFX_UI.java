package Main;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;

import java.io.IOException;
import java.io.InputStream;

public class JavaFX_UI extends Application{
    final int GAME_PANEL_WIDTH = 800;
    final int MENU_PANEL_WIDTH = 200;
    final int HEIGHT = 800;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mainStage) {
        createGUI(mainStage);
    }

    public void createGUI(Stage mainStage) {
        mainStage.getIcons().add(getImage("icon.png"));

        Group group = new Group(); //вот сюда параметрами передавать что будет в окне

        Scene scene = new Scene(group);

        mainStage.setScene(scene);
        mainStage.setTitle("Noita");
        mainStage.setWidth(GAME_PANEL_WIDTH + MENU_PANEL_WIDTH);
        mainStage.setHeight(HEIGHT);
        mainStage.setResizable(false);
        mainStage.show();
    }

    //возвращает image объект.
    public Image getImage(String path) {
        InputStream imageStream = this.getClass().getResourceAsStream("/images/" + path);
        return new Image(imageStream);
    }
}
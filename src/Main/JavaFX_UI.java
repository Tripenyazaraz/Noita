package Main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

public class JavaFX_UI extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // установка надписи
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(100);   // установка положения надписи по оси X

        Group group = new Group(text);

        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }
}
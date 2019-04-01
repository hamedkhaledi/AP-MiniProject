package Model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PageLoader {
    private static Stage stage;

    public static void initStage(Stage primaryStage) {
        stage = primaryStage;
        stage.setResizable(false);
        stage.setWidth(450);
        stage.setHeight(650);

    }

    public void load(String url) throws Exception {
        Parent Root = FXMLLoader.load(getClass().getResource(url));
        initStage(stage);
        stage.setScene(new Scene(Root, 450, 650));
        stage.show();
    }
}

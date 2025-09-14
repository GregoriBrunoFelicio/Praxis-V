package praxisv;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenUtils {

    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;

    public static void openScene(Stage stage, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenUtils.class.getResource(fxmlPath));
            Scene scene = new Scene(loader.load(), WIDTH, HEIGHT);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.centerOnScreen();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
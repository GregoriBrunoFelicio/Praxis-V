package praxisv;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.Objects;

public class LoginController {
    @FXML
    protected void onLoginClick() throws Exception {
        // Carrega a segunda tela (main-view)
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/main-view.fxml"));
        Scene mainScene = new Scene(fxmlLoader.load(), 1920, 1080);

        // Pega a janela atual e troca a cena
        Objects.requireNonNull(FXMLLoader.getDefaultClassLoader()
                .loadClass("praxisv.LoginController")
                .getResource("")).openStream().getClass().getEnclosingClass().getDeclaredConstructor().newInstance();
        Stage stage;

        stage = (Stage) Stage.getWindows().filtered(Window::isShowing).get(0);
        stage.setTitle("Tela Principal - PraxisV");
        stage.setScene(mainScene);
    }
}

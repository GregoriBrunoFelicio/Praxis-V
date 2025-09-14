package praxisv;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    protected void onLoginClick(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("usuario-view.fxml"));
        Scene usuarioScene = new Scene(fxmlLoader.load(), 1920, 1080);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Cadastro de Usuário");
        stage.setScene(usuarioScene);
    }
}

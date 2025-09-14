package praxisv;

import application.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    private final LoginService loginService = new LoginService();

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField senhaField;

    @FXML
    protected void onLoginClick() {
        String login = loginField.getText();
        String senha = senhaField.getText();

        if (loginService.autenticar(login, senha)) {
            abrirTelaPrincipal();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Login ou senha inválidos!");
            alert.showAndWait();
        }
    }

    private void abrirTelaPrincipal() {
        try {
            Stage stage = (Stage) loginField.getScene().getWindow();
            ScreenUtils.openScene(stage, "main-view.fxml", "PraxisV - Sistema de Gestão");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


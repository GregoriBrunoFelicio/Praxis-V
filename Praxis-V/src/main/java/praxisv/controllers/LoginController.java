package praxisv.controllers;

import application.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import praxisv.ScreenUtils;

public class LoginController {
    private final LoginService loginService = new LoginService();

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField senhaField;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
        configurarEventos();
    }

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
            ScreenUtils.openScene(stage, "pages/main-view.fxml", "PraxisV - Sistema de Gestão");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void configurarEventos() {
        loginButton.setDisable(true);
        loginField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        senhaField.textProperty().addListener((obs, oldVal, newVal) -> validarCampos());
        senhaField.setOnAction(event -> {
            if (camposValidos()) {
                onLoginClick();
            }
        });
    }

    private void validarCampos() {
        loginButton.setDisable(!camposValidos());
    }

    private boolean camposValidos() {
        return loginField.getText() != null && !loginField.getText().isBlank()
                && senhaField.getText() != null && !senhaField.getText().isBlank();
    }
}


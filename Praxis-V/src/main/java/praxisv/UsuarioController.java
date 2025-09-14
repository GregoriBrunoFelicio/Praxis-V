package praxisv;

import application.UsuarioService;
import domain.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @FXML
    private TextField nomeCompletoField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField cargoField;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField senhaField;

    @FXML
    protected void onCadastrarClick() {
        Usuario usuario = new Usuario(
                nomeCompletoField.getText(),
                cpfField.getText(),
                emailField.getText(),
                cargoField.getText(),
                loginField.getText(),
                senhaField.getText()
        );

        usuarioService.cadastrarUsuario(usuario);

        System.out.println("Usuário cadastrado com sucesso: " + usuario);

        limparCampos();
    }

    private void limparCampos() {
        nomeCompletoField.clear();
        cpfField.clear();
        emailField.clear();
        cargoField.clear();
        loginField.clear();
        senhaField.clear();
    }
}

package praxisv.controllers;

import application.UsuarioService;
import domain.enums.Perfil;
import domain.entities.Usuario;

import domain.validators.UsuarioValidator;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class UsuarioController {
    private final UsuarioService usuarioService = new UsuarioService();
    private final UsuarioValidator validator = new UsuarioValidator();

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
    private PasswordField senhaConfirmField;

    @FXML
    private ComboBox<Perfil> perfilComboBox;

    @FXML
    private TableColumn<Usuario, Integer> colId;
    @FXML
    private TableColumn<Usuario, String> colNome;
    @FXML
    private TableColumn<Usuario, String> colEmail;
    @FXML
    private TableColumn<Usuario, String> colCargo;
    @FXML
    private TableColumn<Usuario, String> colLogin;
    @FXML
    private TableColumn<Usuario, String> colPerfil;
    @FXML
    private TableView<Usuario> usuarioTable;

    @FXML
    public void initialize() {

        perfilComboBox.getItems().setAll(Perfil.values());
        CriarTabela();
        atualizarTabela();
    }

    @FXML
    protected void onCadastrarClick() {
        criarUsuario();

    }

    private void criarUsuario() {
        if (!senhaField.getText().equals(senhaConfirmField.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("As senhas não coincidem!");
            alert.showAndWait();
            return;
        }
        Usuario usuario = new Usuario(
                nomeCompletoField.getText(),
                cpfField.getText(),
                emailField.getText(),
                cargoField.getText(),
                loginField.getText(),
                senhaField.getText(),
                perfilComboBox.getValue()
        );

        if (!validator.isValid(usuario)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro de Validação");
            alert.setContentText("Campos inválidos:\n" + String.join("\n", validator.getErrors()));
            alert.showAndWait();
            return;
        }

        usuarioService.cadastrar(usuario);
        atualizarTabela();
        limparCampos();
    }

    private void limparCampos() {
        nomeCompletoField.clear();
        cpfField.clear();
        emailField.clear();
        cargoField.clear();
        loginField.clear();
        senhaField.clear();
        senhaConfirmField.clear();
        perfilComboBox.setValue(null);
    }

    private void CriarTabela() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colPerfil.setCellValueFactory(new PropertyValueFactory<>("perfil"));
    }

    private void atualizarTabela() {
        usuarioTable.getItems().setAll(usuarioService.listar());
    }
}

package praxisv;

import application.UsuarioService;
import domain.Perfil;
import domain.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;

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
    }

    private void CriarTabela() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
        colLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        colPerfil.setCellValueFactory(new PropertyValueFactory<>("perfil"));
    }

    @FXML
    protected void onCadastrarClick() {

        if(!senhaField.getText().equals(senhaConfirmField.getText())) {
            System.out.println("As senhas não coincidem!");
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

        usuarioService.cadastrar(usuario);

        usuarioTable.getItems().setAll(usuarioService.listar());


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

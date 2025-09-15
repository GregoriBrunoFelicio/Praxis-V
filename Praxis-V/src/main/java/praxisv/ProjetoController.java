package praxisv;

import application.ProjetoService;
import application.UsuarioService;
import domain.Projeto;
import domain.StatusProjeto;
import domain.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class ProjetoController {
    private final ProjetoService projetoService = new ProjetoService();
    private final UsuarioService usuarioService = new UsuarioService();

    @FXML
    private TextField nomeProjetoField;

    @FXML
    private TextArea descricaoField;

    @FXML
    private DatePicker dataInicioPicker;

    @FXML
    private DatePicker dataFimPicker;

    @FXML
    private ComboBox<StatusProjeto> statusComboBox;

    @FXML
    private ComboBox<Usuario> gerenteComboBox;

    @FXML
    private TableColumn<Projeto, Integer> colId;
    @FXML
    private TableColumn<Projeto, String> colNome;
    @FXML
    private TableColumn<Projeto, String> colDescricao;
    @FXML
    private TableColumn<Projeto, LocalDate> colDataInicio;
    @FXML
    private TableColumn<Projeto, LocalDate> colDataFim;
    @FXML
    private TableColumn<Projeto, StatusProjeto> colStatus;
    @FXML
    private TableColumn<Projeto, String> colGerente;
    @FXML
    private TableView<Projeto> projetoTable;

    @FXML
    public void initialize() {
        // Preenche ComboBox de status com enum
        statusComboBox.getItems().setAll(StatusProjeto.values());

        // Preenche ComboBox de gerente com todos usuários
        gerenteComboBox.getItems().setAll(usuarioService.listar());

        // Mostra apenas o nome no combo
        gerenteComboBox.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Usuario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNomeCompleto());
            }
        });
        gerenteComboBox.setButtonCell(new ListCell<>() {
            @Override
            protected void updateItem(Usuario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getNomeCompleto());
            }
        });

        criarTabela();
        atualizarTabela();
    }

    @FXML
    protected void onCadastrarProjetoClick() {
        if (nomeProjetoField.getText().isEmpty()
                || dataInicioPicker.getValue() == null
                || dataFimPicker.getValue() == null
                || statusComboBox.getValue() == null
                || gerenteComboBox.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Preencha todos os campos obrigatórios!");
            alert.showAndWait();
            return;
        }

        Projeto projeto = new Projeto(
                nomeProjetoField.getText(),
                descricaoField.getText(),
                dataInicioPicker.getValue(),
                dataFimPicker.getValue(),
                statusComboBox.getValue(),
                gerenteComboBox.getValue()
        );

        projetoService.cadastrar(projeto);
        atualizarTabela();
        limparCampos();
    }

    private void limparCampos() {
        nomeProjetoField.clear();
        descricaoField.clear();
        dataInicioPicker.setValue(null);
        dataFimPicker.setValue(null);
        statusComboBox.setValue(null);
        gerenteComboBox.setValue(null);
    }

    private void criarTabela() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colDataInicio.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
        colDataFim.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colGerente.setCellValueFactory(new PropertyValueFactory<>("gerenteNome"));
    }

    private void atualizarTabela() {
        projetoTable.getItems().setAll(projetoService.listar());
    }
}

package praxisv.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    @FXML
    private StackPane conteudoPrincipal;

    @FXML
    public void initialize() throws IOException {
        abrirInicio();
    }

    @FXML
    private void abrirInicio() throws IOException {
        Parent inicioView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/praxisv/pages/inicio-view.fxml")));
        conteudoPrincipal.getChildren().setAll(inicioView);
    }

    @FXML
    private void abrirUsuarios() throws IOException {
        Parent usuarioView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/praxisv/pages/usuario-view.fxml")));
        conteudoPrincipal.getChildren().setAll(usuarioView);
    }

    @FXML
    private void abrirProjetos() throws IOException {
        Parent projetoView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/praxisv/pages/projeto-view.fxml")));
        conteudoPrincipal.getChildren().setAll(projetoView);
    }
}

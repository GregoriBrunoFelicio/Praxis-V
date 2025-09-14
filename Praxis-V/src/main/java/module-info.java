module com.example.praxisv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.praxisv to javafx.fxml;
    exports com.example.praxisv;
}
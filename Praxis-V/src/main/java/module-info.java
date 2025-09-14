module com.example.praxisv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens praxisv to javafx.fxml;
    exports praxisv;
}
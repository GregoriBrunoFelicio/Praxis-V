module com.example.praxisv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens praxisv to javafx.fxml;
    exports praxisv;
}
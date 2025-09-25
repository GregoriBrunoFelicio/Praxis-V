module com.example.praxisv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens domain.entities to javafx.base;
    opens praxisv to javafx.fxml;
    exports praxisv;
    exports praxisv.controllers;
    opens praxisv.controllers to javafx.fxml;
}
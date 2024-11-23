module org.gutierrez.dice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens org.gutierrez.dice to javafx.fxml;
    exports org.gutierrez.dice;
}
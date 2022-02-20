module org.openjfx.javamessenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens org.openjfx.javamessenger to javafx.fxml;
    exports org.openjfx.javamessenger;
}

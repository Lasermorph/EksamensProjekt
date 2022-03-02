module org.openjfx.javamessenger {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.desktop;
    requires java.logging;

    opens org.openjfx.javamessenger to javafx.fxml;
    exports org.openjfx.javamessenger;
    requires com.fazecast.jSerialComm;
}

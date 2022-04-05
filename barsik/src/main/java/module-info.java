module mi.barsik {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires okhttp3;
    requires json.simple;

    opens mi.barsik to javafx.fxml;
    exports mi.barsik;
}
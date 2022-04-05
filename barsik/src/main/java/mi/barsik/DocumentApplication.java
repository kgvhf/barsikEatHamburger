package mi.barsik;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DocumentApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DocumentApplication.class.getResource("documents.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 501, 400);
        stage.setTitle("Hello, I am documents!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
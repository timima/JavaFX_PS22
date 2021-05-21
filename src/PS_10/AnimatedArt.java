package PS_10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AnimatedArt extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AnimatedArt.fxml"));
        Scene scene = new Scene(root, 800, 800);

        PerspectiveCamera camera = new PerspectiveCamera();
        scene.setCamera(camera);
        stage.setTitle("3-D shapes Animation");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
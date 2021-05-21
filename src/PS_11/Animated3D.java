package PS_11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.ParallelCamera;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Animated3D extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Animated3D.fxml"));
        Scene scene = new Scene(root, 800, 800);

        ParallelCamera camera = new ParallelCamera();

        scene.setCamera(camera);
        stage.setTitle("3-D Animation Shapes");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
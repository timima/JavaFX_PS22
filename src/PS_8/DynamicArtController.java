package PS_8;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.security.SecureRandom;


public class DynamicArtController {
    @FXML Pane pane;
    private SecureRandom random = new SecureRandom();
    private int n;
    private int[] dx;
    private int[] dy;
    public void initialize() {
        n = random.nextInt(50) + 10;
        dx = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            Ellipse ellipse = new Ellipse();
            ellipse.setCenterX(random.nextInt(500) + 201);
            ellipse.setCenterY(random.nextInt(300) + 201);
            ellipse.setRadiusX(random.nextInt(100));
            ellipse.setRadiusY(random.nextInt(100));
            ellipse.setFill(randomColor());
            ellipse.setStrokeWidth(random.nextInt(20));
            ellipse.setStroke(randomColor());
            pane.getChildren().add(ellipse);
            dx[i] = 1 + random.nextInt(5);
            dy[i] = 1 + random.nextInt(5);
        }
        Timeline timelineAnimation = new Timeline(
                new KeyFrame(Duration.millis(10), e -> moveCircles())
        );
        timelineAnimation.setCycleCount(Timeline.INDEFINITE);
        timelineAnimation.play();
    }

    private void moveCircles() {
        for (int i = 0; i < pane.getChildren().size(); i++) {
            Ellipse e = (Ellipse) pane.getChildren().get(i);
            e.setCenterX(e.getCenterX() + dx[i]);
            e.setCenterY(e.getCenterY() + dy[i]);
            if (e.getCenterX() + e.getRadiusX() > pane.getWidth() || e.getCenterX() - e.getRadiusX() < 0) dx[i] = -dx[i];
            if (e.getCenterY() + e.getRadiusY() > pane.getHeight() || e.getCenterY() - e.getRadiusY() < 0) dy[i] = -dy[i];
        }
    }
    private Color randomColor(){
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                (double) random.nextInt(101) / 100);
    }
}
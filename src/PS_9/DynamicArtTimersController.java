package PS_9;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.security.SecureRandom;


public class DynamicArtTimersController {
    @FXML Pane pane;

    private final SecureRandom random = new SecureRandom();
    private int[] a;
    private int[] b;

    @FXML
    public void initialize() {

        a = new int[30];
        b = new int[30];
        for (int i = 0; i < 30; i++) {

            Circle circle = new Circle();
            circle.setCenterX(random.nextInt(130)+200);
            circle.setCenterY(random.nextInt(130)+200);
            circle.setRadius(random.nextInt(80)+20);

            circle.setFill(pickRandomColor());
            circle.setStrokeWidth(random.nextInt(20));
            circle.setStroke(pickRandomColor());


            pane.getChildren().add(circle);
            a[i] = 1 + random.nextInt(5);
            b[i] = 1 + random.nextInt(5);



            Timeline timelineAnimation = new Timeline(
                    new KeyFrame(Duration.millis(250), e -> animateCircle())
            );
            timelineAnimation.setCycleCount(Timeline.INDEFINITE);
            timelineAnimation.play();
        }
    }

    void animateCircle() {
        for (int i=0;i<pane.getChildren().size();i++) {
            Circle c = (Circle) pane.getChildren().get(i);
            c.setCenterX(c.getCenterX() + a[i]);
            c.setCenterY(c.getCenterY() + b[i]);
            if (c.getCenterX() + c.getRadius() > pane.getWidth() || c.getCenterX() - c.getRadius() < 0) a[i] = -a[i];
            if (c.getCenterY() + c.getRadius() > pane.getHeight() || c.getCenterY() - c.getRadius() < 0) b[i] = -b[i];
        }
    }


    private Color pickRandomColor(){
        return Color.rgb(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256),
                (double) random.nextInt(101) / 100);
    }
}
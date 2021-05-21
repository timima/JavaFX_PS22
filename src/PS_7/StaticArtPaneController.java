package PS_7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class StaticArtPaneController {
    @FXML    private ToggleButton drowbtn;
    @FXML    private ToggleButton rubberbtn;
    @FXML    private ToggleButton linebtn;
    @FXML    private ToggleButton rectbtn;
    @FXML    private ToggleButton circlebtn;
    @FXML    private Label Borderclr;
    @FXML    private ColorPicker cpLine;
    @FXML    private ColorPicker cpFill;
    @FXML    private Slider slider;
    @FXML    private Button undo;
    @FXML    private Button clearButton;
    @FXML    private Pane paneField;

    double startX=0.0;
    double startY=0.0;

    public void initialize(){

        cpLine.setValue(Color.BLACK);

        paneField.setOnMousePressed(e->{
            if(drowbtn.isSelected()) {
                drowbtnPressed(e.getX(),e.getY(),slider.getValue());
            }
            else if(rubberbtn.isSelected()) {
                rubberbtnPressed(e.getX(),e.getY(),slider.getValue());
            }

            else if(linebtn.isSelected()) {
                startX=e.getX();
                startY=e.getY();

            }
            else if(rectbtn.isSelected()) {
                startX=e.getX();
                startY=e.getY();
            }
            else if(circlebtn.isSelected()) {
                startX=e.getX();
                startY=e.getY();

            }

        });

        paneField.setOnMouseDragged(e->{
            if(drowbtn.isSelected()) {
                drowbtnPressed(e.getX(),e.getY(),slider.getValue());
            }
            else if(rubberbtn.isSelected()){
                rubberbtnPressed(e.getX(),e.getY(),slider.getValue());

            }
        });

        paneField.setOnMouseReleased(e->{

            if(linebtn.isSelected()) {

                linebtnPressed(startX,startY,e.getX(),e.getY());
                startY=0.0;
                startX=0.0;

            }
            else if(rectbtn.isSelected()) {

                rectanglebtnPressed(e.getX(),e.getY(),startX,startY);
                startY=0.0;
                startX=0.0;

            }
            else if(circlebtn.isSelected()) {
                circlebtnPressed(e.getX(),e.getY(),startX,startY);
                startY=0.0;
                startX=0.0;
            }

        });

        undo.setOnAction(e->{
            int count = paneField.getChildren().size();

            if (count > 0) {
                paneField.getChildren().remove(count - 1);
            }

        });


        clearButton.setOnAction(e-> {
            int count = paneField.getChildren().size();
            if (count>0) {
                for (int i = 1; i <= count; i++) {
                    paneField.getChildren().remove(count-i);
                }
            }
        });
    }

    void drowbtnPressed(double x,double y,double r){
        Circle circle = new Circle(x,y,r,cpLine.getValue());
        paneField.getChildren().add(circle);
    }

    void rubberbtnPressed(double x,double y,double r){
        Circle circle = new Circle(x,y,r,Color.WHITE);
        paneField.getChildren().add(circle);
    }
    void linebtnPressed(double x1,double y1,double x2,double y2){
        Line line = new Line(x1,y1,x2,y2);
        line.setStroke(cpLine.getValue());
        line.setFill(cpFill.getValue());
        line.setStrokeWidth(slider.getValue());
        paneField.getChildren().add(line);
    }
    void rectanglebtnPressed(double x2,double y2,double x1,double y1){
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(Math.abs((x2 - x1)));
        rectangle.setHeight(Math.abs((y2 - y1)));
        if(x2 > x1) {
            rectangle.setX(x1);
        }
        else {
            rectangle.setX(x2);
        }

        if(y2 > y1) {
            rectangle.setY(y1);
        }
        else{
            rectangle.setY(y2);
        }

        rectangle.setStroke(cpLine.getValue());
        rectangle.setFill(cpFill.getValue());

        paneField.getChildren().add(rectangle);
    }
    void circlebtnPressed(double x2,double y2,double x1,double y1){

        Circle circle = new Circle();
        double r = (Math.abs(x2 - x1) + Math.abs(y1 - y2)) / 2;
        circle.setRadius(r);

        double cx = (x1+x2)/2;
        double cy = (y1+y2)/2;
        circle.setCenterX(cx);
        circle.setCenterY(cy);

        circle.setStroke(cpLine.getValue());
        circle.setFill(cpFill.getValue());

        paneField.getChildren().add(circle);

    }

    @FXML
    void undoButtonPressed(ActionEvent event) {

    }
}
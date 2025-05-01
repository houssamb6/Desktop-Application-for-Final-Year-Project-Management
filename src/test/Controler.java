package test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Controler {

    @FXML
    private Circle myCircle;
    private double x;
    private double y;
    @FXML
    void down(ActionEvent event) {
        System.out.println("Down");
        myCircle.setCenterY(y+=10);
    }

    @FXML
    void left(ActionEvent event) {
        System.out.println("Left");
        myCircle.setCenterX(x-=10);

    }

    @FXML
    void right(ActionEvent event) {
        System.out.println( "Right" );
        myCircle.setCenterX(x+=10);
    }

    @FXML
    void up(ActionEvent event) {
        System.out.println( "Up");
        myCircle.setCenterY(y-=10);

    }

}

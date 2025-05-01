import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ControlerLeftBar {

    @FXML
    private AnchorPane anc1;

    @FXML
    private AnchorPane anc2;

    @FXML
    private AnchorPane anc3;



    @FXML
    private Button buttonEtu;
    @FXML
    private Button buttonEnsei;
    @FXML
    private Button buttonEnca;
    @FXML
    private Button buttonTime;
    @FXML
    private Button buttonHome;
    @FXML
    private AnchorPane leftbar;
    

    @FXML
    void moveH(ActionEvent event) {
        anc1.setVisible(true);
        anc2.setVisible(false);
        anc3.setVisible(false);
    }
    @FXML
    void moveE(ActionEvent event) {
        anc2.setVisible(true);
        anc3.setVisible(false);
        anc1.setVisible(false);
    }
    @FXML
    void moveEnsei(ActionEvent event) {
        anc2.setVisible(false);
        anc3.setVisible(true);
        anc1.setVisible(false);
    }

}


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
    
    public class ControlerScene1 {
    
        private Stage stage;
        private Scene scene;
        private Parent root;
        @FXML
        private TextField username;
        @FXML
        private PasswordField password;
        @FXML
        private Label alert;    
       // @FXML
            @FXML
            void move(ActionEvent event) {
                try {
                    if(username.getText().isEmpty()&&password.getText().isEmpty()){
                        alert.setText("please enter your data");
                    }
                    root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    // Get the dimensions of the screen
                    Screen screen = Screen.getPrimary();
                    Rectangle2D bounds = screen.getVisualBounds();
        
                    // Calculate the center coordinates of the screen
                    double centerX = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) / 2;
                    double centerY = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) / 2;
        
                    // Set the primary stage position to the calculated center coordinates
                    stage.setX(centerX);
                    stage.setY(centerY);
                    stage.show();
               } catch (IOException e) {
                   e.printStackTrace();
                    //Handle the exception appropriately, e.g., show an error message.*/
                }
            }
        }
    
    
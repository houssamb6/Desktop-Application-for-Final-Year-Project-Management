import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
public class ControlerSoutenance {
    Soutenance soutenance;
    @FXML
    private TextField notee;
    @FXML
    private AnchorPane anc2;
    @FXML
    private Label note;
    @FXML
    private AnchorPane evalue;
    @FXML
    private Label msg;


    public float setDetails(Soutenance soutenance) {
        this.soutenance = soutenance;
        String noteText = notee.getText();
        if (!noteText.isEmpty()) {
            try {
                // Parse the note value as a float
                float note = Float.parseFloat(noteText);
                if(note >= 0 && note <=20){
                    this.soutenance.setNote(note);
                    return note;
                }
                return 0;
                // Set the note of the Soutenance object
            } catch (NumberFormatException e) {
                // If the note is not a valid float, return null
                return 0;
            }
        } else {
            // If the note field is empty, return null
            return 0;
        }
    }
    
    public void setnot(MouseEvent e) {
        float updatedSoutenance = setDetails(this.soutenance);
        Connection connect;
        PreparedStatement prepare;
        if (updatedSoutenance != 0) {
            // If the note is set successfully, update the message accordingly
            msg.getStyleClass().clear(); // Clear existing styles
            msg.getStyleClass().add("rka7"); // Add CSS class for success message
            msg.setText("Note set successfully: " + updatedSoutenance);
            System.out.println(updatedSoutenance);
            String sql;
            connect=database.connectDb();
            sql="update soutenance set note=? where id_soutenance=?";
            try{
                prepare=connect.prepareStatement(sql);
                prepare.setFloat(1, updatedSoutenance);
                prepare.setInt(2,soutenance.getId_soutenance());
                int rowsAffected=prepare.executeUpdate();
            }catch (Exception p){
                p.printStackTrace();    
            }
        } else {
            // If the note is not set successfully, update the message accordingly
            msg.getStyleClass().clear(); // Clear existing styles
            msg.getStyleClass().add("alert"); // Add CSS class for error message
            msg.setText("Invalid note");
        }
        
    }
    
}

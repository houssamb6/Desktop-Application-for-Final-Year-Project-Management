import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControlerEtudient implements  Initializable {

    @FXML
    private RadioButton HButton;
    @FXML
    private AnchorPane ancimagePFE;
    @FXML
    private AnchorPane ancimageJury;
    
    @FXML
    private RadioButton FButton;

    @FXML
    private TextField EtudientSearch;

    @FXML
    private AnchorPane anc1;

    @FXML
    private AnchorPane anc2;

    @FXML
    private AnchorPane anc3;
    
    @FXML
    private AnchorPane anc4;

    @FXML
    private AnchorPane anc5;
    
    @FXML
    private AnchorPane anc6;
    
    @FXML
    private AnchorPane anc7;

    @FXML
    private TableColumn<Etudiant, Date> anniversaireEtudient;

    @FXML
    private AnchorPane backgroundAnc;

    @FXML
    private Button buttomTimee;

    @FXML
    private Button buttonEnca;

    @FXML
    private Button buttonEnsei;

    @FXML
    private Button buttonEtu;

    @FXML
    private Button buttonHome;

    @FXML
    private Button button_ajouter;

    @FXML
    private Button button_clear;
    @FXML
    private Button buttonPFEe;

    @FXML
    private Button button_delete;
    @FXML
    private TableColumn<Etudiant, Integer> cinEtudient;

    @FXML
    private TableColumn<Etudiant, String> filièreEtudiant;
    @FXML
    private TableColumn<Etudiant,String> etudeEtudiant;

    @FXML
    private AnchorPane leftbar;
    @FXML
    private AnchorPane anc8;

    @FXML
    private TableColumn<Etudiant, String> nomEtudient;

    @FXML
    private TableColumn<Etudiant, Integer> phoneEtudient;

    @FXML
    private TableColumn<Etudiant, String> prenomEtudient;

    @FXML
    private ChoiceBox<String> setEtude;

    @FXML
    private DatePicker setanniversaire_label;

    @FXML
    private TextField setcin_label;

    @FXML
    private ChoiceBox<String> setfilière;

    @FXML
    private TextField setnom_label;

    @FXML
    private TextField setphone_label;

    @FXML
    private TextField setprenom_label;

    @FXML
    private TableColumn<Etudiant, Character> sexeEtudient;

    @FXML
    private TableView<Etudiant> tableViewEtudient;
    @FXML
    private Label msg;
    @FXML
    private Label msg1;
    

    @FXML
    void moveH(ActionEvent event) {
        anc1.setVisible(true);
        anc2.setVisible(false);
        anc3.setVisible(false);
        anc4.setVisible(false);
        anc5.setVisible(false);
        anc6.setVisible(false);
        anc7.setVisible(false);
        anc8.setVisible(false);
        backgroundAncPlan.setVisible(false);
        anc9.setVisible(false);
        addstat();
        iniPieChart1();
        iniPieChart();

    }
    
    @FXML
    void moveE(ActionEvent event) {
        anc2.setVisible(true);
        anc3.setVisible(false);
        anc1.setVisible(false);
        anc4.setVisible(false);
        anc5.setVisible(false);
        anc6.setVisible(false);
        anc7.setVisible(false);
        anc8.setVisible(false);
        backgroundAncPlan.setVisible(false);
        anc9.setVisible(false);
        searchEtudiant();
        clearEtudiant(event);
    }
    
    @FXML
    void moveEnsei(ActionEvent event) {
        anc2.setVisible(false);
        anc3.setVisible(true);
        anc1.setVisible(false);
        anc4.setVisible(false);
        anc5.setVisible(false);
        anc6.setVisible(false);
        anc7.setVisible(false);
        anc8.setVisible(false);
        searchEnseignant();
        backgroundAncPlan.setVisible(false);
        clearEnseignant(event);
        anc9.setVisible(false);



    }
    
    public void moveInvité(ActionEvent event){
        anc2.setVisible(false);
        anc3.setVisible(false);
        anc1.setVisible(false);
        anc4.setVisible(true);
        anc5.setVisible(false);
        anc6.setVisible(false);
        anc7.setVisible(false);
        anc8.setVisible(false);
        backgroundAncPlan.setVisible(false);
        anc9.setVisible(false);
        searchInvité();
        clearGuest(event);
    }

    public void movePFE(ActionEvent e)throws Exception{
        anc1.setVisible(false);
        anc2.setVisible(false);
        anc3.setVisible(false);
        anc4.setVisible(false);
        anc5.setVisible(true);
        anc6.setVisible(false);
        anc7.setVisible(false);      
        anc8.setVisible(false);
        backgroundAncPlan.setVisible(false);
        anc9.setVisible(false); 
        searchPFE();
        searchJury();
    }
    public void moveJury(ActionEvent event)throws Exception{
        anc6.setVisible(true);
        anc5.setVisible(false);
        setPresident.getItems().clear();
        setExaminateur.getItems().clear();
        setInvite.getItems().clear();
        setRapporeteur.getItems().clear();
        setPresident.getItems().addAll(EnseignantNomPrenomListData());
        setRapporeteur.getItems().addAll(EnseignantNomPrenomListData());
        setExaminateur.getItems().addAll(EnseignantNomPrenomListData());
        setInvite.getItems().addAll(EnseignantNomPrenomListDataInvite());
        clearFieldJury(event);

    }
    public void movePfe(ActionEvent event)throws Exception{
        anc5.setVisible(false);
        anc7.setVisible(true);
        setEtudiant1.getItems().clear();
        setEtudiant2.getItems().clear();
        setEncadreurPFE.getItems().clear();
        setEtudiant1.getItems().addAll(EtudiantNomPrenomListData());
        setEtudiant2.getItems().addAll(EtudiantNomPrenomListData());
        setEncadreurPFE.getItems().addAll(EnseignantNomPrenomListData());
        clearPFE(event);
    }
    public void movePfemouse(MouseEvent event)throws Exception{
        anc5.setVisible(false);
        anc7.setVisible(true);
        setEncadreurPFE.setValue(null);
        setProjet.setText(null);
        group.setSelected(false);
        indiv.setSelected(false);
        groupPane.setVisible(false);
        indivPane.setVisible(false);
        tableViewPFE.getSelectionModel().clearSelection();
        setEtudiant1.getItems().clear();
        setEtudiant2.getItems().clear();
        setEncadreurPFE.getItems().clear();
        setEtudiant1.getItems().addAll(EtudiantNomPrenomListData());
        setEtudiant2.getItems().addAll(EtudiantNomPrenomListData());
        setEncadreurPFE.getItems().addAll(EnseignantNomPrenomListData());
    }
    public void moveJurymouse(MouseEvent event)throws Exception{
        anc6.setVisible(true);
        anc5.setVisible(false);
        setPresident.getItems().clear();
        setExaminateur.getItems().clear();
        setInvite.getItems().clear();
        setRapporeteur.getItems().clear();
        setPresident.getItems().addAll(EnseignantNomPrenomListData());
        setRapporeteur.getItems().addAll(EnseignantNomPrenomListData());
        setExaminateur.getItems().addAll(EnseignantNomPrenomListData());
        setInvite.getItems().addAll(EnseignantNomPrenomListDataInvite());
        setPresident.setValue(null);
        setRapporeteur.setValue(null);
        setExaminateur.setValue(null);
        setInvite.setValue(null);
        tableViewJury.getSelectionModel().clearSelection();
    }
    
    public void moveSoutenance(ActionEvent event)throws Exception{
        anc1.setVisible(false);
        anc2.setVisible(false);
        anc3.setVisible(false);
        anc4.setVisible(false);
        anc5.setVisible(false);
        anc6.setVisible(false);
        anc7.setVisible(false);      
        anc8.setVisible(true);
        backgroundAncPlan.setVisible(false);
        anc9.setVisible(false);
    }



    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet resultat;
    
//Affichage dans le list etudiant:

    public ObservableList<Etudiant> EtudiantListData(){
        ObservableList<Etudiant> list = FXCollections.observableArrayList();
        String sql="SELECT * FROM Etudiant";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            Etudiant etu;
            
            while (resultat.next()){
                etu= new  Etudiant(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getDate("anniversaire")
                ,resultat.getString("gender")
                ,resultat.getInt("phone")
                ,resultat.getString("etude")
                ,resultat.getString("filière"));
                list.add(etu);
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
    
    private ObservableList<Etudiant> initEtudiant;
    
    public void insertionDansTable(){
        initEtudiant=EtudiantListData();
        cinEtudient.setCellValueFactory(new PropertyValueFactory<>("cin"));
        nomEtudient.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomEtudient.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        anniversaireEtudient.setCellValueFactory(new  PropertyValueFactory<>("dateOfBirth"));
        sexeEtudient.setCellValueFactory(new PropertyValueFactory<>("gender"));
        phoneEtudient.setCellValueFactory(new PropertyValueFactory<>("phone"));
        etudeEtudiant.setCellValueFactory(new PropertyValueFactory<>("etude"));
        filièreEtudiant.setCellValueFactory(new PropertyValueFactory<>("filière"));
        tableViewEtudient.setItems(initEtudiant);
    }
    
    public void insertionEtudiant() {
        // Retrieve text from JavaFX TextFields
        String nom = setnom_label.getText();
        String prenom = setprenom_label.getText();
        String etude = setEtude.getValue();
        String filiére = setfilière.getValue();
        String cinText = setcin_label.getText();
        String phoneText = setphone_label.getText();
        LocalDate dateOfBirth = setanniversaire_label.getValue();
        String gender="H";
    
        // Retrieve selected RadioButton
        if(FButton.isSelected()){
            gender = FButton.getText();
        }
        else if(HButton.isSelected()){
            gender = HButton.getText();
        }
    
        // Validate input
        if (!validateInput(nom, prenom, etude, filiére, cinText, phoneText, dateOfBirth, FButton, HButton)) {
            // If validation fails, show error message
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg.setText("");
            }));
            timeline.play();
            return;
        }
    
        // Proceed with insertion
        Connection connect = null;
        PreparedStatement prepare = null;
    
        try {
            connect = database.connectDb();
            String sql = "INSERT INTO etudiant (cin, nom, prenom, anniversaire, phone, gender, etude, filière) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            prepare = connect.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(cinText));
            prepare.setString(2, nom);
            prepare.setString(3, prenom);
            prepare.setDate(4, Date.valueOf(dateOfBirth));
            prepare.setInt(5, Integer.parseInt(phoneText));
            prepare.setString(6, gender);
            prepare.setString(7, etude);
            prepare.setString(8, filiére);
    
            int rowsAffected = prepare.executeUpdate();
            prepare.close();
    
            // Provide feedback based on insertion result
            if (rowsAffected > 0) {
                msg1.setText("Insertion successful");
                msg1.getStyleClass().add("rka7");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg1.setText("");
                }));
                timeline.play();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            msg.setText("CIN dupliqué");
            msg.getStyleClass().add("alert");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg.setText("");
            }));
            timeline.play();
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public boolean validateInput(String nom, String prenom, String etude, String filiére, String cinText, String phoneText, LocalDate dateOfBirth, RadioButton FButton, RadioButton HButton) {
        // Check if any of the fields are empty
        if (nom.isEmpty() || prenom.isEmpty() || etude == null || filiére == null || cinText.isEmpty() || phoneText.isEmpty() || dateOfBirth == null || FButton == null || HButton == null) {
            msg.setText("Fill all inputs");
            msg.getStyleClass().add("alert");
            return false;
        }
    
        // Convert cin and phone from text to int
        int cin, phone;
        try {
            cin = Integer.parseInt(cinText);
            
        } catch (NumberFormatException e) {
            // If cin or phone is not a valid number, return false
            msg.setText("Invalid cin");
            msg.getStyleClass().add("alert");
            return false;
        }
        try {
            phone = Integer.parseInt(phoneText);
            
        } catch (NumberFormatException e) {
            // If cin or phone is not a valid number, return false
            msg.setText("Invalid phone");
            msg.getStyleClass().add("alert");
            return false;
        }
    
        // Check if cin and phone are within the specified range
        if (!(cin >= 10000000 && cin <= 99999999)) {
            msg.setText("Invalid cin");
            msg.getStyleClass().add("alert");
            return false;
        }else if(!(phone >= 10000000 && phone <= 99999999)){
            msg.setText("Invalid phone");
            msg.getStyleClass().add("alert");
            return false;
        }
    
        // All checks passed, return true
        return true;
    }
    
    public void ajouterEtudiant(ActionEvent e){
        String nom = setnom_label.getText();
        String prenom = setprenom_label.getText();
        String etude = setEtude.getValue();
        String filiére = setfilière.getValue();
        String cinText = setcin_label.getText();
        String phoneText = setphone_label.getText();
        LocalDate dateOfBirth = setanniversaire_label.getValue();
        String gender="H";   
        // Retrieve selected RadioButton
        if(FButton.isSelected()){
            gender = FButton.getText();
        }
        else if(HButton.isSelected()){
            gender = HButton.getText();
        }
        this.insertionEtudiant();
        this.insertionDansTable();
        searchEtudiant();
        if(validateInput(nom, prenom, etude, filiére, cinText, phoneText, dateOfBirth, FButton, HButton)){
            clearEtudiant(e);
        }
    }

    //update Etudiant
    public void updatebdEtudiant(){
        ObservableList<Etudiant> listcin=EtudiantListData();
        boolean ok=false;
        String cinText;
        cinText=setcin_label.getText();
        int cin=Integer.parseInt(setcin_label.getText());
        for(Etudiant i:listcin){
            if((cin)==i.getCin()){
                ok=true;
                break;
            }
        }
        if(ok==true){
                String nom,prenom,etude,filiére,phoneText;
                String gender="H";
                int phone;
                Date dateOfBirth;
                nom=setnom_label.getText();
                prenom=setprenom_label.getText();
                phoneText=setphone_label.getText();
                LocalDate dateOfBirt = setanniversaire_label.getValue();
                phone=Integer.parseInt(setphone_label.getText());
                dateOfBirth = Date.valueOf(setanniversaire_label.getValue());
                etude=setEtude.getValue();
                filiére=setfilière.getValue();
                if(FButton.isSelected()){
                    gender=FButton.getText();
                }
                else if(HButton.isSelected()){
                    gender=HButton.getText();
                }
                connect=database.connectDb();
                if (!validateInput(nom, prenom, etude, filiére, cinText, phoneText, dateOfBirt, FButton, HButton)) {
                    // If validation fails, show error message
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                        msg.setText("");
                    }));
                    timeline.play();
                    return;
                }
                String sql="update etudiant set nom=? ,prenom=? ,anniversaire=? ,phone=? ,gender=? ,etude=? ,filière=? where cin=?";
                try{
                    prepare=connect.prepareStatement(sql);
                    prepare.setString(1,nom);
                    prepare.setString(2,prenom);
                    prepare.setDate(3,dateOfBirth );
                    prepare.setInt(4, phone);
                    prepare.setString(5, gender);
                    prepare.setString(6, etude);
                    prepare.setString(7, filiére);
                    prepare.setInt(8,cin );
                    int rowsAffected=prepare.executeUpdate();
                    if (rowsAffected > 0) {
                        msg1.setText("update successful");
                        msg1.getStyleClass().add("rka7");
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                            msg1.setText("");
                        }));
                        timeline.play();
                    }
                    prepare.close();
                }catch (Exception e){
                    e.printStackTrace();    
                }
            }else{
                msg.setText("CIN introuvable");
                msg.getStyleClass().add("alert");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg.setText("");
                }));
                timeline.play();
                return;
            }
        }
    
    public void updateEtudiant(ActionEvent e){
        this.updatebdEtudiant();
        this.insertionDansTable();
        searchEtudiant();
        String nom = setnom_label.getText();
        String prenom = setprenom_label.getText();
        String etude = setEtude.getValue();
        String filiére = setfilière.getValue();
        String cinText = setcin_label.getText();
        String phoneText = setphone_label.getText();
        LocalDate dateOfBirth = setanniversaire_label.getValue();
        String gender="H";   
        // Retrieve selected RadioButton
        if(FButton.isSelected()){
            gender = FButton.getText();
        }
        else if(HButton.isSelected()){
            gender = HButton.getText();
        }
        if(validateInput(nom, prenom, etude, filiére, cinText, phoneText, dateOfBirth, FButton, HButton)){
            clearEtudiant(e);
        }
    }        
    
    //delete Etudiant
    public void deletedbEtudiant(){
        int cin=Integer.parseInt(setcin_label.getText());
        ObservableList<Etudiant> listcin=EtudiantListData();
        boolean ok=false;
        for(Etudiant i:listcin){
            if((cin)==i.getCin()){
                ok=true;
                break;
            }
        }
        if(ok==true){
            connect=database.connectDb();
            String sql="delete from etudiant where cin=?";
            try{
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1, cin);
                int rowsAffected=prepare.executeUpdate();
                if (rowsAffected > 0) {
                    msg1.setText("Supression successful");
                    msg1.getStyleClass().add("rka7");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                        msg1.setText("");
                    }));
                    timeline.play();
                }
                prepare.close();
            }catch (Exception e){
                e.printStackTrace();    
                msg.setText("l'etudiant deja dans un PFE");
                msg.getStyleClass().add("alert");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg.setText("");
                }));
                timeline.play();
            }
        }else{
            msg.setText("CIN introuvable");
            msg.getStyleClass().add("alert");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg.setText("");
            }));
            timeline.play();
            return;
        }
}
    
    public void  deleteEtudiant(ActionEvent e){
        this.deletedbEtudiant();
        this.insertionDansTable();
        searchEtudiant();
        clearEtudiant(e);
    }
    
    //clear Etudiant
    public void  clearEtudiant(ActionEvent e){
        setcin_label.setText(null);
        setnom_label.setText(null);
        setprenom_label.setText(null);
        HButton.setSelected(false);
        FButton.setSelected(false);
        setphone_label.setText(null);
        setEtude.setValue(null);
        setfilière.setValue(null);
        setanniversaire_label.setValue(null);
        tableViewEtudient.getSelectionModel().clearSelection();
    }
    
    // //Search!!!!!
    public void searchEtudiant() {
        ObservableList<Etudiant> x = EtudiantListData();
        FilteredList<Etudiant> filteredData = new FilteredList<>(x, b -> true);
        EtudientSearch.textProperty().addListener((Observable, oldvalue, newValue) -> {
            filteredData.setPredicate(etudiant -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (etudiant.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (etudiant.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(etudiant.getCin()).contains(lowerCaseFilter)) {
                    return true;
                }else if(etudiant.getGender().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(etudiant.getEtude().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(etudiant.getFilière().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if(String.valueOf(etudiant.getPhone()).contains(lowerCaseFilter)){
                    return true;
                }
                else{
                    return false;
                }
            });
        });
        SortedList<Etudiant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewEtudient.comparatorProperty());
        tableViewEtudient.setItems(sortedData);
    }
    
    public void setsection(ActionEvent event){
        if(setEtude.getValue()=="Master"){
            setfilière.getItems().setAll("Recherche","Professionnel");
        }
        else{
            setfilière.getItems().setAll("Informatique","Electronique");
        }
    }
    //selection
    public void mouseClickeddd(MouseEvent e){
        Etudiant selectedItem = tableViewEtudient.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            setcin_label.setText(String.valueOf(selectedItem.getCin()));
            setnom_label.setText(selectedItem.getNom());
            setprenom_label.setText(selectedItem.getPrenom());
            
            if (selectedItem.getGender().equals("H")) {
                HButton.setSelected(true);
                FButton.setSelected(false);
            } else {
                FButton.setSelected(true);
                HButton.setSelected(false);
            }
            
            setphone_label.setText(String.valueOf(selectedItem.getPhone()));
             
            
            // Set value for ChoiceBoxes setEtude and setfilière
            setEtude.setValue(selectedItem.getEtude());
            setfilière.setValue(selectedItem.getFilière());
            setanniversaire_label.setValue(selectedItem.getDateOfBirth().toLocalDate());
        } else {
            System.out.println("no one selected");
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Affichage dans le list enseignant:
    @FXML
    private TableColumn<Enseignant, Integer> cinEnseignant;
    @FXML
    private TableColumn<Enseignant, String> nomEnseignant;
    @FXML
    private TableColumn<Enseignant, String> prenomEnseignant;
    @FXML
    private TableColumn<Enseignant,Integer> phoneEnseignant;
    @FXML
    private TableColumn<Enseignant,String> specialiteEnseignant;
    @FXML
    private TextField setcinEn;
    @FXML
    private TextField setnomEn;
    @FXML
    private TextField setprenomEn;
    @FXML
    private TextField setphoneEn;
    @FXML
    private TextField setspecialiteEn;
    @FXML
    private TextField searchFieldEnseignant;
    @FXML
    private TableView<Enseignant> tableViewEnseignant;
    @FXML
    private Label msg2;
    @FXML
    private Label msg3;
    
    public ObservableList<Enseignant> EnseignantListData(){
        ObservableList<Enseignant> listEnseignant = FXCollections.observableArrayList();
        String sql="SELECT * FROM enseignant";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            Enseignant Ensei;
            while (resultat.next()){
                Ensei= new  Enseignant(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getInt("phone")
                ,resultat.getString("specialite"));
                listEnseignant.add(Ensei);
            }
        }catch(Exception e){e.printStackTrace();}
        return listEnseignant;
    }
    
    private ObservableList<Enseignant> initEnseignants;
    
    public void insertionDansTableEnsei(){
   
        initEnseignants=EnseignantListData();
        cinEnseignant.setCellValueFactory(new PropertyValueFactory<>("cin"));
        nomEnseignant.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomEnseignant.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        phoneEnseignant.setCellValueFactory(new  PropertyValueFactory<>("phone"));
        specialiteEnseignant.setCellValueFactory(new PropertyValueFactory<>("specialite"));
        tableViewEnseignant.setItems(initEnseignants);
    }
    
    public boolean validateInputEnseignant(String nom, String prenom,String cinText, String phoneText,String specialte) {
        // Check if any of the fields are empty
        if (nom.isEmpty() || prenom.isEmpty() || cinText.isEmpty() || phoneText.isEmpty() ||specialte.isEmpty()) {
            msg2.setText("Fill all inputs");
            msg2.getStyleClass().add("alert");
            return false;
        }
        // Convert cin and phone from text to int
        int cin, phone;
        try {
            cin = Integer.parseInt(cinText);
            
        } catch (NumberFormatException e) {
            // If cin or phone is not a valid number, return false
            msg2.setText("Invalid cin");
            msg2.getStyleClass().add("alert");
            return false;
        }
        try {
            phone = Integer.parseInt(phoneText);
            
        } catch (NumberFormatException e) {
            // If cin or phone is not a valid number, return false
            msg2.setText("Invalid phone");
            msg2.getStyleClass().add("alert");
            return false;
        }
    
        // Check if cin and phone are within the specified range
        if (!(cin >= 10000000 && cin <= 99999999)) {
            msg2.setText("Invalid cin");
            msg2.getStyleClass().add("alert");
            return false;
        }else if(!(phone >= 10000000 && phone <= 99999999)){
            msg2.setText("Invalid phone");
            msg2.getStyleClass().add("alert");
            return false;
        }
        // All checks passed, return true
        return true;
    }
    //ajouter Enseignant
    public void insertionEnseignant()throws Exception{
        String nom,prenom,specialite,cinText,phoneText;
        cinText=setcinEn.getText();
        phoneText=setphoneEn.getText();
        nom=setnomEn.getText();
        prenom=setprenomEn.getText();
        specialite=setspecialiteEn.getText();
        // Enseignant x=new Enseignant(cin, nom, prenom, phone, specialite);
        if (!validateInputEnseignant( nom,  prenom, cinText,  phoneText, specialite)) {
            // If validation fails, show error message
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg2.setText("");
            }));
            timeline.play();
            return;
        }
        Connection connect = null;
        PreparedStatement prepare = null;
        try{
            connect=database.connectDb();
            String sql="insert into enseignant (cin,nom,prenom,phone,specialite) values (?,?,?,?,?)";
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(setcinEn.getText()));
            prepare.setString(2,nom);
            prepare.setString(3,prenom);
            prepare.setInt(4, Integer.parseInt(setphoneEn.getText()));
            prepare.setString(5, specialite);
            int rowsAffected=prepare.executeUpdate();
            prepare.close();
            if (rowsAffected > 0) {
                msg3.setText("Insertion successful");
                msg3.getStyleClass().add("rka7");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg3.setText("");
                }));
                timeline.play();
            }
            prepare.close();
        }catch (SQLException e){
            e.printStackTrace();
            msg2.setText("CIN dupliqué");
            msg2.getStyleClass().add("alert");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg2.setText("");
            }));
            timeline.play();  
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void ajouterEnseignant(ActionEvent e)throws Exception{
        String nom,prenom,specialite,cinText,phoneText;
        int cin;
        int phone;
        cinText=setcinEn.getText();
        phoneText=setphoneEn.getText();
        nom=setnomEn.getText();
        prenom=setprenomEn.getText();
        specialite=setspecialiteEn.getText();
        insertionEnseignant();
        insertionDansTableEnsei();
        searchEnseignant();
        if(validateInputEnseignant(nom, prenom, cinText, phoneText, specialite)){
            clearEnseignant(e);
        }
    }
    
    //update Enseignant
    public void updatebdEnseignant(){
        ObservableList<Enseignant> listcin=EnseignantListData();
        boolean ok=false;
        int cin=Integer.parseInt(setcinEn.getText());
        for(Enseignant i:listcin){
            if((cin)==i.getCin()){
                ok=true;
                break;
            }
        }
        if(ok==true){
                String nom,prenom,specialite,cinText,phoneText;
                nom=setnomEn.getText();
                prenom=setprenomEn.getText();
                cinText=setcinEn.getText();
                phoneText=setphoneEn.getText();
                specialite=setspecialiteEn.getText();
                if (!validateInputEnseignant( nom,  prenom, cinText,  phoneText, specialite)) {
                    // If validation fails, show error message
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                        msg2.setText("");
                    }));
                    timeline.play();
                    return;
                }
                Connection connect = null;
                PreparedStatement prepare = null;
                try{
                    connect=database.connectDb();
                    String sql="update enseignant set nom=? ,prenom=? ,phone=?,specialite=? where cin=?";
                    prepare=connect.prepareStatement(sql);
                    prepare.setString(1,nom);
                    prepare.setString(2,prenom);
                    prepare.setInt(3, Integer.parseInt(setphoneEn.getText()));
                    prepare.setString(4, specialite);
                    prepare.setInt(5,cin );
                    int rowsAffected=prepare.executeUpdate();
                    if (rowsAffected > 0) {
                        msg3.setText("update successful");
                        msg3.getStyleClass().add("rka7");
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                            msg3.setText("");
                        }));
                        timeline.play();
                    }
                    prepare.close();
                    
                }catch (Exception e){
                    e.printStackTrace();    
                }
            }else{
                msg2.setText("CIN introuvable");
                msg2.getStyleClass().add("alert");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg2.setText("");
                }));
                timeline.play();
                return;
            }
        }
    
    public void updateEnseignant(ActionEvent e){
        String nom,prenom,specialite,cinText,phoneText;
        int cin;
        int phone;
        cinText=setcinEn.getText();
        phoneText=setphoneEn.getText();
        nom=setnomEn.getText();
        prenom=setprenomEn.getText();
        specialite=setspecialiteEn.getText();
        this.updatebdEnseignant();
        this.insertionDansTableEnsei();
        searchEnseignant();
        if(validateInputEnseignant(nom, prenom, cinText, phoneText, specialite)){
            clearEnseignant(e);
        }
    }   
    
    //delete Enseignant
    public void deletedbEnseignant(){
        int cin=Integer.parseInt(setcinEn.getText());
        ObservableList<Enseignant> listcin=EnseignantListData();
        boolean ok=false;
        for(Enseignant i:listcin){
            if((cin)==i.getCin()){
                ok=true;
                break;
            }
        }
        if(ok==true){
            connect=database.connectDb();
            String sql="delete from enseignant where cin=?";
            try{
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1, cin);
                int rowsAffected=prepare.executeUpdate();
                if (rowsAffected > 0) {
                    msg3.setText("Supression successful");
                    msg3.getStyleClass().add("rka7");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                        msg3.setText("");
                    }));
                    timeline.play();
                }
                prepare.close();
            }catch (Exception e){
                e.printStackTrace();
                msg2.setText("l'enseignant deja dans un jury");
                msg2.getStyleClass().add("alert");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg2.setText("");
                }));
                timeline.play();    
            }
        }else{
            msg3.setText("CIN introuvable");
            msg3.getStyleClass().add("alert");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg3.setText("");
            }));
            timeline.play();
            return;
        }
    }
    
    public void deleteEnseignant(ActionEvent e){
        deletedbEnseignant();
        insertionDansTableEnsei();
        searchEnseignant();
        clearEnseignant(e);
    }
    
    //clear Enseignant
    public  void clearEnseignant(ActionEvent e){
        setcinEn.setText(null);
        setnomEn.setText(null);
        setprenomEn.setText(null);
        setphoneEn.setText(null);
        setspecialiteEn.setText(null);
        tableViewEnseignant.getSelectionModel().clearSelection();
    }

    //search
    public void searchEnseignant() {
        ObservableList<Enseignant> x = EnseignantListData();
        FilteredList<Enseignant> filteredData = new FilteredList<>(x, b -> true);
        searchFieldEnseignant.textProperty().addListener((Observable, oldvalue, newValue) -> {
            filteredData.setPredicate(enseignant -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (enseignant.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (enseignant.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(enseignant.getCin()).contains(lowerCaseFilter)) {
                    return true;
                }else if(enseignant.getSpecialite().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<Enseignant> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewEnseignant.comparatorProperty());
        tableViewEnseignant.setItems(sortedData);
    }
    

    //mouse selction
    public void mouseClickedddEnsei(MouseEvent e){
        Enseignant selectedItem = tableViewEnseignant.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            setcinEn.setText(String.valueOf(selectedItem.getCin()));
            setnomEn.setText(selectedItem.getNom());
            setprenomEn.setText(selectedItem.getPrenom());
            setphoneEn.setText(String.valueOf(selectedItem.getPhone()));
            setspecialiteEn.setText(selectedItem.getSpecialite());
        } else {
            System.out.println("no one selected");
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Affichage dans le list Invité:   
    @FXML
    private TableView<Encadreur> tableViewInvité;
    @FXML
    private TableColumn<Encadreur, Integer> cinInvité;
    @FXML
    private TableColumn<Encadreur, String> nomInvité;
    @FXML
    private TableColumn<Encadreur, String> prenomInvité;
    @FXML
    private TableColumn<Encadreur, Integer> phoneInvité;
    @FXML
    private TableColumn<Encadreur, String> societeInvite;
    @FXML
    private TextField setcinInvite;
    @FXML
    private TextField setnomInvite;
    @FXML
    private TextField setphoneInvite;
    @FXML
    private TextField setprenomInvite;
    @FXML
    private TextField setsocieteInvite;
    @FXML
    private TextField searchFieldInvite;
    @FXML
    private Label msg4;
    @FXML
    private Label msg5;
    
    public ObservableList<Encadreur> EncadreurListData(){
        ObservableList<Encadreur> listEncadreurs = FXCollections.observableArrayList();
        String sql="SELECT * FROM societe_invité ";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            Encadreur Enca;
            while (resultat.next()){
                Enca= new  Encadreur(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getInt("phone")
                ,resultat.getString("societe"));
                listEncadreurs.add(Enca);
            }
        }catch(Exception e){e.printStackTrace();}
        return listEncadreurs;
    }
    
    private ObservableList<Encadreur> initEncadreurs;
    
    public void insertionDansTableEnca(){
        initEncadreurs=EncadreurListData();
        cinInvité.setCellValueFactory(new PropertyValueFactory<>("cin"));
        nomInvité.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomInvité.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        phoneInvité.setCellValueFactory(new  PropertyValueFactory<>("phone"));
        societeInvite.setCellValueFactory(new PropertyValueFactory<>("societe"));
        tableViewInvité.setItems(initEncadreurs);
    }
    
    public boolean validateInputInvité(String nom, String prenom,String cinText, String phoneText,String societe) {
        // Check if any of the fields are empty
        if (nom.isEmpty() || prenom.isEmpty() || cinText.isEmpty() || phoneText.isEmpty() ||societe.isEmpty()) {
            msg4.setText("Fill all inputs");
            msg4.getStyleClass().add("alert");
            return false;
        }
        // Convert cin and phone from text to int
        int cin, phone;
        try {
            cin = Integer.parseInt(cinText);
            
        } catch (NumberFormatException e) {
            // If cin or phone is not a valid number, return false
            msg4.setText("Invalid cin");
            msg4.getStyleClass().add("alert");
            return false;
        }
        try {
            phone = Integer.parseInt(phoneText);
            
        } catch (NumberFormatException e) {
            // If cin or phone is not a valid number, return false
            msg4.setText("Invalid phone");
            msg4.getStyleClass().add("alert");
            return false;
        }
    
        // Check if cin and phone are within the specified range
        if (!(cin >= 10000000 && cin <= 99999999)) {
            msg4.setText("Invalid cin");
            msg4.getStyleClass().add("alert");
            return false;
        }else if(!(phone >= 10000000 && phone <= 99999999)){
            msg4.setText("Invalid phone");
            msg4.getStyleClass().add("alert");
            return false;
        }
        // All checks passed, return true
        return true;
    }
    //ajouter Invité
    public void insertionInvité()throws Exception{
        String nom,prenom,societe,cinText,phoneText;
        nom=setnomInvite.getText();
        prenom=setprenomInvite.getText();
        cinText=setcinInvite.getText();
        phoneText=setphoneInvite.getText();
        societe=setsocieteInvite.getText();
        if (!validateInputEnseignant( nom,  prenom, cinText,  phoneText, societe)) {
            // If validation fails, show error message
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg4.setText("");
            }));
            timeline.play();
            return;
        }
        Connection connect = null;
        PreparedStatement prepare = null;
        try{
            connect=database.connectDb();
            String sql="insert into societe_invité (cin,nom,prenom,phone,societe) values (?,?,?,?,?)";
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(setcinInvite.getText()));
            prepare.setString(2,nom);
            prepare.setString(3,prenom);
            prepare.setInt(4, Integer.parseInt(setphoneInvite.getText()));
            prepare.setString(5, societe);
            int rowsAffected=prepare.executeUpdate();
            if (rowsAffected > 0) {
                msg5.setText("Insertion successful");
                msg5.getStyleClass().add("rka7");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg5.setText("");
                }));
                timeline.play();
            }
            prepare.close();
        }catch (SQLException e){
            e.printStackTrace();
            msg4.setText("CIN dupliqué");
            msg4.getStyleClass().add("alert");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg4.setText("");
            }));
            timeline.play();  
        } finally {
            try {
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void ajouterGuest(ActionEvent e)throws Exception{
        String nom,prenom,societe,cinText,phoneText;
        nom=setnomInvite.getText();
        prenom=setprenomInvite.getText();
        cinText=setcinInvite.getText();
        phoneText=setphoneInvite.getText();
        societe=setsocieteInvite.getText();
        insertionInvité();
        insertionDansTableEnca();
        searchInvité();
        if(validateInputEnseignant( nom,  prenom, cinText,  phoneText, societe)){
            clearGuest(e);
        }
    } 
    
    //update Invité
    public void updatebdInvite(){
        ObservableList<Encadreur> listcin=EncadreurListData();
        boolean ok=false;
        int cin=Integer.parseInt(setcinInvite.getText());
        for(Encadreur i:listcin){
            if((cin)==i.getCin()){
                ok=true;
                break;
            }
        }
        if(ok==true){
                String nom,prenom,societe,cinText,phoneText;
                nom=setnomInvite.getText();
                prenom=setprenomInvite.getText();
                phoneText=setphoneInvite.getText();
                societe=setsocieteInvite.getText();
                cinText=setcinInvite.getText();
                if (!validateInputEnseignant( nom,  prenom, cinText,  phoneText, societe)) {
                    // If validation fails, show error message
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                        msg4.setText("");
                    }));
                    timeline.play();
                    return;
                }
                try{
                    connect=database.connectDb();
                    String sql="update societe_invité set nom=? ,prenom=? ,phone=?,societe=? where cin=?";
                    prepare=connect.prepareStatement(sql);
                    prepare.setString(1,nom);
                    prepare.setString(2,prenom);
                    prepare.setInt(3, Integer.parseInt(setphoneInvite.getText()));
                    prepare.setString(4, societe);
                    prepare.setInt(5,cin );
                    int rowsAffected=prepare.executeUpdate();
                    if (rowsAffected > 0) {
                        msg5.setText("update successful");
                        msg5.getStyleClass().add("rka7");
                        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                            msg5.setText("");
                        }));
                        timeline.play();
                    }
                    prepare.close();
                    
                }catch (Exception e){
                    e.printStackTrace();    
                }
            }else{
                msg4.setText("CIN introuvable");
                msg4.getStyleClass().add("alert");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    msg4.setText("");
                }));
                timeline.play();
                return;
            }
        }
    
    public void updateGuest(ActionEvent e){
        String nom,prenom,societe,cinText,phoneText;
        nom=setnomInvite.getText();
        prenom=setprenomInvite.getText();
        cinText=setcinInvite.getText();
        phoneText=setphoneInvite.getText();
        societe=setsocieteInvite.getText();
        this.updatebdInvite();
        this.insertionDansTableEnca();
        searchInvité();
        if(validateInputEnseignant( nom,  prenom, cinText,  phoneText, societe)){
            clearGuest(e);
        }
    } 
    
    //delete Invité
    public void deletedbInvite(){
        int cin=Integer.parseInt(setcinInvite.getText());
        ObservableList<Encadreur> listcin=EncadreurListData();
        boolean ok=false;
        for(Encadreur i:listcin){
            if((cin)==i.getCin()){
                ok=true;
                break;
            }
        }
        if(ok==true){
            
            connect=database.connectDb();
            String sql="delete from societe_invité where cin=?";
            try{
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1, cin);
                int rowsAffected=prepare.executeUpdate();
                if (rowsAffected > 0) {
                    msg5.setText("Supression successful");
                    msg5.getStyleClass().add("rka7");
                    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                        msg5.setText("");
                    }));
                    timeline.play();
                }
                prepare.close();
            }catch (Exception e){
                e.printStackTrace();    
            }
        }else{
            msg4.setText("CIN introuvable");
            msg4.getStyleClass().add("alert");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                msg4.setText("");
            }));
            timeline.play();
            return;
        }
    }
    
    public void deleteGuest(ActionEvent e){
        deletedbInvite();
        insertionDansTableEnca();
        searchInvité();
        clearGuest(e);
    }
    
    //clear Invité
    public  void clearGuest(ActionEvent e){
        setcinInvite.setText(null);
        setnomInvite.setText(null);
        setprenomInvite.setText(null);
        setphoneInvite.setText(null);
        setsocieteInvite.setText(null);
        tableViewInvité.getSelectionModel().clearSelection();
    }
    
    //mouse Selection
    public void mouseClickedddInvite(MouseEvent e){
        Encadreur selectedItem = tableViewInvité.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            setcinInvite.setText(String.valueOf(selectedItem.getCin()));
            setnomInvite.setText(selectedItem.getNom());
            setprenomInvite.setText(selectedItem.getPrenom());
            setphoneInvite.setText(String.valueOf(selectedItem.getPhone()));
            setsocieteInvite.setText(selectedItem.getSociete());
        } else {
            System.out.println("no one selected");
        }
    }
    
    //search Invité
    public void searchInvité() {
        ObservableList<Encadreur> x = EncadreurListData();
        FilteredList<Encadreur> filteredData = new FilteredList<>(x, b -> true);
        searchFieldInvite.textProperty().addListener((Observable, oldvalue, newValue) -> {
            filteredData.setPredicate(invite -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (invite.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (invite.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(invite.getCin()).contains(lowerCaseFilter)) {
                    return true;
                }else if(invite.getSociete().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<Encadreur> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewInvité.comparatorProperty());
        tableViewInvité.setItems(sortedData);
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Affichage dans le list Jury:      
    @FXML
    private TableColumn<Jury, Integer> id_Jury;
    @FXML
    private TableColumn<Jury, String> id_president;
    @FXML
    private TableColumn<Jury, String> id_Rapporteur;
    @FXML
    private TableColumn<Jury, String> id_Examinateur;
    @FXML
    private TableColumn<Jury, String> id_invité;
    @FXML
    private TableColumn<Jury, Button> details;
    @FXML
    private TableView<Jury> tableViewJury;
    @FXML
    private ComboBox<String>  setPresident;
    @FXML
    private ComboBox<String>  setRapporeteur;
    @FXML
    private ComboBox<String>  setExaminateur;
    @FXML
    private ComboBox<String>  setInvite;
    @FXML
    private TextField searchFieldJury;
    
    public Enseignant chercherPres(int cin){
        String sql;
        Enseignant Ensei=null;
        sql="select cin,nom,prenom,phone,specialite from enseignant inner join jury on enseignant.cin=jury.id_president where enseignant.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                Ensei= new  Enseignant(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getInt("phone")
                ,resultat.getString("specialite"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Ensei;
    }
    public Enseignant chercherRapp(int cin){
        String sql;
        Enseignant Ensei=null;
        sql="select cin,nom,prenom,phone,specialite from enseignant inner join jury on enseignant.cin=jury.id_rapporteur where enseignant.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                Ensei= new  Enseignant(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getInt("phone")
                ,resultat.getString("specialite"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Ensei;
    }
    public Enseignant chercherExa(int cin){
        String sql;
        Enseignant Ensei=null;
        sql="select cin,nom,prenom,phone,specialite from enseignant inner join jury on enseignant.cin=jury.id_examinateur where enseignant.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                Ensei= new  Enseignant(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getInt("phone")
                ,resultat.getString("specialite"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Ensei;
    }    
    // public Enseignant chercherEnca(int cin){
    //     String sql;
    //     Enseignant Ensei=null;
    //     sql="select cin,nom,prenom,phone,specialite from enseignant inner join jury on enseignant.cin=jury.id_encadreur where enseignant.cin = ? ";
    //     connect=database.connectDb();
    //     try{
    //         prepare=connect.prepareStatement(sql);
    //         prepare.setInt(1, cin);
    //         resultat=prepare.executeQuery();
    //         while (resultat.next()){
    //             Ensei= new  Enseignant(
    //             resultat.getInt("cin")
    //             ,resultat.getString("nom")
    //             ,resultat.getString("prenom")
    //             ,resultat.getInt("phone")
    //             ,resultat.getString("specialite"));
    //         }
    //     }catch(Exception e){e.printStackTrace();}
    //     return Ensei;
    // }    
    public Encadreur chercherinvité(int cin){
        String sql;
        Encadreur Ensei=null;
        sql="select cin,nom,prenom,phone,societe from societe_invité inner join jury on societe_invité.cin=jury.id_invité where societe_invité.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                Ensei= new  Encadreur(
                resultat.getInt("cin")
                ,resultat.getString("nom")
                ,resultat.getString("prenom")
                ,resultat.getInt("phone")
                ,resultat.getString("societe"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Ensei;
    }

    public ObservableList<Jury> JuryListData(){
        ObservableList<Jury> listJury = FXCollections.observableArrayList();
        ResultSet resultatseb;
        String sql="SELECT * FROM jury";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultatseb=prepare.executeQuery();
            while (resultatseb.next()){
                Jury jury= new  Jury(resultatseb.getInt("id_jury")
                ,chercherPres(resultatseb.getInt("id_president"))
                ,chercherRapp(resultatseb.getInt("id_rapporteur"))
                ,chercherExa(resultatseb.getInt("id_examinateur"))
                // ,chercherEnca(resultatseb.getInt("id_encadreur"))
                ,chercherinvité(resultatseb.getInt("id_invité"))
                );
                listJury.add(jury);
            }
        }catch(Exception e){e.printStackTrace();}
        return listJury;
    }
    
    private ObservableList<Jury> initJury;
    
    public void insertionDansTableJury(){
        initJury = JuryListData();
        id_Jury.setCellValueFactory(new PropertyValueFactory<>("idJury"));
        id_president.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPresident().getNom()+" "+cellData.getValue().getPresident().getPrenom()));
        id_Rapporteur.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRapporteur().getNom()+" "+cellData.getValue().getRapporteur().getPrenom()));
        id_Examinateur.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getExaminateur().getNom()+" "+cellData.getValue().getExaminateur().getPrenom()));
        // id_Encadreure.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEncadreur().getNom()+" "+cellData.getValue().getEncadreur().getPrenom()));
        id_invité.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInvite().getNom()+" "+cellData.getValue().getInvite().getPrenom()));
        details.setCellFactory(param-> new TableCell<>() {           
                    final Button editButton = new Button("affiche");
                    {
                        editButton.setOnAction(event -> {
                            Jury jury = getTableView().getItems().get(getIndex());
                            // Handle edit action here
                            System.out.println("Edit clicked for: " + jury);
                        });
                    }

                    @Override
                    protected void updateItem(Button item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(editButton);
                        }
                    }
        });
        tableViewJury.setItems(initJury);
    }
    
    //ajouter Jury
    public ObservableList<String> EnseignantNomPrenomListData(){
        ObservableList<String> listnomPrenomEnseignant = FXCollections.observableArrayList();
        String sql="SELECT cin,nom,prenom FROM enseignant";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                String cin=String.valueOf(resultat.getInt("cin"));
                String nom=resultat.getString("nom");
                String prenom=resultat.getString("prenom");
                String formule=cin+" "+nom+" "+prenom;
                listnomPrenomEnseignant.add(formule);
            }
        }catch(Exception e){e.printStackTrace();};
        return  listnomPrenomEnseignant;
    } 
    
    public ObservableList<String> EnseignantNomPrenomListDataInvite(){
        ObservableList<String> listNomPrenomInvite = FXCollections.observableArrayList();
        String sql="SELECT cin,nom,prenom FROM societe_invité";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                String cin=String.valueOf(resultat.getInt("cin"));
                String nom=resultat.getString("nom");
                String prenom=resultat.getString("prenom");
                String formule=cin+" "+nom+" "+prenom;

                listNomPrenomInvite.add(formule);
            }
        }catch(Exception e){e.printStackTrace();};
        return  listNomPrenomInvite;
    } 
    
    public void setComboPres() {
        ObservableList<String> x = EnseignantNomPrenomListData();
        FilteredList<String> filteredData = new FilteredList<>(x, b -> true);
    
        setPresident.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(enseignant -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(enseignant.toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<String> sortedData = new SortedList<>(filteredData);
        sortedData.setComparator(String.CASE_INSENSITIVE_ORDER); // Set the comparator
        setPresident.setItems(sortedData);
    }
    
    public void insertionJury()throws Exception{
        String president=setPresident.getValue();
        String rapporteur=setRapporeteur.getValue();
        String examinateur=setExaminateur.getValue();
        String invite=setInvite.getValue();
        int spaceIndexPre = president.indexOf(' '); 
        int spaceIndexRapp = rapporteur.indexOf(' '); 
        int spaceIndexExa = examinateur.indexOf(' '); 
        int spaceIndexInv = invite.indexOf(' '); 
        connect=database.connectDb();
        String sql="insert into jury (id_president,id_rapporteur,id_examinateur,id_invité) values (?,?,?,?)";
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, Integer.parseInt(president.substring(0, spaceIndexPre)));
            prepare.setInt(2, Integer.parseInt(rapporteur.substring(0, spaceIndexRapp)));
            prepare.setInt(3,Integer.parseInt(examinateur.substring(0, spaceIndexExa)));
            prepare.setInt(4, Integer.parseInt(invite.substring(0, spaceIndexInv)));
            int rowsAffected=prepare.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if(rowsAffected > 0) {
                alert.setTitle("information");
                alert.setContentText("insertion succeful");
            }else{
                alert.setTitle("information");
                alert.setContentText("insertion failed");
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();    
        }
    }
    
    public void ajouterJury(ActionEvent actionEvent)throws Exception{
        insertionJury();
        insertionDansTableJury();
        searchJury();
        clearFieldJury(actionEvent);

    }
    
    //update Jury
    public void updatebdJury(){
        ObservableList<Encadreur> listcin=EncadreurListData();
        Jury selectedItem = tableViewJury.getSelectionModel().getSelectedItem();
        String president=setPresident.getValue();
        String rapporteur=setRapporeteur.getValue();
        String examinateur=setExaminateur.getValue();
        String invite=setInvite.getValue();
        int spaceIndexPre = president.indexOf(' '); 
        int spaceIndexRapp = rapporteur.indexOf(' '); 
        int spaceIndexExa = examinateur.indexOf(' '); 
        int spaceIndexInv = invite.indexOf(' '); 
                String sql="update jury set id_president=?,id_rapporteur=?,id_examinateur=?,id_invité=? where id_jury=?";
                try{
                    prepare=connect.prepareStatement(sql);
                    prepare.setInt(1,Integer.parseInt(president.substring(0, spaceIndexPre)));
                    prepare.setInt(2,Integer.parseInt(rapporteur.substring(0, spaceIndexRapp)));
                    prepare.setInt(3, Integer.parseInt(examinateur.substring(0, spaceIndexExa)));
                    prepare.setInt(4,Integer.parseInt(invite.substring(0, spaceIndexInv)) );
                    prepare.setInt(5,selectedItem.getIdJury() );
                    int rowsAffected=prepare.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    if(rowsAffected > 0) {
                        alert.setTitle("information");
                        alert.setContentText("insertion succeful");
                    }else{
                        alert.setTitle("information");
                        alert.setContentText("insertion failed");
                    }
                    prepare.close();
                }catch (Exception e){
                    e.printStackTrace();    
                }
            }

    public void updateJury(ActionEvent event) throws Exception {
        this.updatebdJury();
        this.insertionDansTableJury();
        searchJury();
        clearFieldJury(event);

    }
    //mouse Selection
    public void mouseClickedddJury(MouseEvent e)throws Exception{
        Jury selectedItem = tableViewJury.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Enseignant president=selectedItem.getPresident();
            Enseignant rapporteur=selectedItem.getRapporteur();
            Enseignant examinateur=selectedItem.getExaminateur();
            Encadreur invite=selectedItem.getInvite();
            setPresident.setValue(String.valueOf(president.getCin()+" "+president.getNom()+" "+president.getPrenom()));
            setRapporeteur.setValue(String.valueOf(rapporteur.getCin()+" "+rapporteur.getNom()+" "+rapporteur.getPrenom()));
            setExaminateur.setValue(String.valueOf(examinateur.getCin()+" "+examinateur.getNom()+" "+examinateur.getPrenom()));
            setInvite.setValue(String.valueOf(invite.getCin()+" "+invite.getNom()+" "+invite.getPrenom()));
        } else {
            System.out.println("no one selected");
        }
    }
    
    //clear Jury
    public void clearFieldJury(ActionEvent e) throws Exception{
        setPresident.setValue(null);
        setRapporeteur.setValue(null);
        setExaminateur.setValue(null);
        setInvite.setValue(null);
        tableViewJury.getSelectionModel().clearSelection();
    }

    //delete Jury 
    public void deletedbJury(){
        Jury selectedItem = tableViewJury.getSelectionModel().getSelectedItem();
            connect=database.connectDb();
            String sql="delete from jury where id_jury=?";
            try{
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1,selectedItem.getIdJury());
                int rowsAffected=prepare.executeUpdate();
                // Alert alert = new Alert(Alert.AlertType.INFORMATION);
                // if(rowsAffected > 0) {
                //     alert.setTitle("information");
                //     alert.setContentText("insertion succeful");
                // }else{
                //     alert.setTitle("information");
                //     alert.setContentText("insertion failed");
                // }
                prepare.close();
            }catch (Exception e){
                e.printStackTrace();    
            }
        }

    public void deleteJury(ActionEvent e)throws Exception{
        this.deletedbJury();
        this.insertionDansTableJury();
        searchJury();
        clearFieldJury(e);
    }    
    
    //Search
    public void searchJury() {
        ObservableList<Jury> x = JuryListData();
        FilteredList<Jury> filteredData = new FilteredList<>(x, b -> true);
        searchFieldJury.textProperty().addListener((Observable, oldvalue, newValue) -> {
            filteredData.setPredicate(Jury -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if ((String.valueOf(Jury.getIdJury())+" ").toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if ((String.valueOf(Jury.getPresident().getCin())+" "+Jury.getPresident().getNom()+" "+Jury.getPresident().getPrenom()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if ((String.valueOf(Jury.getRapporteur().getCin())+" "+Jury.getRapporteur().getNom()+" "+Jury.getRapporteur().getPrenom()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if((String.valueOf(Jury.getExaminateur().getCin())+" "+Jury.getExaminateur().getNom()+" "+Jury.getExaminateur().getPrenom()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if((String.valueOf(Jury.getInvite().getCin())+" "+Jury.getInvite().getNom()+" "+Jury.getInvite().getPrenom()).toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<Jury> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewJury.comparatorProperty());
        tableViewJury.setItems(sortedData);
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Affichage dans le list PFE:    
    @FXML
    private RadioButton group;
    @FXML
    private RadioButton indiv;
    @FXML
    private Label Etudiant1;
    @FXML
    private Label Etudiant2;
    @FXML
    private ComboBox<String> setEtudiant1;
    @FXML
    private ComboBox<String> setEtudiant2;
    @FXML
    private AnchorPane groupPane;
    @FXML
    private AnchorPane indivPane;
    @FXML
    private TableColumn<PFE, Integer> PFE;
    @FXML
    private TableColumn<PFE, String> id_Etudiants;
    @FXML
    private TableColumn<PFE, String> id_EncadreurPFE;
    @FXML
    private TableColumn<PFE, String> Projet;
    @FXML
    private TableColumn<PFE, String> detailsPFE;
    @FXML
    private TableView<PFE> tableViewPFE;
    @FXML
    private ComboBox<String>  setEncadreurPFE;
    @FXML
    private TextField  setProjet;
    @FXML
    private TextField  searchPFE;

    
    public void afficheGroup(ActionEvent e)throws Exception{
        if(group.isSelected()){
            groupPane.setVisible(true);
            indivPane.setVisible(true);
        }
    }
    
    public void afficheindiv(ActionEvent e)throws Exception{
        if(indiv.isSelected()){
            indivPane.setVisible(true);
            groupPane.setVisible(false);
        }
    }

    public Etudiant rechercheEtudiant1(int cin){
        String sql;
        Etudiant Etud=null;
        ResultSet resultatt;
        sql="select * from etudiant inner join groupe on etudiant.cin=groupe.id_etudiant1 where etudiant.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultatt=prepare.executeQuery();
            while (resultatt.next()){
                Etud= new  Etudiant(
                    resultatt.getInt("cin")
                    ,resultatt.getString("nom")
                    ,resultatt.getString("prenom")
                    ,resultatt.getDate("anniversaire")
                    ,resultatt.getString("gender")
                    ,resultatt.getInt("phone")
                    ,resultatt.getString("etude")
                    ,resultatt.getString("filière"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Etud;
    }
    public Etudiant rechercheEtudiant2(int cin){
        String sql;
        Etudiant Etud=null;
        ResultSet resultSet;
        sql="select * from etudiant inner join groupe on etudiant.cin=groupe.id_etudiant2 where etudiant.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultSet=prepare.executeQuery();
            while (resultSet.next()){
                Etud= new  Etudiant(
                    resultSet.getInt("cin")
                    ,resultSet.getString("nom")
                    ,resultSet.getString("prenom")
                    ,resultSet.getDate("anniversaire")
                    ,resultSet.getString("gender")
                    ,resultSet.getInt("phone")
                    ,resultSet.getString("etude")
                    ,resultSet.getString("filière"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Etud;
    }
    public Enseignant chercherEncaPfe(int cin){
        String sql;
        Enseignant Ensei=null;
        ResultSet resultSet;
        sql="select * from  enseignant inner join groupe on enseignant.cin=groupe.id_encadreur where enseignant.cin = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, cin);
            resultSet=prepare.executeQuery();
            while (resultSet.next()){
                Ensei= new  Enseignant(
                resultSet.getInt("cin")
                ,resultSet.getString("nom")
                ,resultSet.getString("prenom")
                ,resultSet.getInt("phone")
                ,resultSet.getString("specialite"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Ensei;
    }
    
    public ObservableList<PFE> PFEListData(){
        ObservableList<PFE> listPFE = FXCollections.observableArrayList();
        ResultSet resultaPFE;
        String sql="SELECT * FROM groupe";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultaPFE=prepare.executeQuery();
            while (resultaPFE.next()){
                PFE pfe= new  PFE(resultaPFE.getInt("idgroup")
                ,rechercheEtudiant1(resultaPFE.getInt("id_etudiant1"))
                ,rechercheEtudiant2(resultaPFE.getInt("id_etudiant2"))
                ,chercherEncaPfe(resultaPFE.getInt("id_encadreur"))
                ,resultaPFE.getString("projet")
                );
                listPFE.add(pfe);
            }
        }catch(Exception e){e.printStackTrace();}
        return listPFE;
    }
    
    private ObservableList<PFE> initPFE;

    public void insertionDansTablePFE() {
    initPFE = PFEListData();
    PFE.setCellValueFactory(new PropertyValueFactory<>("idGroupe"));
    id_Etudiants.setCellValueFactory(cellData -> {
        SimpleStringProperty property = new SimpleStringProperty();
        Etudiant etudiant1 = cellData.getValue().getEtudiant1();
        Etudiant etudiant2 = cellData.getValue().getEtudiant2();
        if (etudiant2 == null) {
            property.setValue(etudiant1.getNom()+" "+etudiant1.getPrenom());
        } else {
            property.setValue(etudiant1.getNom()+" "+etudiant1.getPrenom()+" ET "+etudiant2.getNom() + " " + etudiant2.getPrenom());
        }
        return property;
    });    id_EncadreurPFE.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEncadreur().getNom() + " " + cellData.getValue().getEncadreur().getPrenom()));
    Projet.setCellValueFactory(new PropertyValueFactory<>("projet"));
    detailsPFE.setCellFactory(param -> new TableCell<>() {
    final Button editButton = new Button("affiche");
    
        {
            // Check if the button creation code is executed            
            editButton.setOnAction(event -> {
                PFE pfe = getTableView().getItems().get(getIndex());
                // Handle edit action here
                System.out.println("Edit clicked for: " + pfe);
            });
        }
    
        // Set the button as the graphic for the cell
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(editButton);
            }
        }
    });
    tableViewPFE.setItems(initPFE);
}
    //ajouter group
    public ObservableList<String> EtudiantNomPrenomListData(){
        ObservableList<String> listnomPrenomEtudiant = FXCollections.observableArrayList();
        ObservableList<PFE> filteredList=PFEListData();
        String etudiant1=null;
        String etudiant2=null;
        int spaceIndexETud1=0;
        int spaceIndexETud2=0;
        String sql="SELECT cin,nom,prenom FROM etudiant";
        boolean check;
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while (resultat.next()){
                check=true;
                String cin=String.valueOf(resultat.getInt("cin"));
                String nom=resultat.getString("nom");
                String prenom=resultat.getString("prenom");
                String formule=cin+" "+nom+" "+prenom;
                if(group.isSelected()){
                    etudiant1=setEtudiant1.getValue();
                    etudiant2=setEtudiant2.getValue();  
                    spaceIndexETud1 = etudiant1.indexOf(' ');
                    spaceIndexETud2 = etudiant2.indexOf(' ');
                }
                for(PFE i:filteredList){
                    if(i.getEtudiant2()==null){
                        if(i.getEtudiant1().getCin()==Integer.parseInt(cin)){
                            check=false;
                            break;
                        }
                    }else{
                        if(i.getEtudiant1().getCin()==Integer.parseInt(cin)||i.getEtudiant2().getCin()==Integer.parseInt(cin)){
                            check=false;
                            break;
                        }
                    }
                }
                if(check==true){
                    listnomPrenomEtudiant.add(formule);
                }
            }
        }catch(Exception e){e.printStackTrace();};
        return  listnomPrenomEtudiant;
    } 
    
    public void insertionPFE()throws Exception{
        String encadreur=setEncadreurPFE.getValue();
        String projet=setProjet.getText();
        String etudiant1=setEtudiant1.getValue();
        String etudiant2=null;
        int spaceIndexEtu2=0;
        if(group.isSelected()){
            etudiant2=setEtudiant2.getValue();
            spaceIndexEtu2 = etudiant2.indexOf(' '); 
        }
        int spaceIndexEnc = encadreur.indexOf(' '); 
        int spaceIndexEtu1 = etudiant1.indexOf(' '); 
        connect=database.connectDb();
        String sql;
        try{
            if(group.isSelected()){
                sql="insert into groupe (id_etudiant1,id_etudiant2,id_encadreur,projet) values (?,?,?,?)";
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1, Integer.parseInt(etudiant1.substring(0, spaceIndexEtu1)));
                prepare.setInt(2, Integer.parseInt(etudiant2.substring(0, spaceIndexEtu2)));
                prepare.setInt(3,Integer.parseInt(encadreur.substring(0, spaceIndexEnc)));
                prepare.setString(4,projet);
            }
            else{
                sql="insert into groupe (id_etudiant1,id_encadreur,projet) values (?,?,?)";
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1, Integer.parseInt(etudiant1.substring(0, spaceIndexEtu1)));
                prepare.setInt(2,Integer.parseInt(encadreur.substring(0, spaceIndexEnc)));
                prepare.setString(3,projet);
            }
            int rowsAffected=prepare.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if(rowsAffected > 0) {
                alert.setTitle("information");
                alert.setContentText("insertion succeful");
            }else{
                alert.setTitle("information");
                alert.setContentText("insertion failed");
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();    
        }
    }

    public void ajouterPFE(ActionEvent actionEvent)throws Exception{
        insertionPFE();
        insertionDansTablePFE();
        clearPFE(actionEvent);
        searchPFE();
        setEtudiant1.getItems().clear();
        setEtudiant1.getItems().addAll(EtudiantNomPrenomListData());
        setEtudiant2.getItems().clear();
        setEtudiant2.getItems().addAll(EtudiantNomPrenomListData());
    }
    
    //mouse selection
    public void mouseClickedddPFE(MouseEvent e)throws Exception{
        PFE selectedItem = tableViewPFE.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            setProjet.setText(selectedItem.getProjet());
            setEncadreurPFE.setValue(selectedItem.getEncadreur().getCin()+" "+selectedItem.getEncadreur().getNom() +" "+selectedItem.getEncadreur().getPrenom());
        } else {
            System.out.println("no one selected");
        }
    }
    
    //update group
    public void updatebdPFE(){
        PFE selectedItem = tableViewPFE.getSelectionModel().getSelectedItem();
        String encadreur=setEncadreurPFE.getValue();
        String projet=setProjet.getText();
        int spaceIndexEtu2=0;
        int spaceIndexEnc = encadreur.indexOf(' '); 
        connect=database.connectDb();
        String sql;
        sql="update groupe set id_encadreur=?,projet=? where idgroup=?";
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1,Integer.parseInt(encadreur.substring(0, spaceIndexEnc)));
            prepare.setString(2,projet);
            prepare.setInt(3,selectedItem.getIdGroupe()); 
            int rowsAffected=prepare.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();    
        }
        }

    public void updatePFE(ActionEvent event) throws Exception {
        this.updatebdPFE();
        this.insertionDansTablePFE();
        clearPFE(event);
        searchPFE();
        setEtudiant1.getItems().clear();
        setEtudiant1.getItems().addAll(EtudiantNomPrenomListData());
        setEtudiant2.getItems().clear();
        setEtudiant2.getItems().addAll(EtudiantNomPrenomListData());
    }

    // delete group
    public void deletedbPFE(){
        PFE selectedItem = tableViewPFE.getSelectionModel().getSelectedItem();
            connect=database.connectDb();
            String sql="delete from groupe where idgroup=?";
            try{
                prepare=connect.prepareStatement(sql);
                prepare.setInt(1,selectedItem.getIdGroupe());
                int rowsAffected=prepare.executeUpdate();
                // Alert alert = new Alert(Alert.AlertType.INFORMATION);
                // if(rowsAffected > 0) {
                //     alert.setTitle("information");
                //     alert.setContentText("insertion succeful");
                // }else{
                //     alert.setTitle("information");
                //     alert.setContentText("insertion failed");
                // }
                prepare.close();
            }catch (Exception e){
                e.printStackTrace();    
            }
        }//initialisation!!!!
    
    public void deletePFE(ActionEvent e)throws Exception {
        this.deletedbPFE();
        this.insertionDansTablePFE();
        clearPFE(e);
        searchPFE();
        setEtudiant1.getItems().clear();
        setEtudiant1.getItems().addAll(EtudiantNomPrenomListData());
        setEtudiant2.getItems().clear();
        setEtudiant2.getItems().addAll(EtudiantNomPrenomListData());
    }
    
    //clear group
    public void clearPFE(ActionEvent actionEvent)  throws Exception{
        setEncadreurPFE.setValue(null);
        setProjet.setText(null);
        group.setSelected(false);
        indiv.setSelected(false);
        groupPane.setVisible(false);
        indivPane.setVisible(false);
        setEtudiant1.setValue(null);
        setEtudiant2.setValue(null);
        tableViewPFE.getSelectionModel().clearSelection();
    }

    //search PFE
    public void searchPFE(){
        ObservableList<PFE> x = PFEListData();
        FilteredList<PFE> filteredData = new FilteredList<>(x, b -> true);
        searchPFE.textProperty().addListener((Observable, oldvalue, newValue) -> {
            filteredData.setPredicate(PFE -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if ((String.valueOf(PFE.getIdGroupe())+" ").toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if ((PFE.getEncadreur().getNom()+" "+PFE.getEncadreur().getPrenom()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if ((PFE.getEtudiant1().getNom()+" "+PFE.getEtudiant1().getPrenom()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if(PFE.getProjet().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }else if (PFE.getEtudiant2()!=null) {
                        if((PFE.getEtudiant2().getNom()+" "+PFE.getEtudiant2().getPrenom()).toLowerCase().contains(lowerCaseFilter)){
                        return true;
                        }
                        else{
                            return false;
                        }
                }else{
                    return false;
                }
            });
        });
        SortedList<PFE> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableViewPFE.comparatorProperty());
        tableViewPFE.setItems(sortedData);
    }
    
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//gestion de soutenance:
    @FXML
    private ComboBox<String> soutenancePFE;
    @FXML
    private ComboBox<String> soutenanceJury;
    @FXML
    private DatePicker soutenanceDate;
    @FXML
    private ComboBox<String> soutenanceheure;
    @FXML
    private ComboBox<String>  soutenanceSalle;
    @FXML
    private AnchorPane backgroundAncPlan;
    @FXML
    private AnchorPane ancimagePlanification;
    @FXML
    private AnchorPane ancimagevaluation;
    @FXML
    private Label alert;
    @FXML
    private TableColumn<Soutenance,String> EtudaintsSoutenance;
    @FXML
    private TableColumn<Soutenance,String> titreDePFE;
    @FXML
    private TableColumn<Soutenance,Date> DateSoutenance;
    @FXML
    private TableColumn<Soutenance,Time> heureSoutenance;
    @FXML
    private TableColumn<Soutenance,String> salleSoutenancePFE;
    @FXML
    private TableColumn<Soutenance,Float> notePFE;
    @FXML
    private TableColumn<Soutenance,String> evaluer;
    @FXML
    private TableView<Soutenance> tableViewSoutenance;
    @FXML
    private AnchorPane anc9;

    public PFE chercherPFE(int idPFE){
        String sql;
        PFE pfe=null;
        ResultSet resultSet;
        sql="select * from groupe inner join soutenance on groupe.idgroup=soutenance.id_group where groupe.idgroup = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, idPFE);
            resultSet=prepare.executeQuery();
            while (resultSet.next()){
                pfe= new  PFE(
                resultSet.getInt("idgroup")
                ,rechercheEtudiant1(resultSet.getInt("id_etudiant1"))
                ,rechercheEtudiant2(resultSet.getInt("id_etudiant2"))
                ,chercherEncaPfe(resultSet.getInt("id_encadreur"))
                ,resultSet.getString("projet"));
            }
        }catch(Exception e){e.printStackTrace();}
        return pfe;
    }
    
    public Jury chercherJury(int idJury){
        String sql;
        Jury jury=null;
        ResultSet resultSet;
        sql="select * from jury inner join soutenance on jury.id_jury=soutenance.id_jury where jury.id_jury = ? ";
        connect=database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            prepare.setInt(1, idJury);
            resultSet=prepare.executeQuery();
            while (resultSet.next()){
                jury= new  Jury(
                resultSet.getInt("id_jury")
                ,chercherPres(resultSet.getInt("id_president"))
                ,chercherRapp(resultSet.getInt("id_rapporteur"))
                ,chercherExa(resultSet.getInt("id_examinateur"))
                ,chercherinvité(resultSet.getInt("id_invité")));
            }
        }catch(Exception e){e.printStackTrace();}
        return jury;
    }

    public ObservableList<Soutenance> soutenanceListData(){
        ObservableList<Soutenance> listSoutenance = FXCollections.observableArrayList();
        ResultSet resultaPFE;
        String sql="SELECT * FROM soutenance";
        connect = database.connectDb();
        try{
            prepare=connect.prepareStatement(sql);
            resultaPFE=prepare.executeQuery();
            while (resultaPFE.next()){
                Soutenance soutenance= new  Soutenance(resultaPFE.getInt("id_soutenance")
                ,chercherPFE(resultaPFE.getInt("id_group"))
                ,chercherJury(resultaPFE.getInt("id_jury"))
                ,resultaPFE.getDate("datee")
                ,resultaPFE.getTime("temps")
                ,resultaPFE.getString("lieu")
                ,resultaPFE.getFloat("note")
                );
                listSoutenance.add(soutenance);
            }
        }catch(Exception e){e.printStackTrace();}
        return listSoutenance;
    }

    public String idSoutenance(Soutenance s){
        String id=s.getDateSoutenance()+","+s.getHDebut()+","+s.getPlace();
        return id;
    }

    public boolean verfierSoutenance(String i){
        ObservableList<Soutenance> lsout=soutenanceListData();
        for(Soutenance j:lsout){
            if(idSoutenance(j).equals(i)){
                return false;
            }
        }
        return true;
    }

    public void moveAjout(MouseEvent e)throws Exception{
        backgroundAncPlan.setVisible(true);
        buttonHome.setDisable(true);
        buttonEtu.setDisable(true);
        buttonEnsei.setDisable(true);
        buttonEnca.setDisable(true);
        buttonPFEe.setDisable(true);
        buttomTimee.setDisable(true);
        ancimagePlanification.setDisable(true);
        ancimagevaluation.setDisable(true);
        clearSoutenance();        
        soutenancePFE.getItems().clear();
        soutenancePFE.getItems().addAll(PFENomPrenomListData());
    }
    
    public void moveAjoutt(ActionEvent e)throws Exception{
        backgroundAncPlan.setVisible(true);
        buttonHome.setDisable(true);
        buttonEtu.setDisable(true);
        buttonEnsei.setDisable(true);
        buttonEnca.setDisable(true);
        buttonPFEe.setDisable(true);
        buttomTimee.setDisable(true);
        ancimagePlanification.setDisable(true);
        ancimagevaluation.setDisable(true);
        clearSoutenance();
        soutenancePFE.getItems().clear();
        soutenancePFE.getItems().addAll(PFENomPrenomListData());
    }
    
    public void removeAjout(MouseEvent e)throws Exception {
        backgroundAncPlan.setVisible(false);
        buttonHome.setDisable(false);
        buttonEtu.setDisable(false);
        buttonEnsei.setDisable(false);
        buttonEnca.setDisable(false);
        buttonPFEe.setDisable(false);
        buttomTimee.setDisable(false);
        ancimagePlanification.setDisable(false);
        ancimagevaluation.setDisable(false);
    }

    private ObservableList<Soutenance> initSoutenances;
    
    public ObservableList<String> PFENomPrenomListData(){
        ObservableList<String> listnomPrenomEtudiant = FXCollections.observableArrayList();
        ObservableList<Soutenance> filteredListSoutenances=soutenanceListData();
        String sql="SELECT idgroup,id_etudiant1,id_etudiant2,projet FROM groupe";
        boolean check;
        connect = database.connectDb();
        ResultSet resultSet;
        try{
            prepare=connect.prepareStatement(sql);
            resultSet=prepare.executeQuery();
            while (resultSet.next()){
                check=true;
                Etudiant Etudiant1=rechercheEtudiant1(resultSet.getInt("id_etudiant1"));
                Etudiant Etudiant2=rechercheEtudiant2(resultSet.getInt("id_etudiant2"));
                int  idGroup=resultSet.getInt("idgroup");
                String nomPrenom=Etudiant1.getNom()+" "+Etudiant1.getPrenom();
                if(Etudiant2!=null){
                    nomPrenom+=" et "+Etudiant2.getNom()+" "+ Etudiant2.getPrenom();
                }
                String  projet=resultSet.getString("projet");
                String formule=idGroup+" :"+projet+" by "+nomPrenom;
                for(Soutenance i:filteredListSoutenances){
                    if(i.getPfe().getIdGroupe()==idGroup){
                        check=false;
                        break;
                    }
                }
                if(check==true){
                    listnomPrenomEtudiant.add(formule);
                }
            }
        }catch(Exception e){e.printStackTrace();};
        return  listnomPrenomEtudiant;
    } 
    
    public ObservableList<String> JuryNomPrenomListData(){
        ObservableList<String> listnomPrenomEtudiant = FXCollections.observableArrayList();
        ObservableList<Soutenance> filteredListSoutenances=soutenanceListData();
        String sql="SELECT id_jury,id_president,id_examinateur FROM jury";
        boolean check;
        connect = database.connectDb();
        ResultSet resultSet;
        try{
            prepare=connect.prepareStatement(sql);
            resultSet=prepare.executeQuery();
            while (resultSet.next()){
                check=true;
                Enseignant president=chercherPres(resultSet.getInt("id_president"));
                Enseignant examinateur=chercherExa(resultSet.getInt("id_examinateur"));
                String nomPrenom=president.getNom()+" "+president.getPrenom();
                String nomPrenomExa=examinateur.getNom()+" "+examinateur.getPrenom();
                int idjury=resultSet.getInt("id_jury");
                String formule=String.valueOf(idjury)+" :"+"-President:"+nomPrenom+"\n-Examinateur:"+nomPrenomExa;
                // for(Soutenance i:filteredListSoutenances){
                //     if(i.getJury().getIdJury()==idjury){
                //         check=false;
                //         break;
                //     }
                // }
                if(check==true){
                    listnomPrenomEtudiant.add(formule);
                }
            }
        }catch(Exception e){e.printStackTrace();};
        return  listnomPrenomEtudiant;
    } 
    
    public void afficherhDebut(){
        ObservableList<String> timeOptions = FXCollections.observableArrayList();
        LocalTime currentTime = LocalTime.of(8, 0); // Start from 8:00 AM
        LocalTime endTime = LocalTime.of(17, 0); // End at 4:00 PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        while (currentTime.isBefore(endTime) || currentTime.equals(endTime)) {
            timeOptions.add(currentTime.format(formatter));
            currentTime = currentTime.plusHours(1).plusMinutes(30); // Increment by 1 hour and 30 minutes
        }
        soutenanceheure.setItems(timeOptions);
    }
    public void insertionSoutenance()throws Exception{
        ObservableList<Soutenance> listSoutenance=soutenanceListData();
        String PFE=soutenancePFE.getValue();
        String Jury=soutenanceJury.getValue();
        Date date = Date.valueOf(soutenanceDate.getValue());
        System.out.println(date);
        Time hdebut=Time.valueOf(soutenanceheure.getValue() + ":00");
        System.out.println(hdebut);
        String salle=soutenanceSalle.getValue();
        int spaceIndexPFE = PFE.indexOf(' '); 
        int spaceIndexJury = Jury.indexOf(' '); 
        String formule=date+","+hdebut+","+salle;
        connect=database.connectDb();
        String sql;
        if(verfierSoutenance(formule)==true){
                sql="insert into soutenance (id_group,id_jury,datee,temps,lieu) values (?,?,?,?,?)";
                try{
                        prepare=connect.prepareStatement(sql);
                        prepare.setInt(1, Integer.parseInt(PFE.substring(0, spaceIndexPFE)));
                        prepare.setInt(2, Integer.parseInt(Jury.substring(0, spaceIndexJury)));
                        prepare.setDate(3,date);
                        prepare.setTime(4,hdebut);
                        prepare.setString(5,salle);
                    int rowsAffected=prepare.executeUpdate();
                    prepare.close();
                }catch (Exception r){
                    r.printStackTrace();    
                }
                alert.getStyleClass().remove("alert");
                alert.getStyleClass().add("rka7");
                alert.setText("Insertion réussie");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    alert.setText("");
                }));
                timeline.play();
                clearSoutenance();
                soutenancePFE.getItems().clear();
                soutenancePFE.getItems().addAll(PFENomPrenomListData());
            }else{
                LocalTime localTime = hdebut.toLocalTime();
                LocalTime localTimeApresIncrement = localTime.plusHours(1).plusMinutes(30);
                Time heureApresIncrement = Time.valueOf(localTimeApresIncrement);
                alert.getStyleClass().remove("rka7");
                alert.setText("Salle réservée jusqu'à"+heureApresIncrement);
                alert.getStyleClass().add("alert");
                Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
                    alert.setText("");
                }));
                timeline.play();
            }
    }
    public void ajouterSoutenance(ActionEvent e)throws Exception{
        insertionSoutenance();
        insertionDansTableSoutenance();
    }
    //clear Soutenance
    public void clearSoutenance(){
        soutenancePFE.setValue(null);
        soutenanceJury.setValue(null);
        soutenanceDate.setValue(null);
        soutenanceheure.setValue(null);
        soutenanceSalle.setValue(null);
    }
    public void insertionDansTableSoutenance(){
        initSoutenances = soutenanceListData();
        EtudaintsSoutenance.setCellValueFactory(cellData -> {
            SimpleStringProperty property = new SimpleStringProperty();
            Etudiant etudiant1 = cellData.getValue().getPfe().getEtudiant1();
            Etudiant etudiant2 = cellData.getValue().getPfe().getEtudiant2();
            if (etudiant2 == null) {
                property.setValue(etudiant1.getNom()+" "+etudiant1.getPrenom());
            } else {
                property.setValue(etudiant1.getNom()+" "+etudiant1.getPrenom()+" ET "+etudiant2.getNom() + " " + etudiant2.getPrenom());
            }
            return property;
        });    
        titreDePFE.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPfe().getProjet()));
        DateSoutenance.setCellValueFactory(new PropertyValueFactory<>("dateSoutenance"));
        heureSoutenance.setCellValueFactory(new PropertyValueFactory<>("hDebut"));
        salleSoutenancePFE.setCellValueFactory(new PropertyValueFactory<>("place"));
        notePFE.setCellValueFactory(new PropertyValueFactory<>("note"));
        evaluer.setCellFactory(param -> new TableCell<>() {
            Button editButton = new Button();
            
            // Initialize the edit button and set its action
            {
                editButton.setOnAction(event -> {
                    Soutenance soutenance = getTableView().getItems().get(getIndex());
                    try {
                        move(soutenance);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                // Check if the cell is empty or not associated with a TableView
                if (empty || getTableView() == null) {
                    setGraphic(null);
                } else {
                    setGraphic(editButton);
                }
            }
        });        
        tableViewSoutenance.setItems(initSoutenances);
    }
    public void moveEvaluation(ActionEvent e){
        anc9.setVisible(true);
    }
    public void moveEvaluation2(MouseEvent e){
        anc9.setVisible(true);
    }
    


    public void move(Soutenance x) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Soutena.fxml"));
        Parent root = loader.load();
        
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        
        ControlerSoutenance controller = loader.getController();
        controller.setDetails(x);
        
        stage.setTitle("titre");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        
        // Set event handler to refresh when the stage is closed
        stage.setOnHidden(event -> refresh());
        
        stage.showAndWait();
    }
    
    public void refresh() {
        insertionDansTableSoutenance();
    }
    //dashboard-------------------------------------------------------------------------------------------------------------------------------------------------------------
    @FXML
    private Label label11;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    public void addstat(){
        int countEtud=0;
        int countPFE=0;
        int countEnse=0;
        connect=database.connectDb();
        String sql="select count(*) from etudiant";
        String sql1="select count(*) from enseignant";
        String sql2="select count(*) from soutenance";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                countEtud=resultat.getInt(1);
            }
            prepare=connect.prepareStatement(sql1);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                countEnse=resultat.getInt(1);
            }
            prepare=connect.prepareStatement(sql2);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                countPFE=resultat.getInt(1);
            }
            prepare.close();
            label11.setText(String.valueOf(countEtud));
            label2.setText(String.valueOf(countEnse));
            label3.setText(String.valueOf(countPFE));
        }catch (Exception r){
            r.printStackTrace();    
        }
    }
    @FXML
    private PieChart pieChart;
    @FXML
    private PieChart pieChart1;
    @FXML 
    private BarChart barChart;
    private int countIndiv(){
        int countindiv=0;
        connect=database.connectDb();
        String sql="select count(*) from groupe where id_etudiant2 is null";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                countindiv=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return countindiv;
    }
    private int countGroupe(){
        int countgroupe=0;
        connect=database.connectDb();
        String sql="select count(*) from groupe where id_etudiant2 is not null";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                countgroupe=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return countgroupe;
    }
    private int countpassable(){
        int count=0;
        connect=database.connectDb();
        String sql="select count(*) from soutenance where note >= 10 and note <12";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                count=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return count;
    }
    private int countassezbien(){
        int count=0;
        connect=database.connectDb();
        String sql="select count(*) from soutenance where note >= 12 and note < 14";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                count=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return count;
    }
    private int countinvalide(){
        int count=0;
        connect=database.connectDb();
        String sql="select count(*) from soutenance where note < 10";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                count=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return count;
    }
    private int countbien(){
        int count=0;
        connect=database.connectDb();
        String sql="select count(*) from soutenance where note >= 14 and note < 16";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                count=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return count;
    }
    private int countexcellent(){
        int count=0;
        connect=database.connectDb();
        String sql="select count(*) from soutenance where note >= 16";
        try{
            prepare=connect.prepareStatement(sql);
            resultat=prepare.executeQuery();
            while(resultat.next()){
                count=resultat.getInt(1);
            }
            prepare.close();
        }catch (Exception r){
            r.printStackTrace();
        }
        return count;
    }


    private void iniPieChart(){
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList(
            new PieChart.Data("indiv",countGroupe() ),
            new PieChart.Data("groupe",countIndiv() )
        );
        pieChart.setData(pieChartData);
        pieChart.setStartAngle(90); 
    }
    private void iniPieChart1(){
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();
            if(countpassable()!=0){
                pieChartData.add(new PieChart.Data("passbale",countpassable()));
            }
            if(countassezbien()!=0){
                pieChartData.add(new PieChart.Data("assez bien",countassezbien()));
            }
            if(countbien()!=0){
                pieChartData.add(new PieChart.Data("bien", countbien()));
            }
            if(countexcellent()!=0){
                pieChartData.add(new PieChart.Data("excellent", countexcellent()));
            }
        pieChart1.setData(pieChartData);
    }
    @SuppressWarnings("unchecked")
    private void handleShowBarChar(){
        CategoryAxis xAxis=new CategoryAxis();
        xAxis.setLabel("Product");

        NumberAxis yAxis =new NumberAxis();
        yAxis.setLabel("quhkbjj");

        XYChart.Series data=new XYChart.Series() ;
        data.setName("Series 1");

        data.getData().add(new XYChart.Data("soutenance planifier",12));
        data.getData().add(new XYChart.Data("soutenance non planifier",13));
        data.getData().add(new XYChart.Data("soutenance evaluer",40));
        data.getData().add(new XYChart.Data("soutenance non evaluer",40));
        barChart.setLegendVisible(false);
        barChart.getData().add(data);
    }








    @Override
    
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        setEtude.getItems().addAll("Licence","Master","Ingénieure");
        this.insertionDansTable();
        this.insertionDansTableEnsei();
        this.insertionDansTableEnca();
        this.insertionDansTablePFE();
        this.insertionDansTableJury();
        this.insertionDansTableSoutenance();
        setEtude.setOnAction(this::setsection);
        setPresident.getItems().addAll(EnseignantNomPrenomListData());
        setRapporeteur.getItems().addAll(EnseignantNomPrenomListData());
        setExaminateur.getItems().addAll(EnseignantNomPrenomListData());
        setInvite.getItems().addAll(EnseignantNomPrenomListDataInvite());
        setEncadreurPFE.getItems().addAll(EnseignantNomPrenomListData());
        setEtudiant1.getItems().addAll(EtudiantNomPrenomListData());
        setEtudiant2.getItems().addAll(EtudiantNomPrenomListData());
        soutenancePFE.getItems().addAll(PFENomPrenomListData());
        soutenanceJury.getItems().addAll(JuryNomPrenomListData());
        soutenanceSalle.getItems().addAll("C17","C18","C19","C20");
        afficherhDebut();

        
        

        addstat();
        iniPieChart();
        iniPieChart1();
        // handleShowBarChar();
    }
}

class main{
    public static void main(String[]args)throws Exception{
        // ControlerEtudient con=new ControlerEtudient();
        // ObservableList<Soutenance> list=FXCollections.observableArrayList();
        // list=con.soutenanceListData();
        // con.addstat();
        // for(Soutenance i:list){
        //     System.out.println(con.idSoutenance(i));
        // }
        // System.out.println(con.verfierSoutenance("2024-04-28,03:36:55,C34"));
    }
}



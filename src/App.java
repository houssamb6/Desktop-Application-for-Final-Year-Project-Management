
import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //with FXML
        Parent root=FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene=new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene); 
        Image icon=new Image("image3.jpeg");
        stage.getIcons().add(icon);
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
} 













































































/* without  FXML 
        //Stage stage=new Stage();
        Group root =new Group();//Group of node
        Scene scene=new Scene(root,1200,700,Color.BLACK);
        Image icon=new Image("image3.jpeg");
        stage.getIcons().add(icon);
        stage.setTitle("Hello World");
        stage.setResizable(false);
        //stage.setWidth(600);
        //stage.setHeight(600);
        Text text=new Text();
        text.setText("WHOOOOO!!!!");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana",50));
        text.setFill(Color.GREEN);
        root.getChildren().add(text);

        Line line=new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.8);
        root.getChildren().add(line);
        

        Rectangle rec =new Rectangle();
        rec.setX(100);
        rec.setY(100);
        rec.setWidth(400);
        rec.setHeight(100);
        rec.setFill(Color.BLUE);
        rec.setStrokeWidth(5);
        rec.setStroke(Color.BEIGE);
        root.getChildren().add(rec);

        Image image1=new Image("image1.jpg");
        ImageView imgview=new ImageView(image1);
        root.getChildren().add(imgview);

        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("Press q to Exit Full Screen Mode");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
        stage.setScene(scene);
        stage.show();
        */
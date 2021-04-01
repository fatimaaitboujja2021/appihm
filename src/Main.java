import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("SplashFXML.fxml"));

       Scene scene = new Scene(root);
       Image icon = new Image("pic1.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("stone Paper Scissors");
        primaryStage.setScene(scene);
       primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

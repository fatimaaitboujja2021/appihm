

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author oXCToo
 */
public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField enterPasswordField;
/*@FXML
private  void sendToGame(ActionEvent event) throws IOException {
if(event.getSource()==loginButton)
if(validateLogin() == 1) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    Parent root = loader.load();
    GameController gamewindow = loader.getController();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.setTitle("game Window");
    stage.show();
}
}*/


    @Override
public void initialize(URL url, ResourceBundle resourceBundle) {
    // TODO

}



    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if(event.getSource()==loginButton){
           // loginMessageLabel.setText("You try to login");
            //validateLogin();
            if(validateLogin() == 1) {
                /*FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root = loader.load();
                GameController gamewindow = loader.getController();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("game Window");
                stage.show();*/


                   /* Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();*/

            }

        }else{
            loginMessageLabel.setText("Please enter username and password");

        }
 }


    public void SignupButtonOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       // createAccountForm();


    }
    public int validateLogin(){
ConnectionUtil connectNow = new ConnectionUtil();
Connection connectDB =connectNow.conDB();
String verifyLogin = "select count(1) from login WHERE email ='"+ usernameTextField.getText() + "'AND password='" + enterPasswordField.getText() +"'";
try{
    Statement statement= connectDB.createStatement();
    ResultSet queryResult = statement.executeQuery(verifyLogin);
while (queryResult.next()){
  if(queryResult.getInt(1)==1){
      loginMessageLabel.setText("Congratulations!");
     // createAccountForm();
      return 1;
  }else{
      loginMessageLabel.setText("Invalide login!.please Try again");
      return 2;

  }
}
}catch(Exception e){
    e.printStackTrace();
    e.getCause();
}

  return 0 ;  }



    public void switchToGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();}

    public void switchToAbout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage= (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


    /// --
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;





    public LoginController() {
        con = ConnectionUtil.conDB();
    }

    public void entred(Event e){
        ((Button) e.getSource()).setScaleX(1.1);
        ((Button) e.getSource()).setScaleY(1.1);
        ((Button) e.getSource()).setTextFill(Color.DARKGREEN);
        if(((Button) e.getSource()).getText().equals("EXIT")){
            ((Button) e.getSource()).setTextFill(Color.RED);

        }

    }

    public void exited(Event e){
        ((Button) e.getSource()).setScaleX(1);
        ((Button) e.getSource()).setScaleY(1);
        ((Button) e.getSource()).setTextFill(Color.WHITE);

        if(((Button) e.getSource()).getText().equals("Exit")){
            ((Button) e.getSource()).setTextFill(Color.RED);

        }
    }


}

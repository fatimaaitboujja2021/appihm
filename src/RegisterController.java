import javafx.application.Platform;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

@FXML
private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
private Label registrationMessageLabel;
    @FXML
private PasswordField setPasswordField;
    @FXML
private  PasswordField confirmPasswordField;
@FXML
private Label confirmPasswordLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
   //Connection conn = null ;
   PreparedStatement pst = null ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO

    }

    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }

public  void closeButtonOnAction(ActionEvent event){
    Stage stage= (Stage) closeButton.getScene().getWindow();
    stage.close();
    Platform.exit();
}
 public void registerButtonOnAction(ActionEvent event){

     if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
        // confirmPasswordLabel.setText("Password  match");
        // registrationMessageLabel.setText("User has been registred successfully!!");

         registerUser();
       //  registrationMessageLabel.setText("User has been registred successfully!!");

        // confirmPasswordLabel.setText("");
         //confirmPasswordLabel.setText("Password  match");

     }
     else{
        // confirmPasswordLabel.setText("Password does not match");
     }}


public void registerUser(){

      ConnectionUtil connectNow = new ConnectionUtil();
      Connection connectionDB = connectNow.conDB();
       String first = firstnameTextField.getText();
        String last = lastnameTextField.getText();
        String user = usernameTextField.getText();
        String password= setPasswordField.getText();
    String confirmpassword= confirmPasswordField.getText();

    if (password.equals(confirmPasswordField.getText())){
        confirmPasswordLabel.setText("Password  match");

        if(!first.isEmpty() && !last.isEmpty() && !user.isEmpty() && !password.isEmpty()) {
    String sql = "insert into login (firstname,lastname,email,password) values (?,?,?,?)";

    try {
        pst = connectionDB.prepareStatement(sql);
        pst.setString(1, first);
        pst.setString(2, last);
        pst.setString(3, user);
        pst.setString(4, password);
        pst.execute();
       //registrationMessageLabel.setText("User has been registred successfully!!");
        //confirmPasswordLabel.setText("Password  match");

        JOptionPane.showMessageDialog(null,"registered");
        registrationMessageLabel.setText("User has been registred successfully!!");
        confirmPasswordLabel.setText("Password  match");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
        JOptionPane.showMessageDialog(null, "no registered");

    }}
}else{
    registrationMessageLabel.setText("verify your input");

}
}

    public void entred(Event e){
        ((Button) e.getSource()).setScaleX(1.1);
        ((Button) e.getSource()).setScaleY(1.1);
        ((Button) e.getSource()).setTextFill(Color.DARKGREEN);


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

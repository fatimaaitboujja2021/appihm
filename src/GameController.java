import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    private static final String PAPER = "paper";
    private static final String ROCK = "rock";
    private static final String SCISSORS = "scissors";
    private Image image;

    @FXML
    private Button sendScoreButton;


    @FXML
    private Button homeButton;
    @FXML
    private Button resetButton;

    @FXML
    private Button rockBtn;

    @FXML
    private Button paperBtn;

    @FXML
    private Button scissorsBtn;

    @FXML
    private Button exitButton;

    @FXML
    private Label playerScore;

    @FXML
    private Label computerScore;

    @FXML
    private ImageView player;

    @FXML
    private Label result;

    @FXML
    private ImageView computer;

    @FXML
    private void playerTurn(ActionEvent event) {
        String playerChoice = null;
        switch (((Button) event.getSource()).getId()) {
            case "paperBtn":
                image = new Image("/img/ic_paper.png");
                playerChoice = PAPER;
                break;
            case "rockBtn":
                image = new Image("/img/ic_stone.png");
                playerChoice = ROCK;
                break;
            case "scissorsBtn":
                image = new Image("/img/ic_scissors.png");
                playerChoice = SCISSORS;
                break;
        }
        player.setImage(image);

        winner(playerChoice, computerTurn());
    }

    private String computerTurn() {
        String computerChoice = null;
        int index = (int) (Math.random() * 3);
        switch (index) {
            case 0:
                image = new Image("/img/ic_stone.png");
                computerChoice = ROCK;
                break;
            case 1:
                image = new Image("/img/ic_paper.png");
                computerChoice = PAPER;
                break;
            case 2:
                image = new Image("/img/ic_scissors.png");
                computerChoice = SCISSORS;
                break;
        }
        computer.setImage(image);
        return computerChoice;
    }

    public void playerWin() {
        result.setText("You Win");
        playerScore.setText(String.valueOf(Integer.parseInt(playerScore.getText()) + 1));
    }

    public void computerWin() {
        result.setText("You Lose");
        computerScore.setText(String.valueOf(Integer.parseInt(computerScore.getText()) + 1));
    }

 /*   @FXML
private void sendScoreto(ActionEvent event) throws IOException {

String player = playerScore.getText();
String computer = computerScore.getText();
if(!player.isEmpty() && !computer.isEmpty()){
System.out.println("not null" + player);
}
FXMLLoader loader = new FXMLLoader(getClass().getResource("Score.fxml"));
Parent root = loader.load();
/ScoreController scoreController =loader.getController();
scoreController.display(player,computer);
 Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
   Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();*/

      /*  FXMLLoader loader = new FXMLLoader(getClass().getResource("Score.fxml"));
        Parent root = (Parent) loader.load();
        ScoreController scoreController = loader.getController();
        scoreController.display(player,computer);

        Scene newScene = new Scene(root);
        Stage newStage = new Stage();
        newStage.setScene(newScene);
        newStage.show();*/

        /*Parent root = FXMLLoader.load(getClass().getResource("Score.fxml"));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/

   // }


    public void draw() {
        result.setText("Draw");
    }

    private void winner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            draw();
            return;
        }
        if (playerChoice.equals(ROCK)) {
            if (computerChoice.equals(PAPER)) {
                computerWin();
            } else if (computerChoice.equals(SCISSORS)) {
                playerWin();
            }
        } else if (playerChoice.equals(PAPER)) {
            if (computerChoice.equals(ROCK)) {
                playerWin();
            } else if (computerChoice.equals(SCISSORS)) {
                computerWin();
            }
        } else {
            if (computerChoice.equals(ROCK)) {
                computerWin();
            } else if (computerChoice.equals(PAPER)) {
                playerWin();
            }
        }
    }


    public void entred(Event e){
        ((Button) e.getSource()).setScaleX(1.1);
        ((Button) e.getSource()).setScaleY(1.1);
        ((Button) e.getSource()).setTextFill(Color.BLUE);


    }
    public void exited(Event e){
        ((Button) e.getSource()).setScaleX(1);
        ((Button) e.getSource()).setScaleY(1);
        ((Button) e.getSource()).setTextFill(Color.BLACK);

        if(((Button) e.getSource()).getText().equals("Exit")){
            ((Button) e.getSource()).setTextFill(Color.RED);

        }
    }

    //fatiima ajouti lbutton dyal restart
    public void ResetGameButton(ActionEvent event){
        if(event.getSource()==resetButton) {

            result.setText("Play Again");
            computerScore.setText("0");
            playerScore.setText("0");
        }


    }
    public void ExitButtonOnAction(ActionEvent event){
        Stage stage= (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();



    }


}


package views;

import App.App;
import controllers.GameController;
import controllers.MainController;
import controllers.ScoreController;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {

    public Rectangle picture;

    public void playGame() {
        GameController.getInstance().startGame();
        App.changeMenu("gamePage");
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().get(0).requestFocus();
    }

    public void continueGame() {
    }

    public void profileMenu() {
        App.changeMenu("profilePage");
        MainController.getInstance().showInfo();
    }

    public void showScores() {
        App.changeMenu("scoreBoardPage");
        ScoreController.getInstance().showInfo();
    }

    public void exitGame() {
        MainController.getInstance().writeUserInfo();
        System.exit(0);
    }

    public void setSettings() {
        App.changeMenu("settingPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        picture.setFill(new ImagePattern(new Image(getClass().getResource("/assets/backgrounds/img.png").toExternalForm())));
    }
}

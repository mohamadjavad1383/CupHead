package views;

import App.Main;
import controllers.GameController;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Finish2 implements Initializable {
    public Label time;
    public Label score;

    public void back() {
        GameController.getInstance().finishGame();
        Main.changeMenu("mainPage");
    }

    public void restart() {
        GameController.getInstance().finishGame();
        GameController.getInstance().startGame();
        Main.changeMenu("gamePage");
        Pane pane = (Pane) Main.getScene().getRoot();
        pane.getChildren().get(0).requestFocus();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        time.setText((((System.currentTimeMillis() - GameController.getInstance().getGame().getStart()) / 60000) + ":"
                + ((System.currentTimeMillis() - GameController.getInstance().getGame().getStart()) / 1000)));
        score.setText(String.valueOf(GameController.getInstance().getGame().getScore()));
    }
}

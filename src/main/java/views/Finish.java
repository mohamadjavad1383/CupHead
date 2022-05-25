package views;

import App.App;
import controllers.GameController;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Finish implements Initializable {
    public ProgressBar bar;
    public Label quote;
    public Rectangle picture;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (GameController.getInstance().getGame().getBoss1() != null)
            bar.setProgress(GameController.getInstance().getGame().getBoss1().getLives() / 5);
        else if (GameController.getInstance().getGame().getBoss2() != null)
            bar.setProgress(GameController.getInstance().getGame().getBoss2().getLives() / 5);
        else if (GameController.getInstance().getGame().getBoss3() != null)
            bar.setProgress(GameController.getInstance().getGame().getBoss3().getLives() / 5);

        picture.setFill(new ImagePattern(new Image(getClass().getResource("/assets/bossHead.png").toExternalForm())));
        quote.setText("I always restart the game when I know I'm about to lose");
    }

    public void back() {
        GameController.getInstance().finishGame();
        App.changeMenu("mainPage");
    }

    public void restart() {
        GameController.getInstance().finishGame();
        GameController.getInstance().startGame();
        App.changeMenu("gamePage");
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().get(0).requestFocus();
    }
}

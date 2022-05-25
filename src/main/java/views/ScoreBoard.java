package views;

import App.App;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ScoreBoard {
    public void backToMain(MouseEvent mouseEvent) {
        App.changeMenu("mainPage");
    }
}

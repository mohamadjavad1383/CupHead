package views;

import App.Main;
import controllers.MusicController;
import controllers.SettingController;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Setting implements Initializable {
    public ChoiceBox<String> choice;

    public void mute(MouseEvent mouseEvent) {
        MusicController.getInstance().mute();
    }

    public void haveColor(MouseEvent mouseEvent) {

    }

    public void backToMain(MouseEvent mouseEvent) {
        SettingController.getInstance().setSetting(choice.getValue());
        Main.changeMenu("mainPage");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] strings = {"easy","medium","hard","devil mode"};
        choice.getItems().addAll(strings);
    }
}

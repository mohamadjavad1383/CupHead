package views;

import App.Main;
import controllers.LoginController;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import models.User;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    public TextField username;
    public TextField password;
    public Pane pane;

    public void login(MouseEvent mouseEvent) {
        String message = LoginController.getInstance().login(username.getText(), password.getText());
        Main.showPopup(message);
        if (message.equals("successful"))
            Main.changeMenu("mainPage");
    }

    public void register(MouseEvent mouseEvent) {
        String message = LoginController.getInstance().register(username.getText(), password.getText());
        Main.showPopup(message);
        if (message.equals("successful"))
            Main.changeMenu("mainPage");
    }

    public void guest() {
        Main.changeMenu("mainPage");
        LoginController.getInstance().guest();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < User.getAllUsers().size(); i++) {
            User.getAllUsers().get(i).setLostInDevilMode(0);
        }
    }
}

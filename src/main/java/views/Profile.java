package views;

import App.Main;
import controllers.MainController;
import controllers.ProfileController;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import models.User;

import java.io.File;
import java.io.IOException;

public class Profile {
    public BorderPane avatar;
    public TextField changeusername;
    public TextField changepassword;

    public void changeUsername(MouseEvent mouseEvent) {
        String message = ProfileController.getInstance().changeUsername(changeusername.getText());
        Main.showPopup(message);
        MainController.getInstance().showInfo();
    }

    public void changePassword(MouseEvent mouseEvent) {
        String message = ProfileController.getInstance().changePassword(changepassword.getText());
        Main.showPopup(message);
        MainController.getInstance().showInfo();
    }

    public void changeAvatar(MouseEvent mouseEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("avatar");
        fileChooser.setInitialDirectory(new File("src/main/resources/avatars/"));
        File file = fileChooser.showOpenDialog(Main.getScene().getWindow());
        User.getLoggedInUser().setAvatar(file.getAbsolutePath());
        MainController.getInstance().showInfo();
        //fileChooser.get
    }

    public void deleteAccount(MouseEvent mouseEvent) {
        String message = ProfileController.getInstance().deleteAccount();
        Main.showPopup(message);
        if (message.equals("successful"))
            Main.changeMenu("loginPage");
    }

    public void exitAccount(MouseEvent mouseEvent) {
        String message = ProfileController.getInstance().exitAccount();
        Main.showPopup(message);
        if (message.equals("successful"))
            Main.changeMenu("loginPage");
    }

    public void backToMain(MouseEvent mouseEvent) {
        Main.changeMenu("mainPage");
    }
}

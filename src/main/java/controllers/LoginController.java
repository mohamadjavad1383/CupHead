package controllers;

import App.Main;
import javafx.scene.layout.Pane;
import models.User;

public class LoginController {
    private static LoginController instance = null;

    private LoginController() {
    }

    public static LoginController getInstance() {
        if (instance == null)
            instance = new LoginController();
        return instance;
    }

    public String register(String username, String password) {
        if (username.equals(""))
            return "choose a username";
        if (password.equals(""))
            return "choose a password";
        if (User.getUserByUsername(username) != null)
            return "username exist";
        User user = new User(username, password);
        User.setLoggedInUser(user);
        return "successful";
    }

    public String login(String username, String password) {
        if (username.equals(""))
            return "choose a username";
        if (password.equals(""))
            return "choose a password";
        if (User.getUserByUsername(username) == null || !User.checkPassword(username, password))
            return "username or password is wrong";
        User.setLoggedInUser(User.getUserByUsername(username));
        return "successful";
    }

    public void guest() {
        Pane pane = (Pane) Main.getScene().getRoot();
        for (int i = 1; i <= 3; i++)
            pane.getChildren().get(i).setDisable(true);
    }
}

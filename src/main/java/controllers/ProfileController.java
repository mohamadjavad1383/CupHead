package controllers;

import models.User;

public class ProfileController {
    private static ProfileController instance = null;

    private ProfileController() {
    }

    public static ProfileController getInstance() {
        if (instance == null)
            instance = new ProfileController();
        return instance;
    }

    public String changeUsername(String username) {
        if (username.equals(""))
            return "please choose a username";
        if (username.equals(User.getLoggedInUser().getUsername()))
            return "please choose a different username";
        if (User.getUserByUsername(username) != null)
            return "username exist";

        User.getLoggedInUser().setUsername(username);
        return "successful";
    }

    public String changePassword(String password) {
        if (password.equals(""))
            return "please choose a password";
        if (password.equals(User.getLoggedInUser().getPassword()))
            return "please choose a different password";

        User.getLoggedInUser().setPassword(password);
        return "successful";
    }

    public String exitAccount() {
        User.setLoggedInUser(null);
        return "successful";
    }

    public String deleteAccount() {
        User.deleteLoggedInUser();
        return "successful";
    }
}

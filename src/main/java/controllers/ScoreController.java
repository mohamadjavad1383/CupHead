package controllers;

import App.App;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import models.User;

import java.util.ArrayList;
import java.util.Collections;


public class ScoreController {
    private static ScoreController instance = null;

    private ScoreController() {
    }

    public static ScoreController getInstance() {
        if (instance == null)
            instance = new ScoreController();
        return instance;
    }

    public void showInfo() {
        Pane pane = (Pane) App.getScene().getRoot();
        ((Label) pane.getChildren().get(0)).setText(getSortedUser().get(0).getUsername());
        for (int i = 0; i < 9; i++) {
            if (getSortedUser().size() > i + 1)
            ((Label) pane.getChildren().get(i + 4)).setText(getSortedUser().get(i + 1).getUsername());
        }
    }

    private ArrayList<User> getSortedUser() {
        ArrayList<User> arrayList = User.getAllUsers();
        Collections.sort(arrayList);
        return arrayList;
    }
}

package controllers;

import App.App;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import models.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    private static MainController instance = null;

    private MainController() {
    }

    public static MainController getInstance() {
        if (instance == null)
            instance = new MainController();
        return instance;
    }

    public void writeUserInfo() {
        try {
            FileWriter fileWriter = new FileWriter("user.json");
            fileWriter.write(new Gson().toJson(User.getAllUsers()));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readUserInfo() {
        try {
            String info = new String(Files.readAllBytes(Paths.get("user.json")));
            User.setAllUsers(new Gson().fromJson(info, new TypeToken<List<User>>() {
            }.getType()));
            if (User.getAllUsers() == null)
                User.setAllUsers(new ArrayList<>());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInfo() {
        Pane pane = (Pane) App.getScene().getRoot();

        Label label = (Label) pane.getChildren().get(1);
        label.setText(User.getLoggedInUser().getUsername());

        Label label1 = (Label) pane.getChildren().get(3);
        label1.setText(User.getLoggedInUser().getPassword());

        Label label2 = (Label) pane.getChildren().get(5);
        label2.setText(String.valueOf(User.getLoggedInUser().getScore()));

        BorderPane borderPane = (BorderPane) pane.getChildren().get(6);

        try {
            InputStream inputStream = new FileInputStream(User.getLoggedInUser().getAvatar());
            Image image = new Image(inputStream);
            ImageView imageView = new ImageView(image);
            borderPane.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

package models;

import App.App;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import models.animations.BombAnimation;

import java.util.ArrayList;

public class Bomb extends Circle {
    private static ArrayList<Bomb> allBombs = new ArrayList<>();
    private BombAnimation animation;

    public Bomb(Pane pane, Rectangle cupHead) {
        super(cupHead.getX() + 120, cupHead.getY() + 500, 15);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/bomb.jpg").toExternalForm())));
        pane.getChildren().add(this);
        allBombs.add(this);
        this.animation = new BombAnimation(this);
        this.animation.play();

    }

    public void setPlace(double dy) {
        this.setCenterY(this.getCenterY() + dy);
    }

    public static ArrayList<Bomb> getAllBombs() {
        return allBombs;
    }

    public void removeWhenOut() {
        if (this.getCenterY() > 780) {
            remove();
        }
    }

    public void remove() {
        allBombs.remove(this);
        this.animation.stop();
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().remove(this);
    }

    public BombAnimation getAnimation() {
        return animation;
    }

    public static void setAllBombs(ArrayList<Bomb> allBombs) {
        Bomb.allBombs = allBombs;
    }
}

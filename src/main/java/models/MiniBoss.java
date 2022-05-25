package models;

import App.App;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.animations.MiniBossAnimation;

import java.util.ArrayList;

public class MiniBoss extends Rectangle {
    private static ArrayList<MiniBoss> miniBosses = new ArrayList<>();
    private static int y = 100;
    private double lives = 2;
    private MiniBossAnimation animation;

    public MiniBoss(Pane pane) {
        super(920, y, 80, 60);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/miniBoss.png").toExternalForm())));
        pane.getChildren().add(this);
        miniBosses.add(this);
        this.animation = new MiniBossAnimation(this);
        this.animation.play();
        y += 100;
        if (y == 600)
            y = 100;
    }

    public void setPlace(double dx) {
        this.setX(this.getX() - dx);
    }

    public void removeWhenOut() {
        if (this.getX() < 0) {
            remove();
        }
    }

    public void remove() {
        miniBosses.remove(this);
        this.animation.stop();
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().remove(this);
    }

    public static ArrayList<MiniBoss> getMiniBosses() {
        return miniBosses;
    }

    public double getLives() {
        return lives;
    }

    public void decreaseLives(double lives) {
        this.lives -= lives;
    }

    public MiniBossAnimation getAnimation() {
        return animation;
    }

    public static void setMiniBosses(ArrayList<MiniBoss> miniBosses) {
        MiniBoss.miniBosses = miniBosses;
    }
}

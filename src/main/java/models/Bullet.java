package models;

import App.Main;
import controllers.MusicController;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.animations.BulletAnimation;

import java.util.ArrayList;

public class Bullet extends Rectangle {
    private static ArrayList<Bullet> allBullets = new ArrayList<>();
    private BulletAnimation animation;

    public Bullet(Pane pane, Rectangle cupHead) {
        super(cupHead.getX() + 200, cupHead.getY() + 400, 40, 15);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/bullet.png").toExternalForm())));
        pane.getChildren().add(this);
        allBullets.add(this);
        this.animation = new BulletAnimation(this);
        this.animation.play();
        MusicController.getInstance().shot();
    }

    public static ArrayList<Bullet> getAllBullets() {
        return allBullets;
    }

    public void setPlace(double dx) {
        this.setX(this.getX() + dx);
    }

    public void removeWhenOut() {
        if (this.getX() > 1000) {
            remove();
        }
    }

    public void remove() {
        allBullets.remove(this);
        animation.stop();
        Pane pane = (Pane) Main.getScene().getRoot();
        pane.getChildren().remove(this);
    }

    public BulletAnimation getAnimation() {
        return animation;
    }

    public static void setAllBullets(ArrayList<Bullet> allBullets) {
        Bullet.allBullets = allBullets;
    }
}

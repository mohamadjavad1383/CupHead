package models.bosses;

import App.Main;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import models.animations.bosses.BossShot3Animation;


import java.util.ArrayList;

public class BossShot3 extends Circle {
    private static ArrayList<BossShot3> shots3 = new ArrayList<>();
    private final BossShot3Animation animation;

    public BossShot3(Pane pane, Boss3 boss3) {
        super(boss3.getX() + 120, boss3.getY() + 40, 15);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/Boss2/BossShot3.png").toExternalForm())));
        pane.getChildren().add(this);
        shots3.add(this);
        this.animation = new BossShot3Animation(this);
        this.animation.play();
    }

    public void changeX(double dx) {
        this.setCenterX(this.getCenterX() - dx);
    }

    public void removeWhenOut() {
        if (this.getCenterX() < 0) {
            remove();
        }
    }

    public void remove() {
        shots3.remove(this);
        this.animation.stop();
        Pane pane = (Pane) Main.getScene().getRoot();
        pane.getChildren().remove(this);
    }

    public static ArrayList<BossShot3> getShots3() {
        return shots3;
    }

    public BossShot3Animation getAnimation() {
        return animation;
    }

    public static void setShots3(ArrayList<BossShot3> shots3) {
        BossShot3.shots3 = shots3;
    }

    public void changeY(double speed) {
        this.setCenterY(this.getCenterY() - speed);
    }
}

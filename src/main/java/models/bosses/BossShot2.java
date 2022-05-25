package models.bosses;

import App.Main;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import models.animations.bosses.BossShot2Animation;

import java.util.ArrayList;

public class BossShot2 extends Circle {
    private static ArrayList<BossShot2> shots2 = new ArrayList<>();
    private final BossShot2Animation animation;

    public BossShot2(Pane pane, Boss2 boss2) {
        super(boss2.getX(), boss2.getY() + 40, 15);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/boss2Shot.png").toExternalForm())));
        pane.getChildren().add(this);
        shots2.add(this);
        this.animation = new BossShot2Animation(this);
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
        shots2.remove(this);
        this.animation.stop();
        Pane pane = (Pane) Main.getScene().getRoot();
        pane.getChildren().remove(this);
    }

    public static ArrayList<BossShot2> getShots2() {
        return shots2;
    }

    public BossShot2Animation getAnimation() {
        return animation;
    }

    public static void setShots2(ArrayList<BossShot2> shots2) {
        BossShot2.shots2 = shots2;
    }
}

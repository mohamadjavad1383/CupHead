package models.bosses;

import App.App;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import models.animations.bosses.BossShot1Animation;

import java.util.ArrayList;

public class BossShot1 extends Circle {
    private static ArrayList<BossShot1> shots1 = new ArrayList<>();
    private final BossShot1Animation animation;

    public BossShot1(Pane pane, Rectangle boss1) {
        super(boss1.getX(), boss1.getY() + 50, 15);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/egg.png").toExternalForm())));
        pane.getChildren().add(this);
        shots1.add(this);
        this.animation = new BossShot1Animation(this);
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
        shots1.remove(this);
        this.animation.stop();
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().remove(this);
    }

    public static ArrayList<BossShot1> getShots1() {
        return shots1;
    }

    public BossShot1Animation getAnimation() {
        return animation;
    }

    public static void setShots1(ArrayList<BossShot1> shots1) {
        BossShot1.shots1 = shots1;
    }
}

package models.animations;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import models.Bullet;

public class BulletAnimation extends Transition {
    private Bullet bullet;
    private final double speed = 4.5;
    private int count = 0;

    public BulletAnimation(Bullet bullet) {
        this.bullet = bullet;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        count++;
        if (count <= 10)
            bullet.setFill(new ImagePattern(new Image(getClass().getResource("/assets/3.png").toExternalForm())));
        else if (count <= 20)
            bullet.setFill(new ImagePattern(new Image(getClass().getResource("/assets/4.png").toExternalForm())));
        else
            bullet.setFill(new ImagePattern(new Image(getClass().getResource("/assets/bullet.png").toExternalForm())));
        bullet.setPlace(speed);
        bullet.removeWhenOut();
    }
}

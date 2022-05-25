package models.animations;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import models.MiniBoss;

public class MiniBossAnimation extends Transition {
    private MiniBoss miniBoss;
    private double speed = 1;

    public MiniBossAnimation(MiniBoss miniBoss) {
        this.miniBoss = miniBoss;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);

    }

    @Override
    protected void interpolate(double frac) {
        int num = (int) (frac * 3) + 1;
        miniBoss.setFill(new ImagePattern(new Image(getClass().getResource
                ("/assets/yellow/" + num +".png").toExternalForm())));
        miniBoss.setPlace(speed);
        miniBoss.removeWhenOut();
    }
}

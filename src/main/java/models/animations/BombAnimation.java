package models.animations;

import javafx.animation.Transition;
import javafx.util.Duration;
import models.Bomb;

public class BombAnimation extends Transition {
    Bomb bomb;
    private final double speed = 4.5;

    public BombAnimation(Bomb bomb) {
        this.bomb = bomb;
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        bomb.setPlace(speed);
        bomb.removeWhenOut();
    }
}

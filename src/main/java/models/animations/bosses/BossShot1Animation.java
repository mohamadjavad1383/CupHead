package models.animations.bosses;

import javafx.animation.Transition;
import javafx.util.Duration;
import models.bosses.BossShot1;

public class BossShot1Animation extends Transition {
    private BossShot1 shot1;
    private double speed = 4.5;
    public BossShot1Animation(BossShot1 shot1) {
        this.shot1 = shot1;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        shot1.changeX(speed);
        shot1.removeWhenOut();
    }
}

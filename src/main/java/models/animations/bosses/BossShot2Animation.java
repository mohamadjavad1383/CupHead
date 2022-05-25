package models.animations.bosses;

import javafx.animation.Transition;
import javafx.util.Duration;
import models.bosses.BossShot2;

public class BossShot2Animation extends Transition {
    private BossShot2 shot2;
    private double speed = 4.5;
    public BossShot2Animation(BossShot2 shot2) {
        this.shot2 = shot2;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        shot2.changeX(speed);
        shot2.removeWhenOut();
    }
}

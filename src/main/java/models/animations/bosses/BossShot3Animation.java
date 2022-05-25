package models.animations.bosses;

import javafx.animation.Transition;
import javafx.util.Duration;
import models.bosses.BossShot3;

public class BossShot3Animation extends Transition {
    private BossShot3 shot3;
    private double speed = 4.5;
    public BossShot3Animation(BossShot3 shot3) {
        this.shot3 = shot3;
        this.setCycleDuration(Duration.millis(1000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        shot3.changeY(speed);
        shot3.removeWhenOut();
    }
}

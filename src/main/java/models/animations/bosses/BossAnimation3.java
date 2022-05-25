package models.animations.bosses;

import App.App;
import controllers.GameController;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import models.bosses.Boss3;
import models.bosses.BossShot3;

import java.util.Random;

public class BossAnimation3 extends Transition {
    Boss3 boss3;

    public BossAnimation3(Boss3 boss3) {
        this.boss3 = boss3;
        boss3.getBar().setOpacity(1);
        boss3.getLife().setOpacity(1);
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        boolean canShot = true;
        for (BossShot3 shot3 : BossShot3.getShots3()) {
            if (shot3.getCenterY() > 200)
                canShot = false;
        }

        if (((3800) <= System.currentTimeMillis() % 4000) && canShot && GameController.getInstance().getGame() != null
                && GameController.getInstance().getGame().getBoss3() != null) {
            new BossShot3((Pane) App.getScene().getRoot(), GameController.getInstance().getGame().getBoss3());
        }
        Random random = new Random();
        int x, bound = 35;
        if (boss3.getX() + (x = random.nextInt(bound)) - (bound / 2) < 870 && boss3.getX() + x - (bound / 2) > 10)
            boss3.setX(boss3.getX() + x - (bound / 2));

        boss3.getBar().setWidth((boss3.getLives() / 7) * 150);
        boss3.getLife().setText(String.valueOf(boss3.getLives()));
    }
}

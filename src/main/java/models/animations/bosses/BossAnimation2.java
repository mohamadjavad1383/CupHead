package models.animations.bosses;

import App.Main;
import controllers.GameController;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import models.bosses.Boss2;
import models.bosses.BossShot2;

import java.util.Random;

public class BossAnimation2 extends Transition {
    Boss2 boss2;

    public BossAnimation2(Boss2 boss2) {
        this.boss2 = boss2;
        boss2.getBar().setOpacity(1);
        boss2.getLife().setOpacity(1);
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        boolean canShot = true;
        for (BossShot2 shot2 : BossShot2.getShots2()) {
            if (shot2.getCenterX() > 300)
                canShot = false;
        }
        if (((3900) <= System.currentTimeMillis() % 4000) && canShot && GameController.getInstance().getGame() != null
                && GameController.getInstance().getGame().getBoss2() != null) {
            new BossShot2((Pane) Main.getScene().getRoot(), GameController.getInstance().getGame().getBoss2());
        }
        Random random = new Random();
        int x, y, bound = 31;
        if (boss2.getX() + (x = random.nextInt(bound)) - (bound / 2) < 880 && boss2.getX() + x - (bound / 2) > 10)
            boss2.setX(boss2.getX() + x - (bound / 2));
        if (boss2.getY() + (y = random.nextInt(bound)) - (bound / 2) < 680 && boss2.getY() + y - (bound / 2) > 10)
            boss2.setY(boss2.getY() + y - (bound / 2));
        boss2.getBar().setWidth((boss2.getLives() / 7) * 200);
        boss2.getLife().setText(String.valueOf(boss2.getLives()));
    }
}

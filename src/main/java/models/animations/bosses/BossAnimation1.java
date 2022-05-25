package models.animations.bosses;

import App.Main;
import controllers.GameController;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import models.bosses.Boss1;
import models.bosses.BossShot1;

import java.util.Random;

public class BossAnimation1 extends Transition {
    Boss1 boss1;

    public BossAnimation1(Boss1 boss1) {
        this.boss1 = boss1;
        boss1.getBar().setOpacity(1);
        boss1.getLife().setOpacity(1);
        setCycleDuration(Duration.millis(1000));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        int num = (int) (frac * 5 + 1);
        boss1.setFill(new ImagePattern(new Image(getClass().getResource("/assets/BossFly/" + num + ".png").toExternalForm())));
        boolean canShot = true;
        for (BossShot1 shot1 : BossShot1.getShots1()) {
            if (shot1.getCenterX() > 300)
                canShot = false;
        }
        if (((3900) <= System.currentTimeMillis() % 4000) && canShot && GameController.getInstance().getGame() != null
                && GameController.getInstance().getGame().getBoss1() != null) {
            new BossShot1((Pane) Main.getScene().getRoot(), boss1);
        }
        boss1.getBar().setWidth((boss1.getLives() / 5) * 200);
        boss1.getLife().setText(String.valueOf(boss1.getLives()));

        // devil mode
        if (GameController.getInstance().getGame().isDevilMode()) {
            Random random = new Random();
            int y, bound = 31;
            if (boss1.getY() + (y = random.nextInt(bound)) - (bound / 2) < 680 && boss1.getY() + y - (bound / 2) > 10)
                boss1.setY(boss1.getY() + y - (bound / 2));
        }
    }
}

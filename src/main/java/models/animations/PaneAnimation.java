package models.animations;

import App.Main;
import controllers.GameController;
import controllers.MusicController;
import controllers.PauseController;
import javafx.animation.Transition;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import models.MiniBoss;
import models.bosses.Boss1;
import models.bosses.Boss2;
import models.bosses.Boss3;

public class PaneAnimation extends Transition {
    private Rectangle icon;
    private double opacity = 1;

    public PaneAnimation(Rectangle rectangle) {
        this.icon = rectangle;
        setCycleDuration(Duration.millis(50));
        setCycleCount(-1);
    }

    @Override
    protected void interpolate(double frac) {
        Pane pane = (Pane) Main.getScene().getRoot();

        // bullet animation
        if (GameController.getInstance().getGame() != null && GameController.getInstance().getGame().isOnBullet())
            icon.setFill(new ImagePattern(new Image(getClass().getResource("/assets/shmup_icon_bullet_0001.png").toExternalForm())));
        else
            icon.setFill(new ImagePattern(new Image(getClass().getResource("/assets/shmup_icon_bomb_0001.png").toExternalForm())));

        // create MiniBoss
        if ((9800) <= (System.currentTimeMillis() % 10500) && (MiniBoss.getMiniBosses().size() == 0)
                && !PauseController.getInstance().isPause()) {
            for (int i = 0; i < 5; i++)
                new MiniBoss(pane);
        }

        GameController.getInstance().MiniBossKill();

        GameController.getInstance().bossKill1();
        GameController.getInstance().bossKill2();
        GameController.getInstance().bossKill3();

        GameController.getInstance().getShotBoss1();
        GameController.getInstance().getShotBoss2();
        GameController.getInstance().getShotBoss3();

        // blink
        if (GameController.getInstance().getGame().getVisibility() > 0) {
            GameController.getInstance().getGame().getCupHead().setOpacity(opacity);
            GameController.getInstance().getGame().decreaseVisibility(0.1);
            opacity -= 0.1;
            if (opacity <= 0)
                opacity = 1;
            if (GameController.getInstance().getGame().getVisibility() <= 0 &&
                    GameController.getInstance().getGame().getVisibility() >= -0.01)
                opacity = 1;
        }

        // create Boss1
        long boss1Time = 10000;
        if (GameController.getInstance().getGame().getStart() + boss1Time <= System.currentTimeMillis() &&
                !GameController.getInstance().getGame().isHasBoss1() && !PauseController.getInstance().isPause()) {
            MusicController.getInstance().boss1();
            GameController.getInstance().getGame().setHasBoss1(true);
            GameController.getInstance().getGame().setBoss1(new Boss1(pane));
        }

        // create Boss2
        long boss2Time = 11000;
        if (GameController.getInstance().getGame().isDevilMode()) {
            if (GameController.getInstance().getGame().getStart() + boss2Time <= System.currentTimeMillis() &&
                    !GameController.getInstance().getGame().isHasBoss2() && !PauseController.getInstance().isPause()
                    && GameController.getInstance().getGame().getBoss1() == null) {
                MusicController.getInstance().boss2();
                GameController.getInstance().getGame().setHasBoss2(true);
                GameController.getInstance().getGame().setBoss2(new Boss2(pane));
            }
        }

        // create Boss3
        long boss3Time = 12000;
        if (GameController.getInstance().getGame().isDevilMode()) {
            if (GameController.getInstance().getGame().getStart() + boss3Time <= System.currentTimeMillis() &&
                    !GameController.getInstance().getGame().isHasBoss3() && !PauseController.getInstance().isPause()
                    && GameController.getInstance().getGame().getBoss2() == null &&
                    GameController.getInstance().getGame().isHasBoss2()) {
                GameController.getInstance().getGame().setHasBoss3(true);
                GameController.getInstance().getGame().setBoss3(new Boss3(pane));
            }
        }

        // score and life and timer label
        Label life = (Label) pane.getChildren().get(5);
        Label score = (Label) pane.getChildren().get(6);
        Label timer = (Label) pane.getChildren().get(7);

        life.setText(String.valueOf(GameController.getInstance().getGame().getLives()));
        if (GameController.getInstance().getGame().getLives() <= 1)
            life.setStyle("-fx-border-color: red");

        score.setText(String.valueOf(GameController.getInstance().getGame().getScore()));

        timer.setText(((System.currentTimeMillis() - GameController.getInstance().getGame().getStart()) / 60000) + ":"
                + ((System.currentTimeMillis() - GameController.getInstance().getGame().getStart()) / 1000));


        GameController.getInstance().checkGameFinish();

    }
}

package models.bosses;

import App.Main;
import controllers.GameController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.animations.bosses.BossAnimation2;

public class Boss2 extends Rectangle {
    private double lives = 7;
    private Rectangle bar;
    private Label life;
    private BossAnimation2 animation;

    public Boss2(Pane pane) {
        super(860, 350, 150, 150);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/boss2.png").toExternalForm())));
        pane.getChildren().add(this);
        this.bar = (Rectangle) pane.getChildren().get(2);
        this.life = (Label) pane.getChildren().get(4);
        this.animation = new BossAnimation2(this);
        this.animation.play();
    }

    public void decreaseLives(double lives) {
        this.lives -= lives;
    }

    public double getLives() {
        return lives;
    }

    public void remove() {
        animation.stop();
        life.setOpacity(0);
        life.setText("");
        bar.setOpacity(0);
        Pane pane = (Pane) Main.getScene().getRoot();
        pane.getChildren().remove(GameController.getInstance().getGame().getBoss2());
        GameController.getInstance().getGame().setBoss2(null);
    }

    public Rectangle getBar() {
        return bar;
    }

    public Label getLife() {
        return life;
    }

    public BossAnimation2 getAnimation() {
        return animation;
    }

    public void setLives(double lives) {
        this.lives = lives;
    }
}

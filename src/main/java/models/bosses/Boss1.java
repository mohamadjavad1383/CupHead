package models.bosses;

import App.App;
import controllers.GameController;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.animations.bosses.BossAnimation1;

public class Boss1 extends Rectangle {
    private double lives = 5;
    private Rectangle bar;
    private Label life;
    private BossAnimation1 animation;

    public Boss1(Pane pane) {
        super(860, 350, 150, 150);
        this.setFill(new ImagePattern(new Image(getClass().getResource("/assets/BossFly/1.png").toExternalForm())));
        pane.getChildren().add(this);
        this.bar = (Rectangle) pane.getChildren().get(2);
        this.life = (Label) pane.getChildren().get(4);
        this.animation = new BossAnimation1(this);
        this.animation.play();
    }

    public double getLives() {
        return lives;
    }

    public void decreaseLives(double lives) {
        this.lives -= lives;
    }

    public void remove() {
        animation.stop();
        life.setOpacity(0);
        life.setText("");
        bar.setOpacity(0);
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().remove(GameController.getInstance().getGame().getBoss1());
        GameController.getInstance().getGame().setBoss1(null);
    }

    public Rectangle getBar() {
        return bar;
    }

    public BossAnimation1 getAnimation() {
        return animation;
    }

    public void setLives(double lives) {
        this.lives = lives;
    }

    public Label getLife() {
        return life;
    }
}

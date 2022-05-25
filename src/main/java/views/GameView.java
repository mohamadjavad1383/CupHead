package views;

import App.App;
import controllers.GameController;
import controllers.MusicController;
import controllers.PauseController;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.Bomb;
import models.Bullet;
import models.MiniBoss;
import models.animations.PaneAnimation;

import java.net.URL;
import java.util.ResourceBundle;

public class GameView implements Initializable {
    public Pane pane;
    public Rectangle icon;
    public Rectangle cupHead;
    public Rectangle lifeBar;
    public Pane pauseMenu;
    public static PaneAnimation animation;
    public Label bossLife;
    public Label cupHeadLife;
    public Label cupHeadScore;
    public Label timer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MusicController.getInstance().changeMusic();
        pauseMenu.setOpacity(0);
        pauseMenu.setDisable(true);
        GameController.getInstance().getGame().setCupHead(cupHead);
        cupHead.setFill(new ImagePattern(new Image(getClass().getResource("/assets/red.png").toExternalForm())));
        animation = new PaneAnimation(icon);
        animation.play();
        lifeBar.setOpacity(0);
        bossLife.setOpacity(0);
        cupHead.requestFocus();

    }


    public void showMiniBosses() {
        for (int i = 0; i < 5; i++)
            new MiniBoss(pane);
    }

    public void changeAttack() {
        GameController.getInstance().getGame().setOnBullet(
                !GameController.getInstance().getGame().isOnBullet());
    }
    public void fire() {
        if (GameController.getInstance().getGame().isOnBullet()) {
            new Bullet(pane, GameController.getInstance().getGame().getCupHead());
        } else {
            new Bomb(pane, GameController.getInstance().getGame().getCupHead());
        }
    }

    public void keyPress(KeyEvent keyEvent) {
        GameController.getInstance().moveRight(keyEvent, cupHead);
        GameController.getInstance().moveUp(keyEvent, cupHead);
        GameController.getInstance().moveDown(keyEvent, cupHead);
        GameController.getInstance().moveLeft(keyEvent, cupHead);
        if (keyEvent.getCode().getName().equals("Tab"))
            changeAttack();
        if (keyEvent.getCode().getName().equals("Space"))
            fire();
        if (keyEvent.getCode().getName().equals("Enter") && !GameController.getInstance().getGame().isGameStarted()) {
            GameController.getInstance().getGame().setGameStarted(true);
            showMiniBosses();
        }
        if (keyEvent.getCode().getName().equals("P"))
            pause();

        // for debug
        if (keyEvent.getCode().getName().equals("T")) {
            System.out.println("--------------------------------------------------");
            for (Node child : pane.getChildren()) {
                System.out.println(child);
            }
            System.out.println("--------------------------------------------------");
        }
        if (keyEvent.getCode().getName().equals("F")) {
            GameController.getInstance().finishGame();
            App.changeMenu("mainPage");
        }
    }

    public void pause() {
        pauseMenu.setDisable(false);
        PauseController.getInstance().pauseGame();
        pauseMenu.setOpacity(1);
    }

    public void saveGame() {

    }

    public void quitGame() {
        GameController.getInstance().finishGame();
        App.changeMenu("mainPage");
    }

    public void restartGame() {
        GameController.getInstance().finishGame();
        GameController.getInstance().startGame();
        App.changeMenu("gamePage");
        Pane pane = (Pane) App.getScene().getRoot();
        pane.getChildren().get(0).requestFocus();
    }

    public void unPause() {
        PauseController.getInstance().unPause();
        cupHead.requestFocus();
        pauseMenu.setDisable(true);
        pauseMenu.setOpacity(0);
    }

    public void mute() {
        MusicController.getInstance().muteInGame();
    }

    public void showPanel() {
        App.changeMenu("panelPage");
    }
}

package controllers;

import App.App;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import models.*;
import models.bosses.BossShot1;
import models.bosses.BossShot2;
import models.bosses.BossShot3;
import views.GameView;

import java.util.ArrayList;

public class GameController {
    private static GameController instance = null;
    private Game game;

    private GameController() {
    }

    public static GameController getInstance() {
        if (instance == null)
            instance = new GameController();
        return instance;
    }

    public void startGame() {
        game = Game.getInstance();
        game.startGame(SettingController.getInstance().getLevel());
    }

    public void moveRight(KeyEvent keyEvent, Rectangle cupHead) {
        if ((keyEvent.getCode().getName().equals("Right") || keyEvent.getCode().getName().equals("D"))
                && cupHead.getX() < 840)
            cupHead.setX(cupHead.getX() + 10);
    }

    public void moveLeft(KeyEvent keyEvent, Rectangle cupHead) {
        if ((keyEvent.getCode().getName().equals("Left") || keyEvent.getCode().getName().equals("A"))
                && cupHead.getX() > 0)
            cupHead.setX(cupHead.getX() - 10);
    }

    public void moveUp(KeyEvent keyEvent, Rectangle cupHead) {
        if ((keyEvent.getCode().getName().equals("Up") || keyEvent.getCode().getName().equals("W"))
                && cupHead.getY() > -360)
            cupHead.setY(cupHead.getY() - 10);
    }

    public void moveDown(KeyEvent keyEvent, Rectangle cupHead) {
        if ((keyEvent.getCode().getName().equals("Down") || keyEvent.getCode().getName().equals("S"))
                && cupHead.getY() < 360)
            cupHead.setY(cupHead.getY() + 10);
    }

    public Game getGame() {
        return game;
    }

    public void MiniBossKill() {
        for (int i = 0; i < MiniBoss.getMiniBosses().size(); i++) {
            for (int j = 0; j < Bullet.getAllBullets().size(); j++) {
                if (MiniBoss.getMiniBosses().get(i).getBoundsInParent().intersects(Bullet.getAllBullets().get(j).getBoundsInParent())) {
                    if (MiniBoss.getMiniBosses().get(i).getLives() <= game.getDamage() + 0.01) {
                        MiniBoss.getMiniBosses().get(i).remove();
                        game.increaseScore(1);
                    } else
                        MiniBoss.getMiniBosses().get(i).decreaseLives(game.getDamage() * 1);

                    Bullet.getAllBullets().get(j).remove();
                    return;
                }
            }
            for (int j = 0; j < Bomb.getAllBombs().size(); j++) {
                if (MiniBoss.getMiniBosses().get(i).getBoundsInParent().intersects(Bomb.getAllBombs().get(j).getBoundsInParent())) {
                    MusicController.getInstance().Bomb();
                    if (MiniBoss.getMiniBosses().get(i).getLives() <= 2 * game.getDamage() + 0.01) {
                        MiniBoss.getMiniBosses().get(i).remove();
                        game.increaseScore(1);
                    } else
                        MiniBoss.getMiniBosses().get(i).decreaseLives(game.getDamage() * 2);
                    Bomb.getAllBombs().get(j).remove();
                    return;
                }
            }
            if (game.getCupHead().getBoundsInParent().intersects(MiniBoss.getMiniBosses().get(i).getBoundsInParent())
                    && game.getVisibility() < 0.0) {
                MiniBoss.getMiniBosses().get(i).remove();
                decreaseLife();
                return;
            }
        }
    }

    public synchronized void bossKill1() {
        if (game.getBoss1() != null) {
            for (int i = 0; i < Bullet.getAllBullets().size(); i++) {
                if (game.getBoss1().getBoundsInParent().intersects(Bullet.getAllBullets().get(i).getBoundsInParent())) {
                    if (game.getBoss1().getLives() <= game.getDamage() + 0.01) {
                        game.getBoss1().setLives(0);
                        game.getBoss1().remove();
                        game.increaseScore(5);
                    } else
                        game.getBoss1().decreaseLives(game.getDamage() * 1);
                    Bullet.getAllBullets().get(i).remove();
                    return;
                }
            }
            for (int i = 0; i < Bomb.getAllBombs().size(); i++) {
                if (game.getBoss1().getBoundsInParent().intersects(Bomb.getAllBombs().get(i).getBoundsInParent())) {
                    MusicController.getInstance().Bomb();
                    if (game.getBoss1().getLives() <= 2 * game.getDamage() + 0.01) {
                        game.getBoss1().setLives(0);
                        game.getBoss1().remove();
                        game.increaseScore(5);
                    } else
                        game.getBoss1().decreaseLives(game.getDamage() * 2);
                    Bomb.getAllBombs().get(i).remove();
                    return;
                }
            }
            if (game.getBoss1().getBoundsInParent().intersects(game.getCupHead().getBoundsInParent())
                    && game.getVisibility() < 0.0)
                decreaseLife();
        }
    }

    public synchronized void bossKill2() {
        if (game.getBoss2() != null) {
            for (int i = 0; i < Bullet.getAllBullets().size(); i++) {
                if (game.getBoss2().getBoundsInParent().intersects(Bullet.getAllBullets().get(i).getBoundsInParent())) {
                    if (game.getBoss2().getLives() <= game.getDamage() + 0.01) {
                        game.getBoss2().setLives(0);
                        game.getBoss2().remove();
                        game.increaseScore(5);
                    } else
                        game.getBoss2().decreaseLives(game.getDamage() * 1);
                    Bullet.getAllBullets().get(i).remove();
                    return;
                }
            }
            for (int i = 0; i < Bomb.getAllBombs().size(); i++) {
                if (game.getBoss2().getBoundsInParent().intersects(Bomb.getAllBombs().get(i).getBoundsInParent())) {
                    MusicController.getInstance().Bomb();
                    if (game.getBoss2().getLives() <= 2 * game.getDamage() + 0.01) {
                        game.getBoss2().setLives(0);
                        game.getBoss2().remove();
                        game.increaseScore(5);
                    } else
                        game.getBoss2().decreaseLives(game.getDamage() * 2);
                    Bomb.getAllBombs().get(i).remove();
                    return;
                }
            }
            if (game.getBoss2().getBoundsInParent().intersects(game.getCupHead().getBoundsInParent())
                    && game.getVisibility() < 0.0)
                decreaseLife();
        }
    }

    public synchronized void bossKill3() {
        if (game.getBoss3() != null) {
            for (int i = 0; i < Bullet.getAllBullets().size(); i++) {
                if (game.getBoss3().getBoundsInParent().intersects(Bullet.getAllBullets().get(i).getBoundsInParent())) {
                    if (game.getBoss3().getLives() <= game.getDamage() + 0.01) {
                        game.getBoss3().setLives(0);
                        game.getBoss3().remove();
                        game.increaseScore(5);
                    } else
                        game.getBoss3().decreaseLives(game.getDamage() * 1);
                    Bullet.getAllBullets().get(i).remove();
                    return;
                }
            }
            for (int i = 0; i < Bomb.getAllBombs().size(); i++) {
                if (game.getBoss3().getBoundsInParent().intersects(Bomb.getAllBombs().get(i).getBoundsInParent())) {
                    MusicController.getInstance().Bomb();
                    if (game.getBoss3().getLives() <= 2 * game.getDamage() + 0.01) {
                        game.getBoss3().setLives(0);
                        game.getBoss3().remove();
                        game.increaseScore(5);
                    } else
                        game.getBoss3().decreaseLives(game.getDamage() * 2);
                    Bomb.getAllBombs().get(i).remove();
                    return;
                }
            }
            if (game.getBoss3().getBoundsInParent().intersects(game.getCupHead().getBoundsInParent())
                    && game.getVisibility() < 0.0)
                decreaseLife();
        }
    }

    public void getShotBoss1() {
        if (game.getBoss1() != null) {
            for (int i = 0; i < BossShot1.getShots1().size(); i++) {
                if (game.getCupHead().getBoundsInParent().intersects(BossShot1.getShots1().get(i).getBoundsInParent())
                        && game.getVisibility() < 0.0) {
                    BossShot1.getShots1().get(i).remove();
                    decreaseLife();
                    return;
                }
            }
        }
    }

    public void getShotBoss2() {
        if (game.getBoss2() != null) {
            for (int i = 0; i < BossShot2.getShots2().size(); i++) {
                if (game.getCupHead().getBoundsInParent().intersects(BossShot2.getShots2().get(i).getBoundsInParent())
                        && game.getVisibility() < 0.0) {
                    BossShot2.getShots2().get(i).remove();
                    decreaseLife();
                    return;
                }
            }
        }
    }
    public void getShotBoss3() {
        if (game.getBoss3() != null) {
            for (int i = 0; i < BossShot3.getShots3().size(); i++) {
                if (game.getCupHead().getBoundsInParent().intersects(BossShot3.getShots3().get(i).getBoundsInParent())
                        && game.getVisibility() < 0.0) {
                    BossShot3.getShots3().get(i).remove();
                    decreaseLife();
                    return;
                }
            }
        }
    }

    private void decreaseLife() {
        game.setLives(game.getLives() - 1 * game.getGetDamage());
        game.setVisibility(20);
        game.increaseScore(-1);
    }

    // TODO complete
    public void checkGameFinish() {
        if (game.getLives() <= 0) {
            GameView.animation.stop();
            App.changeMenu("finishPage");
        } //else if ()
    }

    public void finishGame() {
        MusicController.getInstance().changeMusic();
        if (User.getLoggedInUser() == null)
            LoginController.getInstance().guest();
        for (int i = 0; i < MiniBoss.getMiniBosses().size(); i++) {
            MiniBoss.getMiniBosses().get(i--).remove();
        }
        for (int i = 0; i < Bullet.getAllBullets().size(); i++) {
            Bullet.getAllBullets().get(i--).remove();
        }
        for (int i = 0; i < Bomb.getAllBombs().size(); i++) {
            Bomb.getAllBombs().get(i--).remove();
        }
        for (int i = 0; i < BossShot1.getShots1().size(); i++) {
            BossShot1.getShots1().get(i--).remove();
        }
        for (int i = 0; i < BossShot2.getShots2().size(); i++) {
            BossShot2.getShots2().get(i--).remove();
        }
        for (int i = 0; i < BossShot3.getShots3().size(); i++) {
            BossShot3.getShots3().get(i--).remove();
        }
        GameView.animation.stop();
        MiniBoss.setMiniBosses(new ArrayList<>());
        Bullet.setAllBullets(new ArrayList<>());
        Bomb.setAllBombs(new ArrayList<>());
        BossShot1.setShots1(new ArrayList<>());
        BossShot2.setShots2(new ArrayList<>());
        BossShot3.setShots3(new ArrayList<>());
        GameView.animation.stop();
        Game.setInstance(null);
        game = null;
    }
}

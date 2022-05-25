package controllers;

import App.Main;
import models.Bomb;
import models.Bullet;
import models.MiniBoss;
import models.bosses.BossShot1;
import models.bosses.BossShot2;
import models.bosses.BossShot3;

public class PauseController {
    private static PauseController instance = null;
    private boolean pause = false;

    private PauseController() {
    }

    public static PauseController getInstance() {
        if (instance == null)
            instance = new PauseController();
        return instance;
    }

    public void pauseGame() {
        pause = true;
        for (int i = 0; i < Bullet.getAllBullets().size(); i++) {
            Bullet.getAllBullets().get(i).getAnimation().pause();
        }
        for (int i = 0; i < Bomb.getAllBombs().size(); i++) {
            Bomb.getAllBombs().get(i).getAnimation().pause();
        }
        for (int i = 0; i < MiniBoss.getMiniBosses().size(); i++) {
            MiniBoss.getMiniBosses().get(i).getAnimation().pause();
        }
        for (int i = 0; i < BossShot1.getShots1().size(); i++) {
            BossShot1.getShots1().get(i).getAnimation().pause();
        }
        if (GameController.getInstance().getGame().getBoss1() != null)
            GameController.getInstance().getGame().getBoss1().getAnimation().pause();

        for (int i = 0; i < BossShot2.getShots2().size(); i++) {
            BossShot2.getShots2().get(i).getAnimation().pause();
        }
        if (GameController.getInstance().getGame().getBoss2() != null)
            GameController.getInstance().getGame().getBoss2().getAnimation().pause();

        for (int i = 0; i < BossShot3.getShots3().size(); i++) {
            BossShot3.getShots3().get(i).getAnimation().pause();
        }
        if (GameController.getInstance().getGame().getBoss3() != null)
            GameController.getInstance().getGame().getBoss3().getAnimation().pause();

        Main.getScene().getRoot().requestFocus();
    }

    public void unPause() {
        pause = false;
        for (int i = 0; i < Bullet.getAllBullets().size(); i++) {
            Bullet.getAllBullets().get(i).getAnimation().play();
        }
        for (int i = 0; i < Bomb.getAllBombs().size(); i++) {
            Bomb.getAllBombs().get(i).getAnimation().play();
        }
        for (int i = 0; i < MiniBoss.getMiniBosses().size(); i++) {
            MiniBoss.getMiniBosses().get(i).getAnimation().play();
        }
        for (int i = 0; i < BossShot1.getShots1().size(); i++) {
            BossShot1.getShots1().get(i).getAnimation().play();
        }
        if (GameController.getInstance().getGame().getBoss1() != null)
            GameController.getInstance().getGame().getBoss1().getAnimation().play();

        for (int i = 0; i < BossShot2.getShots2().size(); i++) {
            BossShot2.getShots2().get(i).getAnimation().play();
        }
        if (GameController.getInstance().getGame().getBoss2() != null)
            GameController.getInstance().getGame().getBoss2().getAnimation().play();

        for (int i = 0; i < BossShot3.getShots3().size(); i++) {
            BossShot3.getShots3().get(i).getAnimation().play();
        }
        if (GameController.getInstance().getGame().getBoss3() != null)
            GameController.getInstance().getGame().getBoss3().getAnimation().play();
        GameController.getInstance().getGame().getCupHead().requestFocus();
    }

    public boolean isPause() {
        return pause;
    }

}

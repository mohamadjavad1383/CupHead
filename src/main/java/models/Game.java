package models;

import enums.Level;
import javafx.scene.shape.Rectangle;
import models.bosses.Boss1;
import models.bosses.Boss2;
import models.bosses.Boss3;


public class Game {
    private static Game instance = null;
    private Level level;
    private double lives;
    private double getDamage, damage, visibility = -1;
    private boolean isDevilMode;
    private Rectangle cupHead;
    private Boss1 boss1;
    private Boss2 boss2;
    private Boss3 boss3;
    private boolean hasBoss3 = false;
    private boolean hasBoss2 = false;
    private boolean hasBoss1 = false;
    boolean onBullet = true;
    private boolean gameStarted = false;
    private long start = System.currentTimeMillis();
    private int score = 0;

    private Game() {

    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public boolean isDevilMode() {
        return isDevilMode;
    }

    public Rectangle getCupHead() {
        return cupHead;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public long getStart() {
        return start;
    }

    public void setCupHead(Rectangle cupHead) {
        this.cupHead = cupHead;
    }

    public double getLives() {
        return lives;
    }

    public void setLives(double lives) {
        this.lives = lives;
    }

    public double getGetDamage() {
        return getDamage;
    }

    public double getDamage() {
        return damage;
    }

    public boolean isOnBullet() {
        return onBullet;
    }

    public void setOnBullet(boolean onBullet) {
        this.onBullet = onBullet;
    }

    public double getVisibility() {
        return visibility;
    }

    public void decreaseVisibility(double x) {
        visibility -= x;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public Boss1 getBoss1() {
        return boss1;
    }

    public void setBoss1(Boss1 boss1) {
        this.boss1 = boss1;
    }

    public boolean isHasBoss1() {
        return hasBoss1;
    }

    public void setHasBoss1(boolean hasBoss1) {
        this.hasBoss1 = hasBoss1;
    }

    public static void setInstance(Game instance) {
        Game.instance = instance;
    }

    public void startGame(Level level) {
        this.level = level;
        this.lives = level.getLives();
        this.damage = level.getDamage();
        this.getDamage = level.getGetDamage();
        this.isDevilMode = level.isDevilMode();
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int value) {
        score += value;
        if (score < 0)
            score = 0;
    }

    public Boss2 getBoss2() {
        return boss2;
    }

    public void setBoss2(Boss2 boss2) {
        this.boss2 = boss2;
    }

    public boolean isHasBoss2() {
        return hasBoss2;
    }

    public void setHasBoss2(boolean hasBoss2) {
        this.hasBoss2 = hasBoss2;
    }

    public Boss3 getBoss3() {
        return boss3;
    }

    public void setBoss3(Boss3 boss3) {
        this.boss3 = boss3;
    }

    public boolean isHasBoss3() {
        return hasBoss3;
    }

    public void setHasBoss3(boolean hasBoss3) {
        this.hasBoss3 = hasBoss3;
    }
}

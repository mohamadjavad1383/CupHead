package enums;

public enum Level {
    EASY(10, 0.5, 1.5, false),
    MEDIUM(5, 1, 1, false),
    HARD(2, 1.5, 0.5, false),
    DEVIL_MODE(2, 1.5, 0.5, true);
    private final double lives;
    private final double getDamage;
    private final double damage;
    private final boolean isDevilMode;

    Level(double lives, double getDamage, double damage, boolean isDevilMode) {
        this.lives = lives;
        this.getDamage = getDamage;
        this.damage = damage;
        this.isDevilMode = isDevilMode;
    }

    public double getLives() {
        return lives;
    }

    public double getGetDamage() {
        return getDamage;
    }

    public double getDamage() {
        return damage;
    }

    public boolean isDevilMode() {
        return isDevilMode;
    }

    public static Level getLevelByName(String name) {
        if (name.equals("easy"))
            return EASY;
        if (name.equals("devil mode"))
            return DEVIL_MODE;
        if (name.equals("hard"))
            return HARD;

        return MEDIUM;
    }
}

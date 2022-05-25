package controllers;

import enums.Level;

public class SettingController {
    private static SettingController instance = null;
    private Level level = Level.MEDIUM;

    private SettingController() {
    }

    public static SettingController getInstance() {
        if (instance == null)
            instance = new SettingController();
        return instance;
    }

    public void setSetting(String level) {
        if (level == null)
            this.level = Level.MEDIUM;
        else
            this.level = Level.getLevelByName(level);
    }

    public Level getLevel() {
        return level;
    }
}

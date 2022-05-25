package models;

import java.util.ArrayList;

public class User implements Comparable {
    private String username;
    private String password;
    private static User loggedInUser = null;
    private static ArrayList<User> allUsers = new ArrayList<>();
    private String avatar;
    private int score;
    private int lostInDevilMode = 0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.avatar = "src/main/resources/avatars/avatar" + (allUsers.size() % 4 + 1) + ".png";
        allUsers.add(this);
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void deleteLoggedInUser() {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).username.equals(loggedInUser.getUsername())) {
                allUsers.remove(i);
                break;
            }
        }
        loggedInUser = null;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        User.allUsers = allUsers;
    }

    public static User getUserByUsername(String username) {
        for (User allUser : allUsers) {
            if (allUser.getUsername().equals(username))
                return allUser;
        }
        return null;
    }

    public static boolean checkPassword(String username, String password) {
        if (getUserByUsername(username).password.equals(password))
            return true;
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public int compareTo(Object o) {
        User other = (User) o;
        if (this.score > other.score)
            return -1;
        if (this.score < other.score)
            return 1;
        return 0;
    }

    public int getLostInDevilMode() {
        return lostInDevilMode;
    }

    public void setLostInDevilMode(int lostInDevilMode) {
        this.lostInDevilMode = lostInDevilMode;
    }
}

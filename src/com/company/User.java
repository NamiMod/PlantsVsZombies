package com.company;
import java.io.Serializable;

/**
 *  -- User --
 *
 * in this class we keep players data and work with them
 *
 * project : Plants Vs Zombies
 * AP Final Project
 *
 * ###############################
 * @author Seyed Nami Modarressi #
 * @author Mahdi Rahmani         #
 * @since 2020                   #
 * @version 1.0                  #
 * ###############################
 *
 *
 */
public class User implements Serializable {

    private String username;
    private String password;
    private int score;
    private int win;
    private int lose;
    private int normalGames;
    private int hardGames;

    /**
     * create new user
     * @param username username of player
     * @param password password of player
     */
    public User(String username , String password) {
        this.username = username;
        this.password = password;
        score = 0;
        win = 0;
        lose = 0;
        normalGames = 0;
        hardGames = 0;
    }

    /**
     * @return username of player
     */
    public String getUsername() {
        return username;
    }
    /**
     * @return password of player
     */
    public String getPassword() {
        return password;
    }
    /**
     * @return score of player
     */
    public int getScore() {
        return score;
    }
    /**
     * @return win number of player
     */
    public int getWin() {
        return win;
    }
    /**
     * @return lose number of player
     */
    public int getLose() {
        return lose;
    }
    /**
     * @return normal games counter of player
     */
    public int getNormalGames() {
        return normalGames;
    }
    /**
     * @return hard games counter of player
     */
    public int getHardGames() {
        return hardGames;
    }
    /**
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * @param score new score
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * @param win new win counter
     */
    public void setWin(int win) {
        this.win = win;
    }
    /**
     * @param lose new lose counter
     */
    public void setLose(int lose) {
        this.lose = lose;
    }
    /**
     * @param normalGames new normal games counter
     */
    public void setNormalGames(int normalGames) {
        this.normalGames = normalGames;
    }
    /**
     * @param hardGames new hard games counter
     */
    public void setHardGames(int hardGames) {
        this.hardGames = hardGames;
    }
    /**
     * @return information of user
     */
    @Override
    public String toString(){
        return (username+"                       "+score+"       "+win+"       "+lose+"       "+normalGames+"      "+hardGames+"\n");
    }

}

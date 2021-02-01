package com.company;
/**
 *  -- Game Settings--
 *
 * in this class we have information for game like normal/hard mode or sound condition
 * we save settings in this class
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
public class GameSetting {

    private int sound;
    private int mode;
    private String username;
    private String password;

    // ToDo : change the values of parameters of game related to Normal or Hard mode

    private int[] zombieSpeed;
    private int[] zombieAttackPower;
    private int skySunTime;
    private int sunFlowerProducingSunTime;
    /**
     *
     * create new information
     *
     * sound :    0 -> on        1 -> off
     * mode  :    0 -> Normal    1-> Hard
     */
    public GameSetting(){
        username = null;
        password = null;
        sound = 0;
        mode = 0;

        zombieSpeed = new int[3];
        zombieAttackPower = new int[3];
        setNormalState();
    }

    /**
     * @return mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @return sound mode
     */
    public int getSound() {
        return sound;
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
     * set mode for setting
     */
    public void setMode(int mode) {
        this.mode = mode;
    }
    /**
     * set sound mode for setting
     */
    public void setSound(int sound) {
        this.sound = sound;
    }
    /**
     * set username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * set password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get the time that we need to produce sun in the sky
     * @return sky sun time
     */
    public int getSkySunTime() {
        return skySunTime;
    }

    /**
     * get the power of destroying for each zombie
     * @return zombieAttackPower
     */
    public int[] getZombieAttackPower() {
        return zombieAttackPower;
    }

    /**
     * get the speed of zombie
     * @return zombieSpeed
     */
    public int[] getZombieSpeed() {
        return zombieSpeed;
    }

    /**
     * get the time that we need for producing sun with flower
     * @return sunFlowerProducingSunTime
     */
    public int getSunFlowerProducingSunTime() {
        return sunFlowerProducingSunTime;
    }

    /**
     * set the normal state
     */
    public void setNormalState()
    {
        zombieSpeed = new int[]{2, 2, 2};
        zombieAttackPower = new int[]{5,10,20};
        skySunTime = 25000;
        sunFlowerProducingSunTime = 20000;
    }

    // ToDo : must be edited
    /**
     * set the Hard state
     */
    public void setHArdState()
    {
        zombieSpeed = new int[]{2, 2, 2};
        zombieAttackPower = new int[]{5,10,20};
        skySunTime = 25000;
        sunFlowerProducingSunTime = 20000;
    }

    /**
     * if the user choose normal mode or hard mode we can change the game
     * by initializing some variables by this method
     */
    public void NormalHardInit(){
        if (mode == 0)
            setNormalState();
        else
            setHArdState();
    }

}

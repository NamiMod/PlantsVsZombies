package com.company;

import java.util.ArrayList;

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

    //The zombie speeds (1:normal zombie; 2:conHead zombie; 3:bucketHead zombie)
    private int[] zombieSpeed;

    //The zombie attack powers (1:normal zombie; 2:conHead zombie; 3:bucketHead zombie)
    private int[] zombieAttackPower;

    //the time for producing sun in the sky
    private int skySunTime;

    //the time for producing sun with sun flower
    private int sunFlowerProducingSunTime;

    //the time for charging a card again(1:sunFlower ; 2:WallNut ; 3:PeaShooter ; 4:SnowPeaShooter ; 5:Repeater ; 6:Mushroom ; 7:CherryBomb)
    private int[] chargingCardTime;

    //the list of cards that user choose
    private ArrayList<String> cardNames;

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
        cardNames = new ArrayList<>();
        setNormalState();
        setCardNames(null);
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
     * get the time for charging a card
     * @return chargingCardTime
     */
    public int[] getChargingCardTime() {
        return chargingCardTime;
    }

    public ArrayList<String> getCardNames() {
        return cardNames;
    }

    public void setCardNames(ArrayList<String> cardNames) {
        ArrayList<String> defaultCard = new ArrayList<>();
        this.cardNames.clear();
        if(cardNames == null)
        {
            defaultCard.add("SunFlower");
            defaultCard.add("WallNut");
            defaultCard.add("PeaShooter");
            defaultCard.add("SnowPeaShooter");
            defaultCard.add("Mushroom");
            defaultCard.add("CherryBomb");
            this.cardNames = defaultCard;
        }
        else
            this.cardNames = cardNames;
    }

    /**
     * set the normal state
     */
    public void setNormalState()
    {
        zombieSpeed = new int[]{2, 2, 2 , 2};
        zombieAttackPower = new int[]{5,10,20,15};
        skySunTime = 25000;
        sunFlowerProducingSunTime = 20000;
        chargingCardTime = new int[]{7500,30000,7500,7500,7500,10000,7500,7000};

    }

    // ToDo : must be edited
    /**
     * set the Hard state
     */
    public void setHArdState()
    {
        zombieSpeed = new int[]{2, 3, 3 , 3};
        zombieAttackPower = new int[]{5,15,25,20};
        skySunTime = 30000;
        sunFlowerProducingSunTime = 25000;
        chargingCardTime = new int[]{7500,30000,7500,30000,30000,20000,15000,12000};
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

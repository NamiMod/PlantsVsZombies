package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is Zombie class. this class extends Character
 * The different types of Zombies such as ConeZombie ,... extends this class.
 * The speed filed contains the speed and the attackPower contains the ability of destroying of each zombie
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class Zombie extends Character{
    //The attackPower of zombie
    private int attackPower;
    //Enum for defining the states of a zombie
    enum ZombieState {
        WALKING,
        JUMPING,
        CHEWING,
        DESTROYING,
        SHOOTING
    }
    //The state of zombie
    private ZombieState zombieState;
    //The timer for chewing
    private Timer chewTimer;
    //The chew timer task
    private TimerTask chewTimerTask ;
    //This variable saves if any frozen pea impact to the zombie(to change the speed later)
    private boolean isFrozen;
    //A field for creat unfreeze class(inner class)
    private UnFreeze unfreeze ;
    //the timer of freezing
    private Timer freezeTimer ;
    //This variable tell us for example is the cone head zombie change to normal zombie or not for one time
    private boolean isChanged;
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     *
     * @param position    the x&y coordinates
     * @param HP          The health point
     * @param speed       The speed of zombie
     * @param attackPower The ability of destroying
     * @param elementPath the path of element gif or image
     */
    public Zombie(int[] position, int HP , int speed , int attackPower , String elementPath , GameState gameState) {
        super(position, HP, elementPath,gameState,80 , 85 , speed);
        this.attackPower = attackPower;
        zombieState = ZombieState.WALKING;
        chewTimer = new Timer();
        chewTimerTask = null;
        isFrozen = false;
        unfreeze = null;
        freezeTimer = new Timer();
        isChanged = false;
    }

    /**
     * get the attack power of zombie
     * @return attack power
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * set the state of a zombie
     * @param zombieState the state of zombie
     */
    public void setZombieState(ZombieState zombieState) {
        this.zombieState = zombieState;
    }

    /**
     * get the zombie state
     * @return zombie state
     */
    public ZombieState getZombieState() {
        return zombieState;
    }


    /**
     * This method control the algorithm of a zombie in game
     * we change his state and update it with this method
     */
    @Override
     public void update() {
        // we check if the Hp of two types of zombies is less than 200 then we should change them to normal zombie
        if (this instanceof BucketHeadZombie || this instanceof ConeHeadZombie)
        {
            if (getHp() <= 200 && !isChanged) {
                setElementPath("normalzombie.gif");
                Image image = Main.loadImage(getElementPath());
                setImage(image);
                isChanged = true;
                System.out.println("zombie is changed to normal zombie");
            }
        }
        if (zombieState == ZombieState.WALKING)
        {
            // Walking
            move();
            // checking if the zombie arrive to the home player is game over
            if (getPosition()[0] <= 230) {
                getGameState().setGameOver(true);
            }
            // check if the zombie arrive to a plant he should chews that
            Plant coincidence = getCollidedPlant();
            if (coincidence != null) {
                zombieState = ZombieState.CHEWING;
                chewTimerTask = new TimerTask() {
                        @Override
                        public void run() {
                            coincidence.hurt(attackPower);
                        }
                    };
                chewTimer.schedule(chewTimerTask, 0L, 500L);
            }
        }
        //We check if the plant destroyed completely change the state of zombie
        else if(zombieState == ZombieState.CHEWING) {
            // Chewing
            Plant coincidence = getCollidedPlant();
            if (coincidence == null) {
                playSound();
                zombieState = ZombieState.WALKING;
                chewTimerTask.cancel();
                chewTimerTask = null;
                chewTimer.purge();
            }
        }
    }

    /**
     * If the zombie is hit with a Frozen Pea:
     * we should change the speed
     * also we set isFrozen true(because in the first time the speed changes only)
     */
    public void hitWithFrozenPea(){
        if (unfreeze != null)
            unfreeze.cancel();
        freezeTimer.purge();
        unfreeze = new UnFreeze();

        if (!isFrozen) {
            setSpeed(getSpeed() / 2);
        }
        isFrozen = true;
        freezeTimer.schedule(unfreeze, 8000);
    }

    /**
     * after a while the zombie should back to his normal state
     */
    private class UnFreeze extends TimerTask {
        @Override
        public void run() {
            setSpeed(getSpeed() * 2);
            isFrozen = false;
        }
    }


    /**
     * this method is used for removing object
     */
    @Override
    public void remove() {
        super.remove();
        if (chewTimerTask != null)
            chewTimerTask.cancel();
        if (unfreeze != null)
            unfreeze.cancel();
        getGameState().setDeadZombies(getGameState().getDeadZombies() + 1);
        System.out.println(getGameState().getDeadZombies());
    }

    /**
     * Sound for eating plants !!!
     */
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/chomp.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void roastZombie() {
    }

    public void checkReachedHouse() {

    }

    public void moveZombie() {

    }

    public void eatPlant() {

    }
}

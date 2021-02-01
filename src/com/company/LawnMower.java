package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * This is Lawn Mower class
 * in this class we hold the information related to Lawn mower
 * when the zombies arrive to home for the first time the lawn mover kills them
 *
 * @author Mahdi Rhamani
 * @version 1.0
 */
public class LawnMower extends Character{
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     * the speed of lawn mower first must be 0 . after the arriving of first zombie must be changed
     * Then the speed of lawn mower is -10(because go to the left of the yard)
     * @param position    the x&y coordinates
     * @param gameState   the game state
     */
    public LawnMower(int[] position, GameState gameState) {
        super(position, 100, "Lawn_Mower.png", gameState, 65, 80 , 0);
    }

    /**
     * This is an overridden method of element class
     * when the lawn mower impacts to the zombies in a row must kill them
     * so for this purpose we call hurt method and change the Hp
     */
    @Override
    public void update() {
        super.update();
        Zombie collidedZombie = getDestroyedZombie();
        if (collidedZombie != null ){
            playSound();
            collidedZombie.hurt(collidedZombie.getHp());
            setSpeed(-5);
        }
    }
    /**
     * Sound for lamborghini !!!
     */
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/lamborghini.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}

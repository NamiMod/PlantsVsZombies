package com.company;

/**
 * This is Beetroot class.its a kind of Shooter plants.
 * It handles the works related to This type of shooter plant.
 * It extends shooter class.
 * This plant throw suitable bullet for killing zombies
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Beetroot extends Shooter{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position    the x & y coordinates
     * @param gameState   the game state
     */
    public Beetroot(int[] position, GameState gameState) {
        super(position,  125, 80 ,"beetroot.gif", gameState);
    }
    /**
     * If the zombies are coming across this type of plant we call this method to do the best action
     * It creates bullet for killing zombies
     * This plant create beetBullet
     */
    @Override
    public void action() {
        throwBullet();
    }
}

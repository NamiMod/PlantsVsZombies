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
     * @param cost        the cost of this plant
     * @param HP          The health point
     * @param elementPath the path of element gif or image
     * @param gameState
     */
    public Beetroot(int[] position, int cost, int HP, String elementPath, GameState gameState) {
        super(position, cost, HP, elementPath, gameState);
    }
}

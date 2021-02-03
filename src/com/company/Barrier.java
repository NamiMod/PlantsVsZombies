package com.company;
/**
 * This is Barrier class.its a kind of  plants.
 * It handles the works related to This type of Plant
 * It extends Plant class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Barrier extends Plant{

    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position    the x & y coordinates
     * @param cost        the cost of this plant
     * @param HP          The health point
     * @param elementPath the path of element gif or image
     * @param gameState   the state of the game
     */
    public Barrier(int[] position, int cost, int HP, String elementPath, GameState gameState) {
        super(position, cost, HP, elementPath, gameState);
    }

}

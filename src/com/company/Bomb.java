package com.company;
/**
 * This is a Bomb class.its a kind of  plants.
 * It handles the works related to This type of Plant
 * It extends Plant class.
 * This type of plants destroying zombies by blasting
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Bomb extends Plant{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position    the x & y coordinates
     * @param cost        the cost of this plant
     * @param HP          The health point
     * @param elementPath the path of element gif or image
     */
    public Bomb(int[] position, int cost, int HP, String elementPath) {
        super(position, cost, HP, elementPath);
    }
}

package com.company;
/**
 * This is CherryBomb class.its a kind of Bomb plants.
 * It handles the works related to This type of Bomb plant.
 * It extends Bomb class.
 * This plant can be blasted and prevent zombies from arriving to destination.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class CherryBomb extends Bomb{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position
     *
     * @param position    the x & y coordinates
     */
    public CherryBomb(int[] position) {
        super(position, 150, 70, "elementPath");
    }
}

package com.company;
/**
 * This is Jalapeno class.its a kind of Bomb plants.
 * It handles the works related to This type of Bomb plant.
 * It extends Bomb class.
 * This plant can be blasted and prevent zombies from arriving to destination.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Jalapeno extends Bomb{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position
     *
     * @param position the x & y coordinates
     */
    public Jalapeno(int[] position) {
        super(position, 200, 100, "elementPath");
    }
}

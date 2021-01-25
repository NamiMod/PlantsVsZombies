package com.company;
/**
 * This is WallNut class.its a kind of Barrier plants.
 * It handles the works related to This type of Barrier
 * It extends Barrier class.
 * This plant prevents zombies to arrive to their destination.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class WallNut extends Barrier{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position the x & y coordinates
     */
    public WallNut(int[] position) {
        super(position, 50, 150, "elementPath");
    }
}

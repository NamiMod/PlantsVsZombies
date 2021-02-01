package com.company;

/**
 * This is Pea class.
 * Pea is one type of our bullets.
 * This class extends Bullet class.
 * The image path of this object and its damage are mentioned in the constructor of this class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Pea extends Bullet{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position the x & y coordinates
     */
    public Pea(int[] position , GameState gameState) {
        super(position, 1 ,"pea.png",30 , gameState);
    }
}

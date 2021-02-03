package com.company;

/**
 * This is BeetBullet class.
 * BeetBullet is one type of our bullets.
 * This class extends Bullet class.
 * The image path of this object and its damage are mentioned in the constructor of this class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class BeetBullet extends Bullet{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     * The speed of each bullet is constant and equal to -6(because go to left)
     *
     * @param position    the x & y coordinates
     * @param gameState   the game state
     */
    public BeetBullet(int[] position, GameState gameState) {
        super(position, 1 ,"beetbullet.png",40 , gameState);
    }
}

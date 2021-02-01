package com.company;
/**
 * This is Mushroom class.
 * Mushroom is one type of our bullets.
 * This class extends Bullet class.
 * The image path of this object and its damage are mentioned in the constructor of this class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class MushroomBullet extends Bullet{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position    the x & y coordinates
     * @param gameState   the game state
     */
    public MushroomBullet(int[] position, GameState gameState) {
        super(position, 1, "tuff.png", 20, gameState);
    }
}

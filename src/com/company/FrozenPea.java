package com.company;
/**
 * This is FrozenPea class.
 * FrozenPea is one type of our bullets.
 * This class extends Bullet class.
 * The image path of this object and its damage are mentioned in the constructor of this class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class FrozenPea extends Bullet{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position the x & y coordinates
     */
    public FrozenPea(int[] position , GameState gameState) {
        super(position, 1 ,"freezepea.png",35 , gameState);
    }

    @Override
    public void update() {
        super.update();
        Zombie zombie = getDestroyedZombie();
        if (zombie != null ) {
            zombie.hitWithFrozenPea();
        }
    }
}

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
    public CherryBomb(int[] position ,GameState gameState) {
        super(position, 150, 70, "newCherryBomb.gif",gameState);
    }

    /**
     * we define the work that this plant must do
     * the cherry bomb should blast after we plant it
     * for this we should call the blasting method of Bomb class
     */
    @Override
    public void action() {
        super.action();
        blasting(100);
    }
}

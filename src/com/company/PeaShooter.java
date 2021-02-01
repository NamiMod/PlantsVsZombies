package com.company;
/**
 * This is PeaShooter class.its a kind of shooter plants.
 * It handles the works related to This type of shooterPlant
 * It extends Shooter class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class PeaShooter extends Shooter{
    /**
     * This is the constructor of this class
     * It creates a new PeaShooter with a given position
     * @param position the x & y coordinates
     */
    public PeaShooter(int[] position , GameState gameState ){
        super(position, 100, 70 ,"peashooter.gif",gameState);
    }

    /**
     * If the zombies are coming across this type of plant we call this method to do the best action
     * It creates bullet for killing zombies
     * This plant create FrozenPea bullet.
     */
    @Override
    public void action() {
        super.action();
       /* int[] bulletFirstPos = new int[2];
        bulletFirstPos[0] = getPosition()[0] + 20;
        bulletFirstPos[1] = getPosition()[1] + 10;
        Pea pea = new Pea(bulletFirstPos, getGameState());*/
        throwBullet();

    }
}

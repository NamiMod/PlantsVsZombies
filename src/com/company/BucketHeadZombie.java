package com.company;
/**
 * This is BucketHeadZombie class. this class extends Zombie class
 * It handles the works related to This type of Zombie
 * This Zombie has a bucket on his head and stronger than ConeHeadZombie and NormalZombie.
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class BucketHeadZombie extends Zombie{
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     *
     * @param position    the x&y coordinates
     * @param speed       The speed of zombie
     * @param attackPower The ability of destroying
     * @param gameState   the state of the game
     *                    Buckethead-Zombie.gif
     *                    bucketheadzombie.gif
     */
    public BucketHeadZombie(int[] position, int speed, int attackPower , GameState gameState) {
        super(position, 1300, speed, attackPower, " bucketheadzombie.gif" , gameState);
    }
}

package com.company;
/**
 * This is ConeHeadZombie class. this class extends Zombie class
 * It handles the works related to This type of Zombie
 * This Zombie has a cone on his head and stronger than NormalZombie.
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class ConeHeadZombie extends Zombie{
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     *
     * @param position    the x&y coordinates
     * @param speed       The speed of zombie
     * @param attackPower The ability of destroying
     */
    public ConeHeadZombie(int[] position, int speed, int attackPower , GameState gameState) {
        super(position, 560, speed, attackPower, "coneheadzombie.gif" , gameState);
    }
}

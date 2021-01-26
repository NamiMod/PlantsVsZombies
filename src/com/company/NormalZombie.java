package com.company;
/**
 * This is NormalZombie class. this class extends Zombie class
 * It handles the works related to This type of Zombie
 * This Zombie is the weakest Zombie.
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class NormalZombie extends Zombie{
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     *
     * @param position    the x&y coordinates
     * @param speed       The speed of zombie
     * @param attackPower The ability of destroying
     */
    public NormalZombie(int[] position, int speed, int attackPower) {
        super(position, 200, speed, attackPower, "elementPath");
    }
}

package com.company;
/**
 * This is FootBallPlayerZombie class. this class extends Zombie class
 * It handles the works related to This type of Zombie
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class FootBallPlayerZombie extends Zombie{
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     *
     * @param position    the x&y coordinates
     * @param speed       The speed of zombie
     * @param attackPower The ability of destroying
     * @param gameState   the game state
     */
    public FootBallPlayerZombie(int[] position, int speed, int attackPower ,GameState gameState) {
        super(position, 320, speed, attackPower, "zombie_football.gif" , gameState);
    }
}

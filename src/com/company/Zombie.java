package com.company;
/**
 * This is Zombie class. this class extends Character
 * The different types of Zombies such as ConeZombie ,... extends this class.
 * The speed filed contains the speed and the attackPower contains the ability of destroying of each zombie
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class Zombie extends Character{
    //The speed of zombie
    private int speed;
    //The attackPower of zombie
    private int attackPower;
    /**
     * This is constructor of this class
     * It calls the constructor of superclass and pass the needed argument as an entry
     * If we call this create a new Character class
     *
     * @param position    the x&y coordinates
     * @param HP          The health point
     * @param speed       The speed of zombie
     * @param attackPower The ability of destroying
     * @param elementPath the path of element gif or image
     */
    public Zombie(int[] position, int HP , int speed , int attackPower , String elementPath) {
        super(position, HP, elementPath);
        this.speed = speed;
        this.attackPower = attackPower;
    }

    /**
     * get the attack power of zombie
     * @return attack power
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * get the speed of zombie
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    public void roastZombie() {
    }

    public void checkReachedHouse() {

    }

    public void moveZombie() {

    }

    public void eatPlant() {

    }
}

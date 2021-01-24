package com.company;

/**
 * This is character class. this class extends Elements
 * Also Zombie Class and Plant class extends from this class
 * Hp field means healthPoint and show the life of plants and zombies
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class Character extends Elements{
    // The health point field
    private int Hp;

    /**
     * This is constructor of this class
     *  It calls the constructor of superclass and pass the needed argument as an entry
     *  If we call this create a new Character class
     * @param position the x&y coordination
     */
    public Character(int[] position){
        super(position);
    }

    /**
     * get the health point of element
     * @return Hp
     */
    public int getHp() {
        return Hp;
    }

    /**
     * set the health point of element
     * @param hp Health point
     */
    public void setHp(int hp) {
        Hp = hp;
    }
}

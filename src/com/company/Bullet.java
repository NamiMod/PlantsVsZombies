package com.company;

/**
 * This is Bullet class.
 * It handles the works related to Bullet such as moving ,...
 * The Pea class & FrozenPea class extends this class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Bullet extends Elements{
    //The level of damage that each bullet has
    private int damage;
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position the x & y coordinates
     * @param elementPath the path of element gif or image
     */
    public Bullet(int[] position, String elementPath , int damage) {
        super(position, elementPath);
        this.damage = damage;
    }

    /**
     * This method controls the moving of bullet
     * it moves until it impacts to the zombie
     * Also we know the bullet only can move in horizontal direction
     */
    public void move(){
        /*
        if(this.getPosition()[0] <= zombie.getPosition()[0])
        {
            int[] newPos = getPosition();
            newPos[0] += 1;
            setPosition(newPos);
        }*/
    }

    /**
     * get the damage level of the bullet
     * @return the damage level
     */
    public int getDamage() {
        return damage;
    }
}

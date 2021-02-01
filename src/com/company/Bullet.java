package com.company;

/**
 * This is Bullet class.
 * It handles the works related to Bullet such as moving ,...
 * The Pea class & FrozenPea class extends this class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Bullet extends Character{
    //The level of damage that each bullet has
    private int damage;
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     * The speed of each bullet is constant and equal to -6(because go to left)
     * @param position the x & y coordinates
     * @param elementPath the path of element gif or image
     */
    public Bullet(int[] position,int Hp, String elementPath , int damage , GameState gameState) {
        super(position,Hp, elementPath , gameState ,30 ,30 ,-6);
        this.damage = damage;
    }


    /**
     * get the damage level of the bullet
     * @return the damage level
     */
    public int getDamage() {
        return damage;
    }

    /**
     * an override method of Element class
     * first we should find the zombie in the bullet position
     * if there is any zombie we should hurt him and then the bullet must be disappeared(assign 0 value to Hp)
     */

    @Override
    public void update() {
        super.update();
        Zombie zombie = getDestroyedZombie();
        if (zombie != null ) {
            zombie.hurt(damage);
            setHp(0);
        }
    }

}

package com.company;
/**
 * This is Repeater class.its a kind of shooter plants.
 * It handles the works related to This type of shooterPlant
 * It extends Shooter class.
 * This plant creat double bullet
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Repeater extends Shooter{

    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position
     *
     * @param position    the x & y coordinates
     */
    public Repeater(int[] position) {
        super(position, 150, 90, "elementPath");
    }

    /**
     * If the zombies are coming across this type of plant we call this method
     * It creates bullet for killing zombies
     * This plant create double Pea bullet.
     */
    @Override
    public void throwBullet() {
        super.throwBullet();
        int[] bulletFirstPos = this.getPosition();
        bulletFirstPos[1] += 4;
        Bullet b = new FrozenPea(bulletFirstPos);
    }
}

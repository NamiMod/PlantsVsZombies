package com.company;
/**
 * This is SnowPeaShooter class.its a kind of shooter plants.
 * It handles the works related to This type of snowShooterPlant
 * It extends Shooter class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class SnowPeaShooter extends Shooter{
    /**
     * This is the constructor of this class
     * It creates a new SnowPeaShooter with a given position
     * @param position the x & y coordinates
     */
    public SnowPeaShooter(int[] position) {
        super(position, 175, 100 ,"snowPeaShooter.gif");
    }
    /**
     * If the zombies are coming across this type of plant we call this method
     * It creates bullet for killing zombies
     * This plant create FrozenPea bullet.
     */
    @Override
    public void throwBullet() {
        super.throwBullet();
        int[] bulletFirstPos = this.getPosition();
        bulletFirstPos[1] += 4;
        Bullet b = new FrozenPea(bulletFirstPos);
    }
}

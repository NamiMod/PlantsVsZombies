package com.company;

import java.util.Timer;

/**
 * This is Plant class. this class extends Character
 * The different types of plants such as ShooterPlant ,... extends this class.
 * The cost fields means that the number of suns that we need to use this type of plant.
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class Plant extends Character{
    // The cost(number of needed sun)
    private int cost;
    //The timer for action
    private Timer timer ;

    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     * The speed of each plant is 0 and dont move
     * @param position the x & y coordinates
     * @param cost the cost of this plant
     * @param HP The health point
     * @param elementPath the path of element gif or image
     */
    public Plant(int[] position ,int cost , int HP , String elementPath,GameState gameState)
    {
        super(position ,HP, elementPath , gameState , 75 , 80 ,0);
        this.cost = cost;
        timer = new Timer();
    }

    /**
     * get the cost of plant
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * get the timer that we want for our action
     * @return timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * this section of remove method cancel the timer
     * So the work is done in that time should be stopped
     */
    @Override
    public void remove() {
        super.remove();
        timer.cancel();
    }

}

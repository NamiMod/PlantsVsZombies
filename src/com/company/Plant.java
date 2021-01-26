package com.company;

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

    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     * @param position the x & y coordinates
     * @param cost the cost of this plant
     * @param HP The health point
     * @param elementPath the path of element gif or image
     */
    public Plant(int[] position ,int cost , int HP , String elementPath)
    {
        super(position ,HP, elementPath);
        this.cost = cost;
    }

    /**
     * get the cost of plant
     * @return cost
     */
    public int getCost() {
        return cost;
    }
}

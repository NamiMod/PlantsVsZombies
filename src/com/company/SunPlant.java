package com.company;
/**
 * This is SunPlant class.its a kind of  plants.
 * It handles the works related to This type of Plant
 * It extends Plant class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class SunPlant extends Plant{
    //The needed time for producing a sun
    private int sunProducingTime;

    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath , sunProducingTime
     * @param position the x & y coordinates
     * @param cost the cost of this plant
     * @param HP The health point
     * @param elementPath the path of element gif or image
     * @param sunProducingTime The needed time for producing a sun
     */
    public SunPlant(int[] position, int cost, int HP, String elementPath , int sunProducingTime) {
        super(position, cost, HP , elementPath);
        this.sunProducingTime = sunProducingTime;
    }

    /**
     * get the time needed for producing time
     * @return sunProducingTime
     */
    public int getSunProducingTime() {
        return sunProducingTime;
    }
}

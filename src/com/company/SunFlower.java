package com.company;
/**
 * This is SunFlower class.its a kind of sun plants.
 * It handles the works related to This type of sunPlant
 * It extends SunPlant class.
 * This flower can produce sun and player can get it to use more plants.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class SunFlower extends SunPlant{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , sunProducingTime
     *
     * @param position         The x & y coordinates
     * @param sunProducingTime The needed time for producing a sun
     */
    public SunFlower(int[] position , int sunProducingTime) {
        super(position, 50, 50, "elementPath", sunProducingTime);
    }

    /**
     * This method is using for producing sun.
     */
    public void produceSun()
    {

    }
}

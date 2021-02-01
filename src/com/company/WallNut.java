package com.company;

import java.awt.*;

/**
 * This is WallNut class.its a kind of Barrier plants.
 * It handles the works related to This type of Barrier
 * It extends Barrier class.
 * This plant prevents zombies to arrive to their destination.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class WallNut extends Barrier{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position the x & y coordinates
     */
    public WallNut(int[] position ,GameState gameState) {
        super(position, 50, 150, "walnut_full_life.gif", gameState);
    }

    @Override
    public void update() {
        super.update();
        if (getHp()<75){
            setElementPath("walnut_half_life.gif");
            Image image = Main.loadImage(getElementPath());
            setImage(image);
        }
    }
}

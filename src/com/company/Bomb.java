package com.company;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This is a Bomb class.its a kind of  plants.
 * It handles the works related to This type of Plant
 * It extends Plant class.
 * This type of plants destroying zombies by blasting
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Bomb extends Plant{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position    the x & y coordinates
     * @param cost        the cost of this plant
     * @param HP          The health point
     * @param elementPath the path of element gif or image
     * @param gameState   the state of the game
     */
    public Bomb(int[] position, int cost, int HP, String elementPath ,GameState gameState) {
        super(position, cost, HP, elementPath , gameState);
    }

    /**
     * This is blasting method
     * if this type of plant wants to blast we should call this method
     * we should give an explosionRadius as an entry
     * the zombies which are in this radius must be died completely
     * also The Hp of plant must be 0
     * @param explosionRadius the radius of explosion
     */
    public void blasting(int explosionRadius)
    {
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {

                for (Elements elements : getGameState().getElements()) {
                    if (elements instanceof Zombie) {
                        int distance = (int) Math.sqrt(Math.pow((elements.getPosition()[0] - getPosition()[0]), 2) + Math.pow((elements.getPosition()[1] - getPosition()[1]), 2));
                        if (distance <= explosionRadius) {
                            ((Zombie) elements).hurt(((Zombie) elements).getHp());
                        }
                    }
                }

                setHp(0);
            }

        };
        getTimer().schedule(Task, 2000);
    }
}

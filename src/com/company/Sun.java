package com.company;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This is sun class
 * it holds the information related to sun
 * we can produce new sun with this class
 * the sun is produced in the sky or with sun flowers
 *
 * @author Mahdi Rhamani & Nami Modarresi
 * @version 1.0
 */
public class Sun extends Elements{
    //This enum is used for the states that a plant has
    private enum SunState{
        FALLING,
        STANDING
    }
    //The states of sun
    private SunState sunState;
    //The destination of sun
    private int destination;

    /**
     * This is the first constructor of this class
     * create a new Element with a given position
     * we produce sun of sun flower with this
     *
     * @param position    the x&y coordinates
     * @param gameState   the game state
     */
    public Sun(int[] position, GameState gameState) {
        super(position, "sun.gif", gameState, 50, 50);
        sunState = SunState.FALLING;
        destination = position[1];
    }

    /**
     * This is the second constructor of this class
     * create a new Element with a given position
     * we produce sun of sky with this
     *
     * @param mapCell   the map cell that the sun is going to placed
     * @param gameState the game state
     */
    public Sun(MapCell mapCell, GameState gameState) {
        super(new int[]{mapCell.getPosition()[0],-3}, "sun.gif",gameState, 70, 70);
        destination = mapCell.getPosition()[1];
    }

    /**
     * get the state of sun
     * @return sun state
     */
    public SunState getSunState() {
        return sunState;
    }

    /**
     * This method drawing the Sun
     * @param g2d Graphic variable
     */
    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (getPosition()[1] < destination) {
            int[] newPos = getPosition();
            newPos[1] += 1;
            setPosition(newPos);
        }
        else if (sunState == SunState.FALLING)
        {
            sunState = SunState.STANDING;
            Timer selfDisappearingTimer = new Timer();
            TimerTask selfDisappearingTask = new TimerTask() {
                @Override
                public void run() {
                    selfDestruction();
                }
            };

            selfDisappearingTimer.schedule(selfDisappearingTask, 5000L);
        }
    }
    /**
     * This is an overridden method of Elements class
     * when clicking on the suns , you may collect sun power for the plants
     */
    @Override
    public void clickAction() {
        super.clickAction();
        getGameState().setMoney(getGameState().getMoney() + 25);
    }

}

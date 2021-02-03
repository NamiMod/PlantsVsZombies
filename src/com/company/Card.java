package com.company;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 * This is Card class.its a kind of  elements.
 * It handles the works related to This type of element
 * It extends Element class.
 * each card has a value and if player has enough suns he can use that card
 * after plant a flower and use a specific card it must be unreachable for a while
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Card extends Elements{
    //The address of cursor image
    private String cursorImageAddress;

    //The Card value
    private int value;

    //The card is used recently or not
    private boolean isUsed;

    //The time duration for charging a card
    private int chargingTime;

    //this fields for changing the card image
    private boolean imageIsChanged;

    //the new state of card(for handling the using of cards)
    private boolean newState;

    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position    the x&y coordinates
     * @param elementPath the path of element gif or image
     * @param cursorImageAddress the path of card image
     * @param gameState   the game state
     * @param value       the card value
     * @param chargingTime the time needed for charging a card again
     */
    public Card(int[] position, String elementPath , String cursorImageAddress, GameState gameState , int value, int chargingTime) {
        super(position, elementPath, gameState, 45, 60);
        this.cursorImageAddress = cursorImageAddress;
        this.value = value;
        imageIsChanged = false;
        isUsed = false;
        this.chargingTime = chargingTime;
    }

    /**
     * this method set the value of isCharged field true
     * after the charging time duration
     */
    public void chargingAutomatically()
    {
        Timer chargingTimer = new Timer();
        TimerTask chargingTask = new TimerTask() {
            @Override
            public void run() {
                isUsed = false;
            }
        };
        chargingTimer.schedule(chargingTask, chargingTime);
    }

    /**
     * set the isUsed variable
     * @param used the boolean value
     */
    public void setUsed(boolean used) {
        isUsed = used;
    }

    /**
     * get the isUsed variable
     * @return isUsed
     */
    public boolean isUsed() {
        return isUsed;
    }

    /**
     * get the value of card
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * if you click on a card the image of cursor must be changed
     */
    @Override
    public void clickAction() {
        System.out.println(isUsed);
        if (getGameState().getMoney() >= getValue() && !isUsed) {
            Image image = Main.loadImage(cursorImageAddress);
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            getGameState().setCursor(defaultToolkit.createCustomCursor(image, new Point(0, 0), ""));
        }
    }

    /**
     * this method is used for handling the cards changes
     * @param fullCard the full charged card path
     * @param notChargedCard the not charged card path
     */
    public void changeCardImage(String fullCard,String notChargedCard){
        if (!isUsed)
        {
            if (getGameState().getMoney() >= value) {
                newState = true;
                if (newState && !imageIsChanged) {
                    Image image = Main.loadImage(fullCard);
                    setImage(image);
                    imageIsChanged = true;
                    System.out.println("The flower is charged");
                }
            } else {
                newState = false;
                if (!newState && imageIsChanged) {
                    Image image = Main.loadImage(notChargedCard);
                    setImage(image);
                    imageIsChanged = false;
                    System.out.println("The flower is uncharged");

                }

            }
        }
        else {
            Image image = Main.loadImage(notChargedCard);
            setImage(image);
            imageIsChanged = false;
        }
    }

    /**
     * this is an overridden method of element class
     * it updates this object
     */
    @Override
    public void update() {
        super.update();
    }
}

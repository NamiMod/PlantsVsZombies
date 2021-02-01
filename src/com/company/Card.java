package com.company;

import java.awt.*;

public class Card extends Elements{
    //The address of cursor image
    private String cursorImageAddress;
    //The Card value
    private int value;
    //The card is used recently or not
    private boolean isUsed;

    //this fields for changing the card image
    private boolean imageIsChanged;
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
     */
    public Card(int[] position, String elementPath , String cursorImageAddress, GameState gameState , int value) {
        super(position, elementPath, gameState, 45, 60);
        this.cursorImageAddress = cursorImageAddress;
        this.value = value;
        imageIsChanged = false;
        isUsed = false;
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
        if (getGameState().getMoney() >= getValue()) {
            Image image = Main.loadImage(cursorImageAddress);
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            getGameState().setCursor(defaultToolkit.createCustomCursor(image, new Point(0, 0), ""));
        }
    }

    public void changeCardImage(String fullCard,String notChargedCard){
        if (getGameState().getMoney() >= value)
        {
            newState = true;
            if(newState && !imageIsChanged)
            {
                Image image = Main.loadImage(fullCard);
                setImage(image);
                imageIsChanged = true;
                System.out.println("The flower is charged");
            }
        }
        else {
            newState = false;
            if(!newState && imageIsChanged)
            {
                Image image = Main.loadImage(notChargedCard);
                setImage(image);
                imageIsChanged = false;
                System.out.println("The flower is uncharged");

            }

        }
    }

    @Override
    public void update() {
        super.update();
    }
}

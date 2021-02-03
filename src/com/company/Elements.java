package com.company;

import java.awt.*;

/**
 * This is element class. the character class extends from this class
 * The position field contain the coordinates of each element
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class Elements {

    //The position field
    private int [] position;

    //The path of gif or image
    private String elementPath;

    //The game state of game
    private GameState gameState;

    //The width of the image or gif that we using
    private int width;

    //The height of the image or gif that we using
    private int height;

    //The Image or gif of the object
    private Image image;

    /**
     * This is the constructor of this class
     * create a new Element with a given position
     * @param position the x&y coordinates
     * @param elementPath the path of element gif or image
     * @param gameState the game state
     * @param width the width of object
     * @param height the height of object
     */
    public Elements(int[] position , String elementPath ,GameState gameState ,int width, int height)
    {
        this.position = position;
        this.elementPath = elementPath;
        this.gameState = gameState;
        this.width = width;
        this.height = height;

        image = Main.loadImage(elementPath);
    }

    /**
     * Set the position of element
     * @param position the x&y coordinates
     */
    public void setPosition(int[] position) {
        this.position = position;
    }

    /**
     * get the position of element
     * @return position
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * get the element path
     * @return element path
     */
    public String getElementPath() {
        return elementPath;
    }

    /**
     * set the new element path
     * @param elementPath The path of gif or image
     */
    public void setElementPath(String elementPath) {
        this.elementPath = elementPath;
    }

    /**
     * get the game state when we call it
     * @return gameState
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * get the height of the image or gif
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * get the width of image or gif
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * this method is overridden by subclasses
     * if we call this method it can update the element
     */
    public void update(){}

    /**
     * set the image or gif of the element
     * @param image the image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * This method draw the element with Graphics2D
     * @param g2d the graphic variable
     * @throws InterruptedException if there is any trouble to drawing image
     */
    public void draw(Graphics2D g2d) throws InterruptedException {
        g2d.drawImage(image, position[0], position[1], width, height, null);
    }

    /**
     * this method is used for any object that can disappear after a specific time
     */
    public void selfDestruction() {
        gameState.deleteElements(this);
    }

    /**
     * this method is overridden by subclasses
     * it checks if user click on something and do a suitable action
     */
    public void clickAction(){}

    /**
     * this method is overridden by subclasses
     */
    public void remove(){}
}

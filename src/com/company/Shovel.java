package com.company;

import java.awt.*;

/**
 * This is shovel class
 * it holds the information related to the shovel
 *
 * @author Mahdi Rahmani & Nami Modarressi
 * @version 1.0
 */
public class Shovel extends Elements{
    //The address of cursor image
    private String cursorImageAddress;
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position    the x&y coordinates
     * @param gameState   the game state
     */
    public Shovel(int[] position , GameState gameState) {
        super(position, "shovel.png", gameState, 60, 60);
        this.cursorImageAddress = "shovel.png";
    }

    /**
     * if click on the shovel it must be selected
     * the isShovelSelected field in gameState must be assigned true
     * Also if you click on a card the image of cursor must be changed
     */
    @Override
    public void clickAction() {
        super.clickAction();
        getGameState().setShovelSelected(true);
        Image image = Main.loadImage(cursorImageAddress);
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        getGameState().setCursor(defaultToolkit.createCustomCursor(image, new Point(0, 0), ""));
    }


}

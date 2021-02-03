package com.company;
/**
 * This is Game Menu Button class.
 *
 * in this class we create new button to show menu
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */

/**
 * creating the button of the menu in the gameFrame
 */

public class GameMenuButton extends Elements {

    private GameState state;
    private GameFrame game;

    /**
     * menuButton constructor
     * @param pos position
     * @param width width
     * @param height height
     * @param gameState game state
     */
    GameMenuButton(int[] pos, int width, int height, GameState gameState) {
        super(pos, "menu.jpg", gameState , width, height);
        this.state=gameState;
    }

    /**
     * opens the select menu by being clicked
     */
    public void clickAction() {
        new GameMenu(state);
    }
}

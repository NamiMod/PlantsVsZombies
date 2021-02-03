package com.company;

import javax.swing.*;

/**
 * creating the button of the menu in the gameFrame
 */

public class GameMenuButton extends Elements {

    private GameState state;
    private GameFrame game;

    /**
     * menuButton constructor
     * @param pos
     * @param width
     * @param height
     * @param gameState
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

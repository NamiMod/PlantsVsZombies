package com.company;

/**
 * creating the button of the menu in the gameFrame
 */

class GameMenuButton extends Elements {
    /**
     * menuButton constructor
     * @param pos
     * @param width
     * @param height
     * @param gameState
     */

    GameMenuButton(int[] pos, int width, int height, GameState gameState) {
        super(pos, "menu.jpg", gameState , width, height);
    }

    /**
     * opens the select menu by being clicked
     */
    public void clickAction() {
        new GameMenu();
    }
}

package com.company;

public class MushroomCard extends Card{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position    the x&y coordinates
     * @param gameState   the game state
     */
    public MushroomCard(int[] position, GameState gameState) {
        super(position, "cards/mushroompicker.png", "cards/mushroom.png", gameState, 0);
    }

    /**
     * If you click on this kind of card we should this action
     * This method overrides the click action in character class
     */
    @Override
    public void clickAction() {
        super.clickAction();
        int[] newPosition = new int[2];
        newPosition[0] = 0;
        newPosition[1] = 0;
        if (getGameState().getMoney() >= getValue())
            getGameState().setSelectedPlant(new Mushroom(newPosition, getGameState()));
    }



}

package com.company;

public class PeaShooterCard extends Card{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position    the x&y coordinates
     * @param gameState   the game state
     */
    public PeaShooterCard(int[] position, GameState gameState, int chargingTime) {
        super(position, "cards/Icedpeashooter.png", "cards/Peashooter_HD.png", gameState, 100,chargingTime);
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
        if (getGameState().getMoney() >= getValue() && !isUsed())
            getGameState().setSelectedPlant(new PeaShooter(newPosition, getGameState()));
    }


    /**
     * in this override method we change the element path
     * the card is inactive before having enough money
     * after that we should active the card and change the picture
     */
    @Override
    public void update() {
        super.update();
        changeCardImage("cards/peashooterpicker.jpg","cards/Icedpeashooter.png");
    }
}

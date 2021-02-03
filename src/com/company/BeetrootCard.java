package com.company;
/**
 * This is BeetrootCard class.its a kind of  cards.
 * It handles the works related to This type of card
 * It extends Card class.
 * If player has 125 sun and the card is selectable can choose this card
 * by choosing this card player can plant a beet root
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class BeetrootCard extends Card{
    /**
     * This is the constructor of this class
     * create a new Element with a given position
     *
     * @param position           the x&y coordinates
     * @param gameState          the game state
     * @param chargingTime       the time needed for charging a card again
     */
    public BeetrootCard(int[] position,  GameState gameState, int chargingTime) {
        super(position, "cards/icedBeetRootCard.png", "beetCursor.png", gameState, 125 ,chargingTime);
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
            getGameState().setSelectedPlant(new Beetroot(newPosition, getGameState()));
    }

    /**
     * in this override method we change the element path
     * the card is inactive before having enough money
     * after that we should active the card and change the picture
     */
    @Override
    public void update() {
        super.update();
        changeCardImage("cards/BeetRootCard.png","cards/icedBeetRootCard.png");
    }
}

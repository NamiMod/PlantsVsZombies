package com.company;

import java.awt.*;
import java.io.Serializable;

/**
 * a class which shows that what part of the ground is occupied by zombies or plants
 */
public class MapCell implements Serializable {
    //The position of each cell in this map
    private int[] position;
    //The game sate
    private GameState gameState;
    //The plant that we have in this cell
    private Plant plantOfThisCell;

    private boolean plantable = false;
    private boolean isPointing;

    /**
     * This is the constructor of this class
     * creat new cell for the map of the game with a given position abd game state
     * @param position the x & y coordinates
     * @param gameState the game state
     */
    MapCell(int[] position , GameState gameState) {
        this.gameState = gameState;
        this.position = position;
        plantOfThisCell = null;
        //new Mushroom(position, gameState)
        //new SunFlower(position,7000, gameState);
    }

    /**
     * get the position of this cell
     * @return position
     */
    public int[] getPosition() {
        return position;
    }

    /**
     * get the plant that occupied this cell
     * @return plant of this cell
     */
    public Plant getPlantOfThisCell() {
        return plantOfThisCell;
    }

    /**
     * this method checks whether this cell is empty or not
     * @return boolean value
     */
    public boolean isEmpty() {
        if (plantOfThisCell == null)
            return true;
        return false;
    }

    /**
     * this method plant on the ground
     * if the plant operation is doing well the method return true
     * @return boolean value
     */
    public boolean plant() {
        if ( !isEmpty())
            return false;
        if (gameState.getSelectedPlant() != null) {
            plantOfThisCell = gameState.getSelectedPlant();
            plantOfThisCell.setPosition(position);// the first position that assigns to this plant is(0 ,0)
            plantOfThisCell.action();//after we plant a plant we should call the action of that to start to work
            gameState.setMoney(gameState.getMoney() - gameState.getSelectedPlant().getCost());
            gameState.setSelectedPlant(null);
            gameState.setCursor(null);
            return true;
        }
        return false;
    }

    /**
     * draw the object graphically
     * @param g2d the Graphics2D variable
     * @param state the state
     * @throws InterruptedException if there is any problem in drawing method throw this exception
     */
    void draw(Graphics2D g2d, GameState state) throws InterruptedException {
        if (!isEmpty()) {
            plantOfThisCell.draw(g2d);
        }
        else if (isPointing ) {
            Stroke previousStroke = g2d.getStroke();
            Paint previousPaint = g2d.getPaint();

            g2d.setStroke(new BasicStroke(2));
            g2d.setPaint(Color.red);
            g2d.drawRect(position[0], position[1], 70, 100);

            g2d.setStroke(previousStroke);
            g2d.setPaint(previousPaint);
        }
    }

    /**
     * this method is digging up the plant
     * the plant is removed from the ground
     */
     public void dig() {
        if (!isEmpty()) {
            plantOfThisCell.remove();
            plantOfThisCell = null;
        }
    }
    void setPlantable() {
        plantable = true;
    }
    void setUnPlantable() {
        plantable = false;
    }

    boolean isPlantable() {
        return plantable;
    }

    void setPointing(boolean pointing) {
        this.isPointing = pointing;
    }
}

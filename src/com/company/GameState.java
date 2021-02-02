/*** In The Name of Allah ***/

package com.company;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.awt.Cursor;
import java.util.Iterator;

/**
 *  -- Game Frame --
 *
 * This class holds the state of game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 *
 *
 *
 * project : Plants Vs Zombies
 * AP Final Project
 *
 * ######################################
 * @author Seyed Mohammad Ghaffarian    #
 * @author Seyed Nami Modarressi        #
 * @author Mahdi Rahmani                #
 * ######################################
 *
 */

//Todo : Game setting  *****************************

public class GameState implements Serializable {
    //The handler related to mouse
    private MouseHandler mouseHandler;
    //The
    private MouseHandler pointedSelectable;

    //The list of elements
    private  ArrayList<Elements> elements ;

    //The list of cells of the yard
    private ArrayList<MapCell> mapCells ;

    //The money and asset of player
    private int money;

    //The game over field ( if it is going to true we find out that we lost)
    private Boolean gameOver ;

    //The cursor field( it is used when we choose a card and drag it)
    private Cursor cursor ;

    /*The selected Plant( if click on a card a new object from that plant must be creat)
    The first position that assign to that plant is(0,0). in Plant method of MapCell we change it.
     */
    private Plant selectedPlant ;

    //The message address
    private String messageAddress;
    //the controller of game
    private GameController gameController;
    //private CardsPicker pointedPicker;
    private boolean pointingToPicker ;
    //The boolean variable to show if the shovel is chosen or not
    private boolean isShovelSelected ;
    //The number of dead zombies
    private int deadZombies;
    //The score of player
    private int score;
    //the game setting
    private GameSetting gameSetting;

    /**
     * set first value of parameters
     */
    public GameState() {
        elements = new ArrayList<Elements>();
        mapCells = new ArrayList<MapCell>();
        money = 0;
        gameOver = false;
        cursor = null;
        selectedPlant = null;
        deadZombies = 0;
        pointingToPicker = true;
        isShovelSelected = false;
        score = 0;
        gameSetting = new GameSetting();
    }

    /**
     * this method get the value of isShovelSelected variable
     * @return isShovelSelected
     */
    public boolean isShovelSelected() {
        return isShovelSelected;
    }

    /**
     * set the the value of isShovelSelected
     * @param shovelSelected the value that we want to assign to isShovelSelected
     */
    public void setShovelSelected(boolean shovelSelected) {
        isShovelSelected = shovelSelected;
    }

    /**
     * get the selected plant(the plant we select in list of cards)
     * @return selected plant
     */
    public Plant getSelectedPlant() {
        return selectedPlant;
    }

    /**
     * set the selected plant
     * after we plant the plant we should assign null value to this variable
     * @param selectedPlant the selected plant
     */
    public void setSelectedPlant(Plant selectedPlant) {
        this.selectedPlant = selectedPlant;
    }

    /**
     * get the cursor
     * @return cursor
     */
    public Cursor getCursor() {
        return cursor;
    }

    /**
     * set the cursor
     * @param cursor the cursor

     */
    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
    /**
     * get the money of player (The suns that player get)
     * @return money
     */
    public int getMoney() {
        return money;
    }

    /**
     * set the money
     * @param money the money(the suns we need)
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * get the value of gameOver variable
     * @return game over
     */
    public Boolean getGameOver() {
        return gameOver;
    }

    /**
     * set the value of game over
     * @param gameOver the game over value
     */
    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * get the number of dead zombies
     * @return number of ead zombies
     */
    public int getDeadZombies() {
        return deadZombies;
    }

    /**
     * set the number of dead zombies
     * @param deadZombies number of dead zombie
     */
    public void setDeadZombies(int deadZombies) {
        this.deadZombies = deadZombies;
    }

    /**
     * get the score of player
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * set the address of related gif
     * @param messageAddress the address
     */
    public void setMessageAddress(String messageAddress) {
        this.messageAddress = messageAddress;
    }

    public String getMessageAddress() {
        return messageAddress;
    }

    public GameSetting getGameSetting() {
        return gameSetting;
    }

    /**
     * get the list of elements
     * @return elements
     */
    public ArrayList<Elements> getElements() {
        return elements;
    }

    /**
     * add a cell to the map cell
     * @param mapCell the cells of map
     */
    public void addMapCell(MapCell mapCell) {
        mapCells.add(mapCell);
    }


    /**
     * get the list of the cells
     * @return list of cells
     */
    public ArrayList<MapCell> getMapCells() {
        return mapCells;
    }

    /**
     * get the game controller
     * @return gameController
     */
    public GameController getGameController() {
        return gameController;
    }

    /**
     * set the game controller
     * @param gameController the game controller
     */
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    /**
     * In this method we update state to next state
     */
    public void update() {

        Iterator<Elements> elementsIterator = elements.iterator();
        while (elementsIterator.hasNext()) {
            Elements elements = elementsIterator.next();
            if (elements instanceof Character) {
                Character character = (Character) elements;
                character.update();
                if (character.isRemovable()) {
                    character.remove();//the remove method is written in elements class
                    elementsIterator.remove();
                }
            }
            if (elements instanceof Card) {
                Card card = (Card) elements;
                card.update();
            }
        }

        Iterator<MapCell> cellIterator = mapCells.iterator();
        while (cellIterator.hasNext()) {
            MapCell mapCell = cellIterator.next();
            if (!mapCell.isEmpty()) {
                mapCell.getPlantOfThisCell().update();
                if (mapCell.getPlantOfThisCell().isRemovable()) {
                    mapCell.getPlantOfThisCell().remove();//the remove method is written in elements class
                    mapCell.dig();
                }
            }
        }
    }

    /**
     * clear elements array
     * if start a new game we should clear the array list
     */
    void clearElements() {
        Iterator<Elements> elementsIterator = elements.iterator();
        while (elementsIterator.hasNext()) {
            elementsIterator.next();
            if (elementsIterator instanceof Character) {
                ((Character) elementsIterator).remove();
            }
        }
        elements.clear();
    }

    /**
     * delete the array
     * @param element that we want to delete from array list
     */
    void deleteElements(Elements element){
        elements.remove(element);
    }

    /**
     * add element to the array
     * @param element that we want to add to our array
     */
    public void addElement(Elements element){
        elements.add(element);
    }

    /**
     * @return mouse listener
     */
    public MouseListener getMouseListener() {
        return mouseHandler;
    }

    /**
     * @return mouse motion listener
     */
    public MouseMotionListener getMouseMotionListener() {
        return mouseHandler;
    }


    /**
     * The mouse handler.
     */
    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

    }

}


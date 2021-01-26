package com.company;

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

    /**
     *This is the constructor of this class
     * create a new Element with a given position
     */
    public Elements(int[] position , String elementPath)
    {
        this.position = position;
        this.elementPath = elementPath;
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
     * if we call this method the element must be disappeared
     */
    public void disappear()
    {

    }

    public void action()
    {

    }
}

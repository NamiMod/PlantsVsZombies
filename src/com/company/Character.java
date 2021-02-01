package com.company;

/**
 * This is character class. this class extends Elements
 * Also Zombie Class and Plant class extends from this class
 * Hp field means healthPoint and show the life of plants and zombies
 *
 * @version 1.0
 * @author Mahdi Rahmani  & Nami Modarresi
 */
public class Character extends Elements{
    // The health point field
    private int HP;
    //The speed of character(zombie & bullet & lawn mower can move and have speed)
    private int speed;

    /**
     * This is constructor of this class
     *  It calls the constructor of superclass and pass the needed argument as an entry
     *  If we call this create a new Character class
     * @param position the x&y coordinates
     * @param HP The health point
     * @param elementPath the path of element gif or image
     * @param gameState the game state
     * @param width the width of object
     * @param height the height of object
     */
    public Character(int[] position , int HP , String elementPath , GameState gameState ,int width, int height , int speed){
        super(position , elementPath ,gameState, width ,height);
        this.HP = HP;
        this.speed = speed;
    }

    /**
     * get the health point of element
     * @return Hp
     */
    public int getHp() {
        return HP;
    }

    /**
     * set the health point of element
     * @param hp Health point
     */
    public void setHp(int hp) {
        HP = hp;
    }

    /**
     * get the speed of zombie
     * @return speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * set the speed of zombie
     * @param speed zombie speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * This method get the damage value and hurt the object
     * @param damage the damage value
     */
    public void hurt(int damage)
    {
        HP -= damage;
        if (HP < 0)
            HP = 0;
    }

    /**
     * if the Hp of a character is 0 this method return true
     * that means we can remove that character
     * @return boolean value
     */
    public boolean isRemovable()
    {
        if (HP == 0)
            return true;
        return false;
    }

    /**
     * This method check the list of elements and if the position of a zombie is suitable
     * for impacting the bullet with that then we return that zombie as an out put
     * @return destroyed zombie
     */
    public Zombie getDestroyedZombie() {
        for (Elements elements : getGameState().getElements()) {
            if (elements instanceof Zombie) {
                if (
                        (
                                (getPosition()[0] < elements.getPosition()[0] + elements.getWidth() && !(getPosition()[0] < elements.getPosition()[0])) ||
                                        (elements.getPosition()[0] <= getPosition()[0] + getWidth() && getPosition()[0] + getWidth() <= elements.getPosition()[0] + elements.getWidth())
                        ) &&
                                (
                                        (!(getPosition()[1] <= elements.getPosition()[1]) && getPosition()[1] <= elements.getPosition()[1] + elements.getHeight()) ||
                                                (elements.getPosition()[1] <= getPosition()[1] + getHeight() && (getPosition()[1] + getHeight() <= elements.getHeight() + elements.getPosition()[1]))
                                )
                ) {
                    return (Zombie) elements;
                }
            }
        }
        return null;
    }

    /**
     * This method check the list of selectables and if a plant in our game field
     * placed across the zombie we should return it . because the zombie wants to chew it
     * @return the plant that across the zombie
     */
    public Plant getCollidedPlant() {
        for (MapCell cell : getGameState().getMapCells()) {
            if (
                    !cell.isEmpty() &&
                            (
                                    (getPosition()[0] < cell.getPosition()[0] + cell.getPlantOfThisCell().getWidth() && getPosition()[0] > cell.getPlantOfThisCell().getPosition()[0]) ||
                                            (getPosition()[0] + getWidth() > cell.getPlantOfThisCell().getPosition()[0] && getPosition()[0] + getWidth() < cell.getPlantOfThisCell().getPosition()[0] + cell.getPlantOfThisCell().getWidth())
                            ) &&
                            (
                                    (getPosition()[1] > cell.getPlantOfThisCell().getPosition()[1] && getPosition()[1] < cell.getPlantOfThisCell().getPosition()[1] + cell.getPlantOfThisCell().getHeight()) ||
                                            (getPosition()[1] + getHeight() > cell.getPlantOfThisCell().getPosition()[1] && (getPosition()[1] + getHeight() < cell.getPlantOfThisCell().getHeight() + cell.getPlantOfThisCell().getPosition()[1]))
                            )
            ) {
                return cell.getPlantOfThisCell();
            }
        }
        return null;
    }

    @Override
    public void update() {
        move();
    }

    /**
     * the movement of character is with the help of speed
     */
    public void move() {
        int[] newPos = getPosition();
        newPos[0] -= speed;
        setPosition(newPos);
    }
    public void action()
    {

    }
}

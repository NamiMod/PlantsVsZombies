package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;

public class Mushroom extends Shooter{

    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     *
     * @param position    the x & y coordinates
     * @param gameState   the game state
     */
    public Mushroom(int[] position , GameState gameState ){
        super(position, 0 , 70 ,"mushroom.png", gameState);
    }

    /**
     * If the zombies are coming across this type of plant we call this method to do the best action
     * It creates bullet for killing zombies
     * This plant create FrozenPea bullet.
     */
    @Override
    public void action() {
       /* super.action();
        int[] bulletFirstPos = new int[2];
        bulletFirstPos[0] = getPosition()[0] + 20;
        bulletFirstPos[1] = getPosition()[1] + 30;
        MushroomBullet mushroomBullet = new MushroomBullet(bulletFirstPos, getGameState());
        throwBullet(mushroomBullet);*/
        throwBullet();
        /*TimerTask Task = new TimerTask() {
            @Override
            public void run()
            {
                HashMap<Integer,Elements> myElement = new HashMap<>();
                for (int i = 0; i<getGameState().getElements().size(); i++)
                {
                    myElement.put(i, getGameState().getElements().get(i));
                }
                Iterator<Integer> key = myElement.keySet().iterator();
                while (key.hasNext()) {
                    Integer thisKey = key.next();
                    if (getPosition()[1] + 5 == myElement.get(thisKey).getPosition()[1] && myElement.get(thisKey) instanceof Zombie){
                        int[] bulletFirstPos = new int[2];
                        bulletFirstPos[0] = getPosition()[0] + 20;
                        bulletFirstPos[1] = getPosition()[1] + 30;
                        MushroomBullet mushroomBullet = new MushroomBullet(bulletFirstPos, getGameState());
                        getGameState().addElement(mushroomBullet);
                    }
                }

            }
        };
        getTimer().schedule(Task, 200, 2000);*/

    }
}

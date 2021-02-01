package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;

/**
 * This is Shooter class.its a kind of  plants.
 * It handles the works related to This type of Plant
 * It extends Plant class.
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */
public class Shooter extends Plant{
    /**
     * This is the constructor of this class.
     * Creat a new Plant with a given position , cost , HP , elementPath
     * @param position the x & y coordinates
     * @param cost the cost of this plant
     * @param HP The health point
     * @param elementPath the path of element gif or image
     */
    public Shooter(int[] position , int cost, int HP, String elementPath, GameState gameState) {
        super(position , cost, HP , elementPath,gameState);
    }

    /**
     * This is throw bullet method
     * when our plant wants to throw bullet we call this
     */
    public void throwBullet()
    {
        Shooter thisShooter = this;
        TimerTask Task = new TimerTask() {
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
                        bulletFirstPos[0] = getPosition()[0] + 30;
                        bulletFirstPos[1] = getPosition()[1] + 10;
                        Bullet bullet1 = null;
                        Bullet bullet2 = null;

                        if (thisShooter instanceof Mushroom){
                            bulletFirstPos[1] = getPosition()[1] + 20;
                            bullet1 = new MushroomBullet(bulletFirstPos, getGameState());
                        }else if (thisShooter instanceof PeaShooter){
                            bullet1 = new Pea(bulletFirstPos, getGameState());
                        }else if (thisShooter instanceof SnowPeaShooter){
                            bullet1 = new FrozenPea(bulletFirstPos, getGameState());
                        }else if (thisShooter instanceof Repeater) {
                            bullet1 = new Pea(bulletFirstPos, getGameState());
                            int[] secondBulletFirstPos = new int[2];
                            secondBulletFirstPos[0] = getPosition()[0] + 60;
                            secondBulletFirstPos[1] = getPosition()[1] + 10;
                            bullet2 = new Pea(secondBulletFirstPos, getGameState());
                        }
                        getGameState().addElement(bullet1);
                        if (bullet2 != null)
                            getGameState().addElement(bullet2);
                    }
                }

            }
        };
        getTimer().schedule(Task, 200, 2000);
        /*getTimer().schedule(Task, 200, 2000);
        TimerTask Task = new TimerTask() {
            @Override
            public void run()
            {
                for (Elements elements : getGameState().getElements())
                {
                    if (getPosition()[1] + 5 == elements.getPosition()[1] && elements instanceof Zombie) {
                        getGameState().addElement(bullet);
                    }
                }

            }
        };
        getTimer().schedule(Task, 200, 2000);*/
    }

}

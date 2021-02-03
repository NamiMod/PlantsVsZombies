/*** In The Name of Allah ***/
package com.company;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.lang.model.element.Element;
import javax.sound.sampled.*;
import javax.swing.JFrame;

/**
 *  -- Game Frame --
 *
 * The window on which the rendering is performed.
 * This example uses the modern BufferStrategy approach for double-buffering,
 * actually it performs triple-buffering!
 * For more information on BufferStrategy check out:
 *    http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 *    http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 *
 *
 *
 * project : Plants Vs Zombies
 * AP Final Project
 *
 * ######################################
 * @author Seyed Mohammad Ghaffarian    #
 * @author Mahdi Rahmani                #
 * @author Seyed Nami Modarressi        #
 * ######################################
 *
 *
 */
public class GameFrame extends JFrame implements Serializable {

    public static final int GAME_HEIGHT = 287*2;
    public static final int GAME_WIDTH = 530*2;

    private long lastRender;

    private transient BufferStrategy bufferStrategy;

    public GameFrame(String title) {
        super(title);
        setResizable(false);
        setSize(GAME_WIDTH, GAME_HEIGHT);
        lastRender = -1;
    }

    /**
     * This must be called once after the JFrame is shown:
     *    frame.setVisible(true);
     * and before any rendering is started.
     */
    public void initBufferStrategy() {
        // Triple-buffering
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
    }


    /**
     * Game rendering with triple-buffering using BufferStrategy.
     */

    public void render(GameState state) {
        // Render single frame
        do {
            // The following loop ensures that the contents of the drawing buffer
            // are consistent in case the underlying surface was recreated
            do {
                // Get a new graphics context every time through the loop
                // to make sure the strategy is validated
                Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
                try {
                    doRendering(graphics, state);
                } finally {
                    // Dispose the graphics
                    graphics.dispose();
                }
                // Repeat the rendering if the drawing buffer contents were restored
            } while (bufferStrategy.contentsRestored());

            // Display the buffer
            bufferStrategy.show();
            // Tell the system to do the drawing NOW;
            // otherwise it can take a few extra ms and will feel jerky!
            Toolkit.getDefaultToolkit().sync();

            // Repeat the rendering if the drawing buffer was lost
        } while (bufferStrategy.contentsLost());
    }

    /**
     * Rendering all game elements based on the game state.
     */
    public void doRendering(Graphics2D g2d, GameState state) {

        g2d.setPaint(Color.DARK_GRAY);
        setCursor(state.getCursor());


        Image background = loadImage("./images/lawn.png");
        g2d.drawImage(background, 0, 0, GAME_WIDTH, GAME_HEIGHT, null);
        Image money = loadImage("./images/plantPanel.png");
        g2d.drawImage(money, -75, -50, 470, 190, null);

        HashMap<Integer,Elements> myElement = new HashMap<>();
        for (int i = 0; i<state.getElements().size(); i++)
        {
            myElement.put(i, state.getElements().get(i));
        }
        Iterator<Integer> key = myElement.keySet().iterator();
        while (key.hasNext()) {
            Integer thisKey = key.next();
            try {
                myElement.get(thisKey).draw(g2d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (MapCell cell : state.getMapCells()) {
            try {
                cell.draw(g2d, state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        g2d.drawString(String.valueOf(state.getMoney()), 25, 69);

        if (state.getGameOver()) {
            g2d.dispose();
        }
    }

    /**
     * load image
     * @param path image address
     * @return image
     */
    public static Image loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}

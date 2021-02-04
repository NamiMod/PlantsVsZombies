package com.company;

/**
 * This is Game class.
 * in this class we create new game and start it
 *
 * @version 1.0
 * @author Mahdi Rahmani & Nami Modarressi
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Game {
    static  GameFrame mainframe ;
    //GameState state;
    public void start(GameState state , boolean load){

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainframe = new GameFrame("Java Plants vs Zombies");
                mainframe.setLocationRelativeTo(null); // put frame at center of screen
                mainframe.setUndecorated(true);
                mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                mainframe.setVisible(true);
                mainframe.initBufferStrategy();

                state.setFrame(mainframe);
                // Create and execute the game-loop
                GameLoop game = new GameLoop(state,load);
                game.init();
                ThreadPool.execute(game);
                // and the game starts ...
            }
        });


    }

}

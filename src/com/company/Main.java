package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    private static HashMap<String, Image> cachedImages = new HashMap<String, Image>();
    static  GameFrame mainframe ;
    GameState state;
    public static void main(String[] args) {
	// write your code here

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainframe = new GameFrame("Java Plants vs Zombies");
                mainframe.setLocationRelativeTo(null); // put frame at center of screen
                //mainframe.setUndecorated(true);
                mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                mainframe.setVisible(true);
                mainframe.initBufferStrategy();

                // Create and execute the game-loop
                GameLoop game = new GameLoop(mainframe);
                game.init();
                ThreadPool.execute(game);
                // and the game starts ...
            }
        });


    }
    /**
     * loading gif images
     * @param filename
     * @return
     */
    static Image loadImage(String filename) {
        if (cachedImages.containsKey(filename)) return cachedImages.get(filename);

        Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

        try {
            URL imageURL = ClassLoader.getSystemResource("images/" + filename);
            if (imageURL != null) {
                if (imageURL.toString().toLowerCase().endsWith(".gif"))
                    image = (new ImageIcon(imageURL)).getImage();
                else
                    image = ImageIO.read(imageURL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cachedImages.put(filename, image);

        System.out.println("Loaded " + filename);  // TODO: Delete me

        return image;
    }
}

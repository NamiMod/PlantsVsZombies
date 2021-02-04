package com.company;

/**
 *  -- Main --
 *
 * main class of game
 *
 * project : Plants Vs Zombies
 * AP Final Project
 *
 * ###############################
 * @author Seyed Nami Modarressi #
 * @author Mahdi Rahmani         #
 * @since 2020                   #
 * @version 1.0                  #
 * ###############################
 *
 *
 */
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

        public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {

           Loading_Gui start =  new Loading_Gui();

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

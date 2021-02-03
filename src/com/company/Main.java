package com.company;

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

            //Plants_Gui p = new Plants_Gui(new GameSetting());
            //Click_To_Start_GUI p = new Click_To_Start_GUI();
            Menu_Gui p = new Menu_Gui(new GameSetting());


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

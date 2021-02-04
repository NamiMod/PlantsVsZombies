package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 *  -- Loading Gui --
 *
 *  this is Gui For loading page
 *  loading
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

public class Loading_Gui {

    private JFrame Home;
    private JLabel image;

    /**
     * create new Click To Start Frame and add Elements
     */
    public Loading_Gui() throws InterruptedException {
        Home = new JFrame("Plants Vs Zombies");
        Home.setSize(1200,740);
        Home.setResizable(false);
        Home.setLocationRelativeTo(null);
        Home.setLayout(new BorderLayout());
        image = new JLabel();
        image.setIcon(new ImageIcon("./PVS Design Kit/images/final_600a85b755d9b4004bdf6d17_731777.gif"));
        Home.add(image, BorderLayout.CENTER);
        Home.setVisible(true);
        TimeUnit.SECONDS.sleep(12);
        Home.dispose();
        Click_To_Start_GUI next = new Click_To_Start_GUI();
    }
}

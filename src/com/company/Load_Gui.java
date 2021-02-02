package com.company;
import com.company.GameSetting;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *  -- Load Gui --
 *
 * in this class we create window to show saved games
 * player can load a save
 *
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
public class Load_Gui {

    private JFrame Home;
    private JLabel text;
    private JTextArea saves;
    private JTextField number;
    private JLabel get_number;
    private JButton load;
    private JButton menu;
    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/menu.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);


    /**
     * create new load file screen
     *
     * @param game_info information of game
     */
    public Load_Gui(GameSetting game_info) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.game_info=game_info;
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/load.jpg")));
        addElement();
        Home.setVisible(true);
        if (game_info.getSound() == 0){
            playSound();
        }
    }

    /**
     * add elements to load file screen
     */
    public void addElement() {
        text = new JLabel("Saves");
        text.setLocation(600, 200);
        text.setSize(150, 50);
        text.setForeground(Color.white);
        text.setFont(new Font("Arial", Font.BOLD, 40));
        Home.add(text);
        saves = new JTextArea();
        saves.setLocation(600, 280);
        saves.setSize(500, 200);
        saves.setForeground(Color.white);
        saves.setEditable(false);
        saves.setOpaque(false);
        saves.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));
        Home.add(saves);
        get_number = new JLabel("Enter Your Save's Name :");
        get_number.setLocation(600, 500);
        get_number.setSize(300, 50);
        get_number.setForeground(Color.white);
        get_number.setFont(new Font("Arial", Font.BOLD, 20));
        Home.add(get_number);
        number = new JTextField();
        number.setLocation(880, 510);
        number.setSize(220, 30);
        number.setForeground(Color.white);
        number.setFont(new Font("Arial", Font.BOLD, 20));
        number.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
        number.setBackground(new Color(0, 0, 0, 0));
        number.setOpaque(false);
        Home.add(number);
        load = new JButton("Load Your Game");
        load.setLocation(600, 580);
        load.setSize(500, 50);
        load.setForeground(Color.BLACK);
        load.setFont(new Font("Arial", Font.BOLD, 20));
        load.setOpaque(false);
        load.setContentAreaFilled(false);
        load.setBorderPainted(true);
        load.addActionListener(new ActionListener() {
            /**
             * load file
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                JOptionPane.showMessageDialog(Home,"Loading complete","",JOptionPane.PLAIN_MESSAGE);
                // load save and go to game
            }
        });
        Home.add(load);
        menu = new JButton("Main Menu");
        menu.setLocation(600, 640);
        menu.setSize(500, 50);
        menu.setForeground(Color.BLACK);
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        menu.setOpaque(false);
        menu.setContentAreaFilled(false);
        menu.setBorderPainted(true);
        menu.addActionListener(new ActionListener() {
            /**
             * back to manu
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                try {
                    Menu_Gui next = new Menu_Gui(game_info);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                }
            }
        });
        Home.add(menu);
    }
    /**
     * play music
     * @throws IOException cant open music
     * @throws UnsupportedAudioFileException music file is not in good format
     * @throws LineUnavailableException cant track data of file
     */
    public void playSound() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        if ( ! line1.isOpen() )
        {
            clip1.open(as1);
            clip1.loop(Clip.LOOP_CONTINUOUSLY);
            clip1.start();
        }

    }
}

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
 *  -- Setting Gui --
 *
 * in this class player can change settings of game
 * enable or disable sound
 * change game mode (Normal or Hard)
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
public class Setting_Gui {
    private JFrame Home;
    private JButton on;
    private JButton off;
    private JCheckBox normal;
    private JLabel text;
    private JCheckBox hard;
    private JButton change;
    private JButton save;
    private JButton plants;
    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/menu.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);

    public Setting_Gui(GameSetting game_info) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.game_info = game_info;
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/setting.jpg")));
        addElement();
        Home.setVisible(true);
        if (game_info.getSound() == 0){
            playSound();
        }
    }

    /**
     * add elements to settings window
     */
    public void addElement() {
        text = new JLabel("Settings ");
        text.setLocation(50, 50);
        text.setSize(400, 50);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Arial", Font.BOLD, 30));
        text.setOpaque(false);
        Home.add(text);
        change = new JButton("Change Your Username Or Password");
        change.setLocation(50, 150);
        change.setSize(400, 50);
        change.setForeground(Color.BLACK);
        change.setFont(new Font("Arial", Font.BOLD, 20));
        change.setOpaque(false);
        change.setContentAreaFilled(false);
        change.setBorderPainted(true);
        change.addActionListener(new ActionListener() {
            /**
             * go to change username or password page
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                clip1.stop();
                Home.dispose();
                try {
                    Change_Username_password_Gui next = new Change_Username_password_Gui(game_info);
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
            }
        });
        Home.add(change);
        on = new JButton();
        on.setLocation(80, 250);
        on.setSize(100, 100);
        on.setBorderPainted(false);
        on.setIcon(new ImageIcon("./PVS Design Kit/images/on.png"));
        on.addActionListener(new ActionListener() {
            /**
             * turn on the music
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (game_info.getSound() == 1){
                    game_info.setSound(0);
                    try {
                        Setting_Gui next = new Setting_Gui(game_info);
                        Home.dispose();
                    } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                        ioException.printStackTrace();
                    }

                }
            }
        });
        Home.add(on);
        off = new JButton();
        off.setLocation(330, 250);
        off.setSize(100, 100);
        off.setBorderPainted(false);
        off.setIcon(new ImageIcon("./PVS Design Kit/images/off.png"));
        off.addActionListener(new ActionListener() {
            /**
             * turn off the music
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                clip1.stop();
                try {
                    as1.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                game_info.setSound(1);
            }
        });
        Home.add(off);
        normal = new JCheckBox("Normal Mode");
        normal.setLocation(50, 380);
        normal.setSize(200, 100);
        normal.setFont(new Font("Arial", Font.BOLD, 20));
        Home.add(normal);
        hard = new JCheckBox("Hard Mode");
        hard.setLocation(310, 380);
        hard.setSize(300, 100);
        hard.setFont(new Font("Arial", Font.BOLD, 20));
        Home.add(hard);

        plants = new JButton("Plants");
        plants.setLocation(50,500);
        plants.setSize(400,50);
        plants.setForeground(Color.BLACK);
        plants.setFont(new Font("Arial", Font.BOLD, 20));
        plants.setOpaque(false);
        plants.setContentAreaFilled(false);
        plants.setBorderPainted(true);
        plants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                try {
                    Plants_Gui next = new Plants_Gui(game_info);
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                }
            }
        });
        Home.add(plants);
        save = new JButton("Save and Back to Menu");
        save.setLocation(50, 550);
        save.setSize(400, 50);
        save.setForeground(Color.BLACK);
        save.setFont(new Font("Arial", Font.BOLD, 20));
        save.setOpaque(false);
        save.setContentAreaFilled(false);
        save.setBorderPainted(true);
        save.addActionListener(new ActionListener() {
            /**
             * back to menu
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (hard.isSelected() == normal.isSelected()){
                        JOptionPane.showMessageDialog(Home,"Choose one of the normal or hard mode","Error",JOptionPane.ERROR_MESSAGE);
                    }else {
                        if (hard.isSelected()){
                            game_info.setMode(1);
                        }
                        if (normal.isSelected()){
                            game_info.setMode(0);
                        }
                        clip1.stop();
                        Home.dispose();
                        Menu_Gui next = new Menu_Gui(game_info);
                    }
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                }
            }
        });
        Home.add(save);
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

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
 *  -- Score Gui --
 *
 * in this class we create window to show score after die
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
public class Score_Gui {

    private JFrame Home;
    private JTextField score;
    private JLabel image;
    private JLabel image_score;
    private JButton replay;
    private int your_score;
    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/game_end.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);

    /**
     * create new frame
     * @param score score of player
     * @throws UnsupportedAudioFileException file format isn't good
     * @throws IOException cant open file
     * @throws LineUnavailableException cant track data from file
     */
    public Score_Gui(int score,GameSetting game_info) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.game_info = game_info;
        this.your_score=score;
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.getContentPane().setBackground(Color.black);
        addElements();
        Home.setVisible(true);
        if (game_info.getSound() == 0) {
            playSound();
        }
    }

    /**
     * add elements to frame
     */
    public void addElements(){

        image = new JLabel();
        image.setLocation(290,0);
        image.setSize(1000,600);
        image.setIcon(new ImageIcon("./PVS Design Kit/images/gameOver 2.jpg"));
        Home.add(image);
        image_score = new JLabel();
        image_score.setLocation(400,550);
        image_score.setSize(200,60);
        image_score.setIcon(new ImageIcon("./PVS Design Kit/images/gameOver.jpg"));
        Home.add(image_score);
        score = new JTextField();
        score.setLocation(610,550);
        score.setSize(200,60);
        score.setBackground(new Color(0, 0, 0, 0));
        score.setOpaque(false);
        score.setForeground(Color.white);
        score.setFont(new Font("Arial",Font.BOLD,50));
        score.setText(Integer.toString(your_score));
        score.setEditable(false);
        Home.add(score);
        replay = new JButton();
        replay.setLocation(520,650);
        replay.setSize(150,50);
        replay.setIcon(new ImageIcon("./PVS Design Kit/images/Gifs/gameOver.gif"));
        replay.addActionListener(new ActionListener() {
            /**
             * back to game
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
        Home.add(replay);
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

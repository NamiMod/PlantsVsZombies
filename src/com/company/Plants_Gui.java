package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *  -- plants Gui --
 *
 * in this class we show plants and player can choose from plants
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
public class Plants_Gui {

    private JFrame Home;
    private JButton save;

    private JLabel sunPlant;
    private JCheckBox sun_plant;

    private JLabel peaShooter;
    private JCheckBox pea_shooter;

    private JLabel snowPea;
    private JCheckBox snow_pea;

    private JLabel wallNut;
    private JCheckBox wall_nut;

    private JLabel cherryBomb;
    private JCheckBox cherry_bomb;

    private JLabel mushRoom;
    private JCheckBox mushroom;

    // repeater
    // beet

    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/menu.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);

    public Plants_Gui(GameSetting game) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
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
    public void addElement(){

        sunPlant = new JLabel();
        sunPlant.setLocation(50,50);
        sunPlant.setSize(100,100);
        sunPlant.setIcon(new ImageIcon("./PVS Design Kit/images/Cards/card_sunflower.png"));
        Home.add(sunPlant);

        sun_plant = new JCheckBox("Sun Plant");
        sun_plant.setSize(150,50);
        sun_plant.setLocation(120,75);
        Home.add(sun_plant);

        peaShooter = new JLabel();
        peaShooter.setLocation(350,50);
        peaShooter.setSize(100,100);
        peaShooter.setIcon(new ImageIcon("./PVS Design Kit/images/Cards/card_peashooter.png"));
        Home.add(peaShooter);

        pea_shooter = new JCheckBox("Pea Shooter");
        pea_shooter.setSize(150,50);
        pea_shooter.setLocation(420,75);
        Home.add(pea_shooter);

        snowPea = new JLabel();
        snowPea.setLocation(350,150);
        snowPea.setSize(100,100);
        snowPea.setIcon(new ImageIcon("./PVS Design Kit/images/Cards/card_freezepeashooter.png"));
        Home.add(snowPea);

        snow_pea = new JCheckBox("Snow Shooter");
        snow_pea.setSize(150,50);
        snow_pea.setLocation(420,175);
        Home.add(snow_pea);

        wallNut = new JLabel();
        wallNut.setLocation(50,150);
        wallNut.setSize(100,100);
        wallNut.setIcon(new ImageIcon("./PVS Design Kit/images/Cards/card_wallnut.png"));
        Home.add(wallNut);

        wall_nut = new JCheckBox("WallNut");
        wall_nut.setSize(150,50);
        wall_nut.setLocation(120,175);
        Home.add(wall_nut);

        cherryBomb = new JLabel();
        cherryBomb.setLocation(50,250);
        cherryBomb.setSize(100,100);
        cherryBomb.setIcon(new ImageIcon("./PVS Design Kit/images/Cards/card_cherrybomb.png"));
        Home.add(cherryBomb);

        cherry_bomb = new JCheckBox("Cherry Bomb");
        cherry_bomb.setSize(150,50);
        cherry_bomb.setLocation(120,275);
        Home.add(cherry_bomb);


        mushRoom = new JLabel();
        mushRoom.setLocation(350,250);
        mushRoom.setSize(100,100);
        mushRoom.setIcon(new ImageIcon("./PVS Design Kit/images/Cards/mushroompicker .png"));
        Home.add(mushRoom);

        mushroom = new JCheckBox("Mushroom");
        mushroom.setSize(150,50);
        mushroom.setLocation(420,275);
        Home.add(mushroom);

        save = new JButton("Save and Back to Menu");
        save.setLocation(50, 550);
        save.setSize(400, 50);
        save.setForeground(Color.BLACK);
        save.setFont(new Font("Arial", Font.BOLD, 20));
        save.setOpaque(false);
        save.setContentAreaFilled(false);
        save.setBorderPainted(true);
        Home.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;

                if (sun_plant.isSelected()){
                    counter+=1;
                }
                if (pea_shooter.isSelected()){
                    counter+=1;
                }
                if (snow_pea.isSelected()){
                    counter+=1;
                }
                if (wall_nut.isSelected()){
                    counter+=1;
                }
                if (cherry_bomb.isSelected()){
                    counter+=1;
                }
                if (mushroom.isSelected()){
                    counter+=1;
                }

                if (counter != 6){
                    JOptionPane.showMessageDialog(Home, "You have to choose 6 plants", "Error", JOptionPane.ERROR_MESSAGE);
                }else {
                    clip1.stop();
                    Home.dispose();
                    try {
                        Setting_Gui next = new Setting_Gui(game_info);
                    } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                        ioException.printStackTrace();
                    }
                }

            }
        });

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

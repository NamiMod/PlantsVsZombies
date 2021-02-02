import com.company.Game;
import com.company.GameSetting;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *  -- Menu Gui --
 *
 * this is menu screen of game
 * in this screen we can go to other parts like setting or start new game or ...
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

public class Menu_Gui {

    private JFrame Home;
    private JButton new_game;
    private JButton load_game;
    private JButton ranking;
    private JButton setting;
    private JButton quit;
    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/menu.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);


    private AudioInputStream as2= AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/background.wav"));
    private AudioFormat af2 = as2.getFormat();
    private Clip clip2 = AudioSystem.getClip();
    private DataLine.Info info2 = new DataLine.Info(Clip.class, af2);
    private Line line2 = AudioSystem.getLine(info2);

    /**
     * create new Menu window
     * @param game_info information of game
     */
    public Menu_Gui(GameSetting game_info) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.game_info = game_info;
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/background.jpg")));
        addElements();
        Home.setVisible(true);
        if (game_info.getSound() == 0) {
            playSound();
        }
    }

    /**
     * add elements to window
     */
    public void addElements(){
        new_game = new JButton("New Game");
        new_game.setLocation(400,220);
        new_game.setSize(300,50);
        new_game.setFont(new Font("Arial",0,15));
        new_game.addActionListener(new ActionListener() {
            /**
             * start a new game
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                if (game_info.getSound() == 0){
                    try {
                        playSoundGame();
                    } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                        ioException.printStackTrace();
                    }
                }
                Game game = new Game();
                game.start();
            }
        });
        Home.add(new_game);
        load_game = new JButton("Load Game");
        load_game.setLocation(400,280);
        load_game.setSize(300,50);
        load_game.setFont(new Font("Arial",0,15));
        load_game.addActionListener(new ActionListener() {
            /**
             * load saves page
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                try {
                    Load_Gui next = new Load_Gui(game_info);
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        Home.add(load_game);
        ranking = new JButton("Ranking");
        ranking.setLocation(400,340);
        ranking.setSize(300,50);
        ranking.setFont(new Font("Arial",0,15));
        ranking.addActionListener(new ActionListener() {
            /**
             * open ranking page
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Home.dispose();
                    clip1.stop();
                    Ranking_Gui next = new Ranking_Gui(game_info);
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                }
            }
        });
        Home.add(ranking);
        setting = new JButton("Setting");
        setting.setLocation(400,400);
        setting.setSize(300,50);
        setting.setFont(new Font("Arial",0,15));
        setting.addActionListener(new ActionListener() {
            /**
             * go to setting page
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                try {
                    Setting_Gui next = new Setting_Gui(game_info);
                } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        Home.add(setting);
        quit = new JButton("Quit Game");
        quit.setLocation(400,460);
        quit.setSize(300,50);
        quit.setFont(new Font("Arial",0,15));
        quit.addActionListener(new ActionListener() {
            /**
             * exit
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                clip1.stop();
                EndRequest p = new EndRequest();
                try {
                    p.start();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        Home.add(quit);
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

    /**
     * play music
     * @throws IOException cant open music
     * @throws UnsupportedAudioFileException music file is not in good format
     * @throws LineUnavailableException cant track data of file
     */
    public void playSoundGame() throws IOException, UnsupportedAudioFileException, LineUnavailableException {

        if ( ! line2.isOpen() )
        {
            clip2.open(as2);
            clip2.loop(Clip.LOOP_CONTINUOUSLY);
            clip2.start();
        }

    }

}

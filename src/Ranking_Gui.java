import com.company.GameSetting;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *  -- Ranking Gui --
 *
 * in this class we can create and add elements to show ranking of game
 * we get scores from server
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
public class Ranking_Gui {

    private JFrame Home;
    private JLabel text;
    private JTextArea ranking;
    private JButton back;
    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/menu.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);


    /**
     * create new Ranking screen
     * @param game_info data from player
     */
    public Ranking_Gui(GameSetting game_info) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        this.game_info = game_info;
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/rank.jpg")));
        addElement();
        Home.setVisible(true);
        if (game_info.getSound() == 0){
            playSound();
        }
    }

    /**
     * add elements to page
     */
    public void addElement() {

        text = new JLabel("Ranking");
        text.setLocation(200,10);
        text.setSize(250,50);
        text.setFont(new Font("Arial",Font.BOLD,40));
        text.setForeground(Color.white);
        Home.add(text);
        ranking = new JTextArea();
        ranking.setLocation(200,80);
        ranking.setSize(400,500);
        ranking.setEditable(false);
        ranking.setBackground(new Color(0, 0, 0, 0));
        ranking.setOpaque(false);
        ranking.setForeground(Color.white);
        ranking.setText("Rank      Username          Score   Win   Lose   Normal   Hard "+"\n");
        Home.add(ranking);
        back = new JButton("Main Menu");
        back.setLocation(200,600);
        back.setSize(400,50);
        back.setFont(new Font("Arial",Font.BOLD,30));
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setForeground(Color.BLACK);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(true);
        back.addActionListener(new ActionListener() {
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
        Home.add(back);

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

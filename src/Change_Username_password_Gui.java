import com.company.GameSetting;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 *  -- Change Username password Gui --
 *
 * in this class player can change username or password of account
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

public class Change_Username_password_Gui {

    private JFrame Home;
    private JTextField username;
    private JTextField password;
    private JTextField newUsername;
    private JTextField newPassword;
    private JButton change;
    private JButton back;
    private JLabel logo;
    private GameSetting game_info;

    private AudioInputStream as1 = AudioSystem.getAudioInputStream(new File("./PVS Design Kit/sounds/menu.wav"));
    private AudioFormat af = as1.getFormat();
    private Clip clip1 = AudioSystem.getClip();
    private DataLine.Info info = new DataLine.Info(Clip.class, af);
    private Line line1 = AudioSystem.getLine(info);


    /**
     * create new change username or password page
     */
    public Change_Username_password_Gui(GameSetting game_info) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        this.game_info = game_info;
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/login.jpg")));
        addElement();
        Home.setVisible(true);
        if (game_info.getSound() == 0){
            playSound();
        }
    }
    /**
     * add Elements to page
     */
    public void addElement() {
        logo = new JLabel();
        logo.setLocation(450, 0);
        logo.setSize(300, 200);
        logo.setIcon(new ImageIcon("./PVS Design Kit/images/logo.png"));
        Home.add(logo);
        username = new JTextField("OLD Username");
        username.setLocation(450, 280);
        username.setSize(300, 40);
        username.setFont(new Font("Arial", 0, 15));
        username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        username.setBackground(new Color(0, 0, 0, 0));
        username.setOpaque(false);
        Home.add(username);
        password = new JTextField("OLD Password");
        password.setLocation(450, 330);
        password.setSize(300, 40);
        password.setFont(new Font("Arial", 0, 15));
        password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        password.setBackground(new Color(0, 0, 0, 0));
        password.setOpaque(false);
        Home.add(password);
        newUsername = new JTextField("NEW Username");
        newUsername.setLocation(450, 400);
        newUsername.setSize(300, 40);
        newUsername.setFont(new Font("Arial", 0, 15));
        newUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        newUsername.setBackground(new Color(0, 0, 0, 0));
        newUsername.setOpaque(false);
        Home.add(newUsername);
        newPassword = new JTextField("New Password");
        newPassword.setLocation(450, 450);
        newPassword.setSize(300, 40);
        newPassword.setFont(new Font("Arial", 0, 15));
        newPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        newPassword.setBackground(new Color(0, 0, 0, 0));
        newPassword.setOpaque(false);
        Home.add(newPassword);
        change = new JButton("Change");
        change.setLocation(450, 550);
        change.setSize(300, 40);
        change.setFont(new Font("Arial", 0, 15));
        change.setOpaque(false);
        change.setContentAreaFilled(false);
        change.setBorderPainted(true);
        change.addActionListener(new ActionListener() {
            /**
             * change username of password
             * @param e event of button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // change username or password
            }
        });
        Home.add(change);
        back = new JButton("Back To Setting");
        back.setLocation(450, 600);
        back.setSize(300, 40);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(true);
        back.addActionListener(new ActionListener() {
            /**
             * back to setting
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

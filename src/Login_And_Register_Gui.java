import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *  -- Login And Register Gui --
 *
 *  this class is gui of login or register an account for player
 *  in this class we can get username of password for login or register accounts
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

public class Login_And_Register_Gui {

    private JFrame Home;
    private JTextField username;
    private JPasswordField password;
    private JButton login_register;
    private JButton change;
    private JLabel logo;

    /**
     * create new login / register page
     */
    public Login_And_Register_Gui(){
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 740);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/login.jpg")));
        addElement();
        Home.setVisible(true);
    }

    /**
     * add Elements to Login/Register page like username field , password field , login or register button , logo
     */
    public void addElement() {

        logo = new JLabel();
        logo.setLocation(450,0);
        logo.setSize(300,200);
        logo.setIcon(new ImageIcon("./PVS Design Kit/images/logo.png"));
        Home.add(logo);

        username = new JTextField("Username");
        username.setLocation(450, 280);
        username.setSize(300, 40);
        username.setFont(new Font("Arial",0,15));
        username.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        username.setBackground(new Color(0, 0, 0, 0));
        username.setOpaque(false);
        Home.add(username);

        password = new JPasswordField("Password");
        password.setLocation(450, 330);
        password.setSize(300, 40);
        password.setFont(new Font("Arial",0,15));
        password.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
        password.setBackground(new Color(0, 0, 0, 0));
        password.setOpaque(false);
        Home.add(password);

        login_register = new JButton("Login");
        login_register.setLocation(450,450);
        login_register.setSize(300,40);
        login_register.setFont(new Font("Arial",0,15));
        login_register.setOpaque(false);
        login_register.setContentAreaFilled(false);
        login_register.setBorderPainted(true);
        login_register.addActionListener(new ActionListener() {
            /**
             * login or register user
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                if (login_register.getText().equals("Login")){
                    // login
                    JOptionPane.showMessageDialog(Home,"Login Successfully","Welcome",JOptionPane.PLAIN_MESSAGE);
                    try {
                        Home.dispose();
                        GameSetting info = new GameSetting();
                        info.setUsername(username.getText());
                        info.setPassword(password.getText());
                        Menu_Gui next = new Menu_Gui(info);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    }
                }else {
                    // register account
                    JOptionPane.showMessageDialog(Home,"Account Created","Welcome",JOptionPane.PLAIN_MESSAGE);
                    try {
                        Home.dispose();
                        GameSetting info = new GameSetting();
                        info.setUsername(username.getText());
                        info.setPassword(password.getText());
                        Menu_Gui next = new Menu_Gui(info);
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    }
                }

            }
        });
        Home.add(login_register);

        change = new JButton("create an account");
        change.setLocation(450,490);
        change.setSize(300,40);
        change.setOpaque(false);
        change.setContentAreaFilled(false);
        change.setBorderPainted(false);
        change.addActionListener(new ActionListener() {
            /**
             * change text to register
             * @param e event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login_register.getText().equals("Login")){
                    login_register.setText("Register");
                    change.setText("I have an account");
                }else {
                    login_register.setText("Login");
                    change.setText("Create an account");
                }
                username.setText("Username");
                password.setText("Password");
            }
        });
        Home.add(change);
    }
}

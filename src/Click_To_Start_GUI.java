import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  -- Click To Start Gui --
 *
 *  this is Gui For first page
 *  first screen and click to start button
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

public class Click_To_Start_GUI {

    private JFrame Home;
    private JButton click;

    /**
     * create new Click To Start Frame and add Elements
     */
    public Click_To_Start_GUI() {
        Home = new JFrame("Plants Vs. Zombies");
        Home.setSize(1200, 785);
        Home.setLocationRelativeTo(null);
        Home.setLayout(null);
        Home.setResizable(false);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setContentPane(new JLabel(new ImageIcon("./PVS Design Kit/images/CnYlTj.jpg")));
        addElement();
        Home.setVisible(true);
    }

    /**
     * add Elements to Frame
     */
    public void addElement() {

        click = new JButton();
        click.setLocation(600, 530);
        click.setSize(431, 41);
        click.setIcon(new ImageIcon("./PVS Design Kit/images/Gifs/start2.gif"));
        click.setOpaque(false);
        click.setContentAreaFilled(false);
        click.setBorderPainted(false);
        click.addActionListener(new ActionListener() {
            /**
             * if button clicked then open login page
             * @param e event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Home.dispose();
                Login_And_Register_Gui next = new Login_And_Register_Gui();
            }
        });
        Home.add(click);
    }
}

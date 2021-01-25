/**
 *  -- Game Settings--
 *
 * in this class we have information for game like normal/hard mode or sound condition
 * we save settings in this class
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
public class GameSettings {

    private int sound;
    private int mode;
    private String username;
    private String password;

    /**
     *
     * create new information
     *
     * sound :    0 -> on        1 -> off
     * mode  :    0 -> Normal    1-> Hard
     */
    public GameSettings(){
        username = null;
        password = null;
        sound = 0;
        mode = 0;
    }

    /**
     * @return mode
     */
    public int getMode() {
        return mode;
    }

    /**
     * @return sound mode
     */
    public int getSound() {
        return sound;
    }

    /**
     * @return username of player
     */
    public String getUsername() {
        return username;
    }
    /**
     * @return password of player
     */
    public String getPassword() {
        return password;
    }
    /**
     * set mode for setting
     */
    public void setMode(int mode) {
        this.mode = mode;
    }
    /**
     * set sound mode for setting
     */
    public void setSound(int sound) {
        this.sound = sound;
    }
    /**
     * set username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * set password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

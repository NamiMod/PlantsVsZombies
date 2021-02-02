import java.io.*;
import java.net.Socket;
/**
 *  -- Change Request --
 *
 * in this class we send request code and data to server to change username or password of player
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
public class ChangeRequest {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;

    public int start(String username , String password , String newUsername , String newPassword) throws IOException {
        socket = new Socket("127.0.0.1", 5052);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            return (changeUsernameOrPassword(username,password,newUsername,newPassword));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
        finally {
            close();
        }
    }
    public int changeUsernameOrPassword(String username , String password ,
                                        String newUsername , String newPassword) throws IOException {
        output.println("3");
        output.println(username);
        output.println(password);
        output.println(newUsername);
        output.println(newPassword);
        output.flush();
        String response = read.readLine();
        return Integer.parseInt(response);
    }
    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
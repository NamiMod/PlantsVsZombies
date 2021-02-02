import java.io.*;
import java.net.Socket;
/**
 *  -- update request --
 *
 * in this class we send request code and data to server to update ranking
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
public class UpdateScoreRequest {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;

    public void start(String username , int mode , int WinOrLose) throws IOException {
        socket = new Socket("127.0.0.1", 5052);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            updateScore(username,mode,WinOrLose);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            close();
        }
    }

    /**
     * mode :  0 -> normal   1 -> hard
     * win or lose : 0 -> win   1 -> lose
     * @param username
     * @param mode
     * @param WinOrLose
     */
    public void updateScore(String username , int mode , int WinOrLose){
        output.println("4");
        output.println(username);
        output.println(mode);
        output.println(WinOrLose);
        output.flush();
    }

    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
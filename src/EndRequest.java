import java.io.*;
import java.net.Socket;
/**
 *  -- End request --
 *
 * in this class we send request to turn off the server
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
public class EndRequest {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;

    public void start(String username , int mode , int WinOrLose) throws IOException {
        socket = new Socket("127.0.0.1", 5050);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            output.println("-1");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            close();
        }
    }
    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
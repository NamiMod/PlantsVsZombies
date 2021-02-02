import java.io.*;
import java.net.Socket;
/**
 *  -- Client --
 *
 * in this class we send request code and data to server
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
public class Client {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;

    public void start(String username , String password) throws IOException {
        socket = new Socket("127.0.0.1", 7057);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            System.out.println(login(username,password));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int login(String username , String password) throws IOException {
        output.println("0");
        output.println(username);
        output.println(password);
        output.flush();
        String response = read.readLine();
        return Integer.parseInt(response);
    }

    public int register(String username , String password) throws IOException {
        output.println("1");
        output.println(username);
        output.println(password);
        output.flush();
        String response = read.readLine();
        return Integer.parseInt(response);
    }

    public String getRanking() throws IOException {
        output.println("2");
        output.flush();
        String response;
        response = read.readLine();
        return response;
    }

    public void updateScore(String username , int score){

    }

    public int changeUsernameOrPassword(String username , String password ,
                                        String newUsername , String newPassword) throws IOException {
        output.println("4");
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
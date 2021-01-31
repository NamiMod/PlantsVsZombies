import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  -- Server --
 *
 * in this class we get data and request code from client and call Handler class to handle it
 * send data to client
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
public class Server {

    private ServerSocket serversocket;
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;
    FileHandler file = new FileHandler();


    public static void main(String[] args){
        Server server = new Server();
        try {
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        serversocket = new ServerSocket(7049);
        System.out.println("Connection Starting on port:" + serversocket.getLocalPort());
        client = serversocket.accept();
        System.out.println("Waiting for connection from client");
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        try {
            handle();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handle() throws IOException {

        String code = input.readLine();

        if (code.equals("0")) {

            String username = input.readLine();
            String password = input.readLine();
            if (file.login(username, password)) {
                output.println("1");
            } else {
                output.println("0");
            }
        }
        if (code.equals("1")) {

            String username = input.readLine();
            String password = input.readLine();
            if (file.register(username, password)) {
                output.println("1");
            } else {
                output.println("0");
            }
        }
        if (code.equals("2")) {
            output.println(file.getRanking());
            System.out.println(file.getRanking());
        }

        output.flush();
        output.close();

    }

    public void close() throws IOException {
        serversocket.close();
    }
}

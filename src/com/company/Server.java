package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    /**
     * start server
     * @throws IOException cant read files
     */
    public void start() throws IOException {
        serversocket = new ServerSocket(5061);
        System.out.println("Connection Starting on port:" + serversocket.getLocalPort());
        while (true) {
            Socket client = serversocket.accept();
            System.out.println("Waiting for connection from client");
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            try {
                if (handle() == 1){
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("End");
        serversocket.close();
    }

    /**
     * handle request
     * @return result
     * @throws IOException cant read files
     */

    public int handle() throws IOException {

        String code = input.readLine();

        if (code.equals("-1")) {
            //exit from server
            output.flush();
            output.close();
            return 1;
        }

        if (code.equals("0")) {
            //login
            String username = input.readLine();
            String password = input.readLine();
            if (file.login(username, password) == 1) {
                output.println("1");
            } else {
                output.println("0");
            }
        }
        if (code.equals("1")) {
            //register new user
            String username = input.readLine();
            String password = input.readLine();
            if (file.register(username, password) == 1) {
                output.println("1");
            } else {
                output.println("0");
            }
        }
        if (code.equals("2")) {
            output.write("Data.txt");
        }
        if (code.equals("3")) {
            //change username or password
            String username = input.readLine();
            String password = input.readLine();
            String newUsername = input.readLine();
            String newPassword = input.readLine();
            if (file.changeUsernameOrPassword(username, password,newUsername,newPassword) == 1) {
                output.println("1");
            } else {
                output.println("0");
            }
        }
        if (code.equals("4")) {
            // update score
            String username = input.readLine();
            int mode = Integer.parseInt(input.readLine());
            int WinOrLose = Integer.parseInt(input.readLine());

            if (mode == 0) {

                if (WinOrLose == 0) {
                    file.updateScore(username, 3, 1, 0, 1, 0);
                } else {
                    file.updateScore(username, -1, 0, 1, 1, 0);
                }
            }

            if (mode == 1) {

                if (WinOrLose == 0) {
                    file.updateScore(username,10,1,0,0,1);
                } else {
                    file.updateScore(username,-3,0,1,0,1);
                }

            }
            file.sort();
        }

        if (code.equals("5")) {
            //save
        }

        if (code.equals("6")) {
            //load
        }

        output.flush();
        output.close();
        return 0;

    }

    /**
     * end of server
     * @throws IOException cant read file
     */
    public void close() throws IOException {
        serversocket.close();
    }
}
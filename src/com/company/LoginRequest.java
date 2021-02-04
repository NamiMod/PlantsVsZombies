package com.company;
import java.io.*;
import java.net.Socket;
/**
 *  -- Login Request --
 *
 * in this class we send login request code and data to server
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
public class LoginRequest {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;

    /**
     * @param username username
     * @param password password
     * @return result
     * @throws IOException cant read file
     */
    public int start(String username , String password) throws IOException {
        socket = new Socket("127.0.0.1", 5061);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            return login(username,password);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
        finally {
            close();
        }
    }

    /**
     * @param username username
     * @param password password
     * @return result
     * @throws IOException cant read file
     */
    public int login(String username , String password) throws IOException {
        output.println("0");
        output.println(username);
        output.println(password);
        output.flush();
        String response = read.readLine();
        return Integer.parseInt(response);
    }

    /**
     * close request
     * @throws IOException cant read file
     */
    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
package com.company;
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

    /**
     * send request to server
     * @param username username
     * @param password password
     * @param newUsername new username
     * @param newPassword new password
     * @return result of changing user or pass
     * @throws IOException when cant read file
     */
    public int start(String username , String password , String newUsername , String newPassword) throws IOException {
        socket = new Socket("127.0.0.1", 5061);
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

    /**
     * send information to server
     * @param username username
     * @param password password
     * @param newUsername new username
     * @param newPassword new password
     * @return result
     * @throws IOException when cant read file
     */
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

    /**
     * close request
     * @throws IOException when cant read file
     */
    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
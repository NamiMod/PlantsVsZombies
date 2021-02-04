package com.company;
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

    /**
     * send request
     * @param username username
     * @param mode mode
     * @param WinOrLose win or lose
     * @throws IOException cant read file
     */
    public void start(String username , int mode , int WinOrLose) throws IOException {
        socket = new Socket("127.0.0.1", 5061);
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
     * @param username username
     * @param mode mode
     * @param WinOrLose win or lose of game
     */
    public void updateScore(String username , int mode , int WinOrLose){
        output.println("4");
        output.println(username);
        output.println(mode);
        output.println(WinOrLose);
        output.flush();
    }

    /**
     * close request
     * @throws IOException
     */
    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
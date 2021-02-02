package com.company;
import java.io.*;
import java.net.Socket;
/**
 *  -- ranking request --
 *
 * in this class we send request code and data to server to get ranking from server
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
public class RankingRequest {

    private Socket socket;
    private BufferedReader read;
    private PrintWriter output;

    public String start() throws IOException {
        socket = new Socket("127.0.0.1", 5055);
        output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        try {
            return getRanking();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally {
            close();
        }
    }

    public String getRanking() throws IOException {
        FileHandler p = new FileHandler();
        output.println("2");
        output.flush();
        String response;
        response = read.readLine();
        return p.openRanking(response);
    }

    public void close() throws IOException {
        socket.close();
        read.close();
        output.close();
    }

}
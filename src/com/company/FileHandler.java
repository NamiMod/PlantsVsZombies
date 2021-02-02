package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  -- File Handler --
 *
 * in this class we handle file operation for server
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

public class FileHandler {

    /**
     * read ranking from data
     *
     * @return ranking
     * @throws IOException cant read or write file
     */
    public String getRanking() throws IOException {

        StringBuilder ranking = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("Data.txt");
            Scanner getString = new Scanner(fileReader);
            User user = new User("", "");

            while (getString.hasNextLine()) {

                user.setUsername(getString.nextLine());
                user.setPassword(getString.nextLine());
                user.setScore(Integer.parseInt(getString.nextLine()));
                user.setWin(Integer.parseInt(getString.nextLine()));
                user.setLose(Integer.parseInt(getString.nextLine()));
                user.setNormalGames(Integer.parseInt(getString.nextLine()));
                user.setHardGames(Integer.parseInt(getString.nextLine()));
                ranking.append(user.toString());
            }
            fileReader.close();
            getString.close();
            return ranking.toString();
        } catch (Exception e) {
            return "Cant Open File";
        }
    }

    /**
     * login user
     *
     * @param username username of player
     * @param password password of player
     * @return can in possible or not
     */
    public int login(String username, String password) {
        try {
            FileReader fileReader = new FileReader("Data.txt");
            Scanner getString = new Scanner(fileReader);
            User user = new User("", "");

            while (getString.hasNextLine()) {

                user.setUsername(getString.nextLine());
                user.setPassword(getString.nextLine());
                user.setScore(Integer.parseInt(getString.nextLine()));
                user.setWin(Integer.parseInt(getString.nextLine()));
                user.setLose(Integer.parseInt(getString.nextLine()));
                user.setNormalGames(Integer.parseInt(getString.nextLine()));
                user.setHardGames(Integer.parseInt(getString.nextLine()));
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    return 1;
                }
            }
            fileReader.close();
            getString.close();
            return 0;
        } catch (Exception e) {
            return -1;
        }

    }

    /**
     * register new user
     *
     * @param username new username
     * @param password new password
     * @return can it possible or not
     * @throws IOException when cant write in file
     */
    public int register(String username, String password) throws IOException {

        if (usable(username)) {
            User newUser = new User(username, password);
            FileWriter fw = new FileWriter("Data.txt", true);
            fw.write(newUser.getUsername() + "\n");
            fw.write(newUser.getPassword() + "\n");
            fw.write(newUser.getScore() + "\n");
            fw.write(newUser.getWin() + "\n");
            fw.write(newUser.getLose() + "\n");
            fw.write(newUser.getNormalGames() + "\n");
            fw.write(newUser.getHardGames() + "\n");
            fw.close();
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * check if new user's username usable or not
     *
     * @param username new username
     * @return possible or not
     */
    public boolean usable(String username) {
        try {
            FileReader fileReader = new FileReader("Data.txt");
            Scanner getString = new Scanner(fileReader);
            User user = new User("", "");

            while (getString.hasNextLine()) {

                user.setUsername(getString.nextLine());
                user.setPassword(getString.nextLine());
                user.setScore(Integer.parseInt(getString.nextLine()));
                user.setWin(Integer.parseInt(getString.nextLine()));
                user.setLose(Integer.parseInt(getString.nextLine()));
                user.setNormalGames(Integer.parseInt(getString.nextLine()));
                user.setHardGames(Integer.parseInt(getString.nextLine()));
                if (user.getUsername().equals(username)) {
                    return false;
                }
            }
            fileReader.close();
            getString.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * in this method we copy temp file to data file
     */
    public void copy() throws IOException {
        FileWriter copy = new FileWriter("Data.txt", false);
        FileReader fileReader = new FileReader("DataTemp.txt");
        Scanner getString = new Scanner(fileReader);

        while (getString.hasNextLine()) {
            copy.write(getString.nextLine() + '\n');
        }

        copy.close();
        fileReader.close();
        getString.close();
    }

    /**
     * in this method we add score to user score
     *
     * @param username player
     * @param score    score
     */
    public void updateScore(String username, int score, int win, int lose, int normal, int hard) {
        try {
            FileWriter clear = new FileWriter("DataTemp.txt", false);
            clear.write("");
            clear.close();
            FileWriter fw = new FileWriter("DataTemp.txt", true);
            FileReader fileReader = new FileReader("Data.txt");
            Scanner getString = new Scanner(fileReader);
            User user = new User("", "");

            while (getString.hasNextLine()) {

                user.setUsername(getString.nextLine());
                user.setPassword(getString.nextLine());
                user.setScore(Integer.parseInt(getString.nextLine()));
                user.setWin(Integer.parseInt(getString.nextLine()));
                user.setLose(Integer.parseInt(getString.nextLine()));
                user.setNormalGames(Integer.parseInt(getString.nextLine()));
                user.setHardGames(Integer.parseInt(getString.nextLine()));
                if (user.getUsername().equals(username)) {
                    user.setScore(user.getScore() + score);
                    user.setWin(user.getWin() + win);
                    user.setLose(user.getLose() + lose);
                    user.setNormalGames(user.getNormalGames() + normal);
                    user.setHardGames(user.getHardGames() + hard);
                }
                fw.write(user.getUsername() + "\n");
                fw.write(user.getPassword() + "\n");
                fw.write(user.getScore() + "\n");
                fw.write(user.getWin() + "\n");
                fw.write(user.getLose() + "\n");
                fw.write(user.getNormalGames() + "\n");
                fw.write(user.getHardGames() + "\n");
            }
            fileReader.close();
            getString.close();
            fw.close();
            copy();
        } catch (Exception e) {
            System.out.println("Cant read or write file");
        }
    }

    /**
     * change username of password if it's possible
     *
     *
     * @param s
     * @param username    old username
     * @param newUsername new username
     * @param newPassword new password
     * @return is it possible or not
     */
    public int changeUsernameOrPassword(String s, String username, String newUsername, String newPassword) {
        if (usable(newUsername)) {
            try {
                FileWriter clear = new FileWriter("DataTemp.txt", false);
                clear.write("");
                clear.close();
                FileWriter fw = new FileWriter("DataTemp.txt", true);
                FileReader fileReader = new FileReader("Data.txt");
                Scanner getString = new Scanner(fileReader);
                User user = new User("", "");

                while (getString.hasNextLine()) {

                    user.setUsername(getString.nextLine());
                    user.setPassword(getString.nextLine());
                    user.setScore(Integer.parseInt(getString.nextLine()));
                    user.setWin(Integer.parseInt(getString.nextLine()));
                    user.setLose(Integer.parseInt(getString.nextLine()));
                    user.setNormalGames(Integer.parseInt(getString.nextLine()));
                    user.setHardGames(Integer.parseInt(getString.nextLine()));
                    if (user.getUsername().equals(username)) {
                        user.setUsername(newUsername);
                        user.setPassword(newPassword);
                    }
                    fw.write(user.getUsername() + "\n");
                    fw.write(user.getPassword() + "\n");
                    fw.write(user.getScore() + "\n");
                    fw.write(user.getWin() + "\n");
                    fw.write(user.getLose() + "\n");
                    fw.write(user.getNormalGames() + "\n");
                    fw.write(user.getHardGames() + "\n");
                }
                fileReader.close();
                getString.close();
                fw.close();
                copy();
                return 1;
            } catch (Exception e) {
                return 0;
            }
        }
        return -1;
    }

    /**
     * sort ranking
     *
     * @throws IOException when cant open file
     */
    public void sort() throws IOException {

        ArrayList<User> users = new ArrayList<User>();
        FileReader fileReader = new FileReader("Data.txt");
        Scanner getString = new Scanner(fileReader);


        while (getString.hasNextLine()) {

            User user = new User("", "");

            user.setUsername(getString.nextLine());
            user.setPassword(getString.nextLine());
            user.setScore(Integer.parseInt(getString.nextLine()));
            user.setWin(Integer.parseInt(getString.nextLine()));
            user.setLose(Integer.parseInt(getString.nextLine()));
            user.setNormalGames(Integer.parseInt(getString.nextLine()));
            user.setHardGames(Integer.parseInt(getString.nextLine()));
            users.add(user);

        }


        User temp = new User("", "");

        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (users.get(i).getScore() > users.get(j).getScore()) {

                    temp.setUsername(users.get(j).getUsername());
                    temp.setPassword(users.get(j).getPassword());
                    temp.setScore(users.get(j).getScore());
                    temp.setWin(users.get(j).getWin());
                    temp.setLose(users.get(j).getLose());
                    temp.setNormalGames(users.get(j).getNormalGames());
                    temp.setHardGames(users.get(j).getHardGames());

                    users.get(j).setUsername(users.get(i).getUsername());
                    users.get(j).setPassword(users.get(i).getPassword());
                    users.get(j).setScore(users.get(i).getScore());
                    users.get(j).setWin(users.get(i).getWin());
                    users.get(j).setLose(users.get(i).getLose());
                    users.get(j).setNormalGames(users.get(i).getNormalGames());
                    users.get(j).setHardGames(users.get(i).getHardGames());

                    users.get(i).setUsername(temp.getUsername());
                    users.get(i).setPassword(temp.getPassword());
                    users.get(i).setScore(temp.getScore());
                    users.get(i).setWin(temp.getWin());
                    users.get(i).setLose(temp.getLose());
                    users.get(i).setNormalGames(temp.getNormalGames());
                    users.get(i).setHardGames(temp.getHardGames());


                }
                fileReader.close();
                getString.close();

                FileWriter fw1 = new FileWriter("Data.txt", false);
                fw1.write("");
                fw1.close();
                FileWriter fw = new FileWriter("Data.txt", true);
                for (User user1 : users) {

                    fw.write(user1.getUsername() + "\n");
                    fw.write(user1.getPassword() + "\n");
                    fw.write(user1.getScore() + "\n");
                    fw.write(user1.getWin() + "\n");
                    fw.write(user1.getLose() + "\n");
                    fw.write(user1.getNormalGames() + "\n");
                    fw.write(user1.getHardGames() + "\n");
                }

                fw.close();


            }
        }
    }

    /**
     * read ranking from data
     *
     * @return ranking
     * @throws IOException cant read or write file
     */
    public String openRanking(String name) throws IOException {

        int counter = 1;
        StringBuilder ranking = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(name);
            Scanner getString = new Scanner(fileReader);
            User user = new User("", "");

            while (getString.hasNextLine()) {

                ranking.append(counter+" ) ");
                user.setUsername(getString.nextLine());
                user.setPassword(getString.nextLine());
                user.setScore(Integer.parseInt(getString.nextLine()));
                user.setWin(Integer.parseInt(getString.nextLine()));
                user.setLose(Integer.parseInt(getString.nextLine()));
                user.setNormalGames(Integer.parseInt(getString.nextLine()));
                user.setHardGames(Integer.parseInt(getString.nextLine()));
                ranking.append(user.toString());
                counter++;
            }
            fileReader.close();
            getString.close();
            return ranking.toString();
        } catch (Exception e) {
            return "Cant Open File";
        }
    }

    /**
     * in this method we show all files in saves folder ( all saves )
     *
     * @param username of user
     * @return files name
     */
    public String getSaves(String username) {
        File folder = new File("./saves");
        File[] listOfFiles = folder.listFiles();
        String result="";
        int counter = 1;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (listOfFiles[i].getName().contains(username)) {
                    result = result + (counter + " ) " + listOfFiles[i].getName() + '\n');
                    counter++;
                }
            }
        }
        return result;
    }

    /**
     * in this method we get name and check is it available or not ?
     * @param list list of files
     * @param name name of file
     * @return is it available or not ?
     */
    public boolean isAvailable(String list,String name){
        return list.contains(name);
    }

    /**
     * in this method we can save game to file
     */
    public void save(){
        // ToDo : Write this method
    }

    /**
     * in this method we can load game from file with fileName
     * @param fileName name of save
     */
    public void load(String fileName){
        // ToDo : Write this method
    }


}

package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/*** In The Name of Allah ***/

/**
 * A very simple structure for the main game loop.
 * THIS IS NOT PERFECT, but works for most situations.
 * Note that to make this work, none of the 2 methods
 * in the while loop (update() and render()) should be
 * long running! Both must execute very quickly, without
 * any waiting and blocking!
 *
 * Detailed discussion on different game loop design
 * patterns is available in the following link:
 *    http://gameprogrammingpatterns.com/game-loop.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class GameLoop implements Runnable {


    /**
     * Frame Per Second.
     */
    private static final int FPS = 60;
    //The game frame
    private GameFrame canvas;
    //The game state
    private GameState state;

    /**
     * GameLoop constructor
     */
    GameLoop( GameState state) {
        canvas = state.getFrame();
        this.state = state;
    }

    /**
     * This must be called before the game loop starts.
     */
    void init() {

        state.setGameController(new GameController(state));
        state.getGameController().init();

        canvas.addMouseListener(state.getMouseListener());
        canvas.addMouseMotionListener(state.getMouseMotionListener());
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Elements clickedSun = getClickedSun(e.getX(), e.getY());
                MapCell thisCell = getClickedMapCell(e.getX(), e.getY());
                // here we check if player select the shovel and clicked on a occupied cell we should digging up the plant
                if (thisCell != null) {
                    if (state.isShovelSelected()) {
                        thisCell.dig();
                        state.setShovelSelected(false);
                        state.setCursor(null);
                    } else if (state.getSelectedPlant() != null && thisCell.isEmpty())
                        thisCell.plant();
                }
                // here we want to get the sun if player clicked on it
                if (clickedSun != null) {
                    clickedSun.clickAction();
                    if (clickedSun instanceof Sun) {
                        state.deleteElements(clickedSun);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        // game map is 5 * 9
        // here we create the map of the game
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 9; i++) {
                int[] cellPos = new int[2];
                cellPos[0] = 330 + (i * 80);
                cellPos[1] = 75 + (j * 95);
                state.addMapCell(new MapCell(cellPos, state));
            }
        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                makeSun();
            }

        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 10, state.getGameSetting().getSkySunTime());
    }

    /**
     * in this method we get the element that player clicked on it
     * if the element was a sun we should get it(but we do this in init method)
     * @param x the x coordinate of mouse click
     * @param y the y coordinate of mouse click
     * @return the element in selected position
     */
    private Elements getClickedSun(int x, int y) {
        for (int i = state.getElements().size() - 1; i >= 0; i--) {
            Elements element = state.getElements().get(i);
            if (
                    (x >= element.getPosition()[0] && x <= element.getPosition()[0] + element.getWidth()) &&
                            (y >= element.getPosition()[1] && y <= element.getPosition()[1] + element.getHeight())
            ) {
                return element;
            }
        }
        return null;
    }


    /**
     * find out the Item which is clicked on and if its not occupied
     * @param x the x coordinate of mouse click
     * @param y the y coordinate of mouse click
     * @return the cell in selected position
     */
    private MapCell getClickedMapCell(int x, int y) {
        for (MapCell cell : state.getMapCells()) {
            if (
                    (x >= cell.getPosition()[0] && x <= cell.getPosition()[0] + 75) &&
                            (y >= cell.getPosition()[1] && y <= cell.getPosition()[1] + 90)
            ) {
                return cell;
            }
        }
        return null;
    }

    /**
     * this method  make suns fall from the sky
     * The position of sun in the map is random
     */
    private void makeSun() {

        Random rand = new Random();
        int value = rand.nextInt(state.getMapCells().size());
        state.addElement(new Sun(state.getMapCells().get(value) , state ));

    }

    /**
     * check the end of the game
     */
    @Override
    public void run() {
        boolean gameOver = false;
        while (!gameOver) {
            try {
                gameOver = state.getGameOver();
                long start = System.currentTimeMillis();
                state.update();
                state.getGameController().update();
                canvas.render(state);

                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0)
                    Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
        canvas.dispose();
        state.stop();
        if(state.getDeadZombies() >= 30)
        {
            if (state.getGameSetting().getMode() == 0){
                try {
                    Score_Gui next = new Score_Gui(3,state.getGameSetting());
                    UpdateScoreRequest request = new UpdateScoreRequest();
                    request.start(state.getGameSetting().getUsername(),0,0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Score_Gui next = new Score_Gui(10,state.getGameSetting());
                    UpdateScoreRequest request = new UpdateScoreRequest();
                    request.start(state.getGameSetting().getUsername(),1,0);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            if (state.getGameSetting().getMode() == 0){
                try {
                    Score_Gui next = new Score_Gui(-1,state.getGameSetting());
                    UpdateScoreRequest request = new UpdateScoreRequest();
                    request.start(state.getGameSetting().getUsername(),0,1);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Score_Gui next = new Score_Gui(-3,state.getGameSetting());
                    UpdateScoreRequest request = new UpdateScoreRequest();
                    request.start(state.getGameSetting().getUsername(),1,1);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
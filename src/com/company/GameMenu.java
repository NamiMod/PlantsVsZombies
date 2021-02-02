package com.company;

 import javax.imageio.ImageIO;
 import javax.sound.sampled.LineUnavailableException;
 import javax.sound.sampled.UnsupportedAudioFileException;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
 import java.awt.geom.Ellipse2D;
 import java.awt.image.BufferedImage;
 import java.io.File;
 import java.io.IOException;


/**
 * selecting menu in the middle of the game
 */
public class GameMenu  {
     GameSetting state;
     JFrame frame ;
    /**
     * select menu constructor
     */

    public GameMenu(GameSetting state) {
        this.state=state;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("GameMenu");
                frame.setUndecorated(true);
                frame.setContentPane(new ContentPane());
                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /**
     * making a transparent frame
     */
    private class ContentPane extends JPanel {

        ContentPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    private class ImagePane extends JPanel {

        private BufferedImage background;
        private BufferedImage exitImage;
        private BufferedImage return2MenuImg;
        private BufferedImage continueImg;
        private Ellipse2D exitButton;
        private Ellipse2D return2MenuButton;
        private Ellipse2D continueButton;

        private Ellipse2D exitButton2;
        private Ellipse2D return2MenuButton2;
        private Ellipse2D continueButton2;

        private boolean mouseIn = false;

        ImagePane() {
            setOpaque(true);
            //initializing images for buttons


            background = (BufferedImage) Main.loadImage("SelectMenu.png");
            exitImage = (BufferedImage) Main.loadImage("button copy 3.jpg");
            return2MenuImg = (BufferedImage) Main.loadImage("button.jpg");
            continueImg = (BufferedImage) Main.loadImage("button copy.jpg");

            //initializing  buttons and placing them

            exitButton = new Ellipse2D.Float(110, 410, 50, 44);
            continueButton = new Ellipse2D.Float(110, 315, 50, 44);
            return2MenuButton = new Ellipse2D.Float(110, 265, 50, 44);


            exitButton2 = new Ellipse2D.Float(110, 405, 50, 44);
            continueButton2 = new Ellipse2D.Float(110, 310, 50, 44);
            return2MenuButton2 = new Ellipse2D.Float(110, 260, 50, 44);

            MouseAdapter handler = new MouseAdapter() {


                @Override
                public void mousePressed(MouseEvent e) {

                    Cursor cursor = Cursor.getDefaultCursor();
                    if (exitButton.contains(e.getPoint())) {
                        try {
                            frame.dispose();
                            System.exit(1);
                            Menu_Gui q = new Menu_Gui(state);
                        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException unsupportedAudioFileException) {
                            unsupportedAudioFileException.printStackTrace();
                        }
                    }
                    if (continueButton.contains(e.getPoint())) {//TODO : select the level and start from that

                        // Todo : save method

                    }
                    if (return2MenuButton.contains(e.getPoint())) {
                       frame.dispose();
                    }
                }

                @Override
                public void mouseMoved(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {

                }

            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        /**
         * get the exact size of the background
         * @return
         */
        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(400, 400) : new Dimension(background.getWidth(), background.getHeight());
        }

        /**
         * paint the frame and buttons
         * @param g
         */
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2d.drawImage(background, x, y, this);
                if (mouseIn && exitImage != null) {
                    g2d.drawImage(exitImage, (int) exitButton2.getX(), (int) exitButton2.getY(), this);
                    g2d.drawImage(return2MenuImg, (int) return2MenuButton2.getX(), (int)return2MenuButton2.getY(), this);
                    g2d.drawImage(continueImg, (int) continueButton2.getX(), (int) continueButton2.getY(), this);

                }

                if(!mouseIn){

                    g2d.drawImage(exitImage, (int) exitButton.getX(), (int) exitButton.getY(), this);
                    g2d.drawImage(return2MenuImg, (int) return2MenuButton.getX(), (int)return2MenuButton.getY(), this);
                    g2d.drawImage(continueImg, (int) continueButton.getX(), (int) continueButton.getY(), this);

                }
                g2d.dispose();
            }
        }
    }
}

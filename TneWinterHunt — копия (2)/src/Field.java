import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Field extends JPanel {

    private Image header;
    private Image background;
    public Image missionComplete;
    public int x = 350;
    public int complexity;
    private Gift[] gameGift;
    private Image endGame;

    public Timer timerUpdate;

    public Timer timerDraw;

    public Field(int complexity) {
        this.complexity = complexity;

        try {
            background = ImageIO.read(new File("C:\\Игра\\background.png"));
            missionComplete = ImageIO.read(new File("C:\\Игра\\missionComplete.png"));

            if (complexity == 1) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame4.jpg"));
                header = ImageIO.read(new File("C:\\Игра\\header.jpg"));
            }

            if (complexity == 2) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame5.jpg"));
                header = ImageIO.read(new File("C:\\Игра\\header2.jpg"));
            }

            if (complexity == 3) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame.jpg"));
                header = ImageIO.read(new File("C:\\Игра\\header5.jpg"));
            }
            if (complexity == 4) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame2.gif"));
                header = ImageIO.read(new File("C:\\Игра\\header1.jpg"));
            }
            if (complexity == 5) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame6.gif"));
                header = ImageIO.read(new File("C:\\Игра\\header4.jpg"));
            }
            if (complexity == 6) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame7.jpg"));
                header = ImageIO.read(new File("C:\\Игра\\header3.jpg"));
            }
            if (complexity == 7) {
                endGame = ImageIO.read(new File("C:\\Игра\\endGame3.jpg"));
                header = ImageIO.read(new File("C:\\Игра\\header6.jpg"));
            }
        } catch (IOException e) {
            System.out.println("Неверный путь к файлу");
        }

        gameGift = new Gift[8];
        for (int i = 0; i < 8; i++) {
            try {
                gameGift[i] = new Gift(ImageIO.read(new File("C:\\Игра\\p" + i + ".png")));
            } catch (Exception e) {
                System.out.println("Ошибка загрузки подарков");
            }
        }


        if (complexity == 1) {
            timerUpdate = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        if (complexity == 2) {
            timerUpdate = new Timer(2750, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        if (complexity == 3) {
            timerUpdate = new Timer(2500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        if (complexity == 4) {
            timerUpdate = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        if (complexity == 5) {
            timerUpdate = new Timer(1750, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        if (complexity == 6) {
            timerUpdate = new Timer(1500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        if (complexity == 7) {
            timerUpdate = new Timer(1200, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateStart();

                }
            });
        }

        timerUpdate.start();


        timerDraw = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });


        timerDraw.start();

    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(header, 0, 0, null);
        graphics.drawImage(background, x, 465, null);

        for (int i = 0; i < 8; i++) {
            gameGift[i].draw(graphics);

            if (gameGift[i].action == true) {
                if (gameGift[i].y + gameGift[i].image.getHeight(null) >= 470) {
                    if (Math.abs(gameGift[i].x - x) > 75) {
                        graphics.drawImage(endGame, 0, 0, null);
                        timerDraw.stop();
                        timerUpdate.stop();
                        break;
                    } else {
                        gameGift[i].action = false;
                    }


                }

            }
        }

    }


    private void updateStart() {

        int amount = 0;

        for (int i = 0; i < 8; i++) {
            if (gameGift[i].action == false) {

                if (amount < complexity) {
                    gameGift[i].start();
                    break;
                }
            } else {
                amount++;
            }
        }

    }

}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Window extends JFrame {

    private Field gameField;

    private class MyKey implements KeyListener {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == 27) {
                System.exit(0);
            } else if (key == 37) {

                if (gameField.x - 50 > -48) {
                    gameField.x = gameField.x - 50;
                } else {
                    gameField.x = 752;
                }
            } else if (key == 39) {

                if (gameField.x + 50 < 752) {
                    gameField.x = gameField.x + 50;
                } else {
                    gameField.x = -48;
                }

            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public Window(int complexity) {
        addKeyListener(new MyKey());
        setFocusable(true);
        setFocusable(true);
        setBounds(0, 0, 800, 600);
        setTitle("Игра: Новогодний дождь");
        gameField = new Field(complexity);
        Container container = getContentPane();
        container.add(gameField);
        setVisible(true);


    }
}

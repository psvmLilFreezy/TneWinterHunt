import javax.swing.*;// работа с окнами
import java.awt.*;// работа с графикой
import java.awt.event.*;// обработка событий


public class Gift {
    public Image image;
    public int x;
    public int y;
    public boolean action;
    private Timer timerUpdate;


    public Gift(Image image) {
        timerUpdate = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                down();
            }
        });

        this.image = image;
        action = false;
    }

    public void start() {
        timerUpdate.start();
        y = 0;
        x = (int) (Math.random() * 700);
        action = true;
    }

    public void down() {

        if (action == true) {
            y = y + 30;
        }

        if((y +image.getHeight(null))>=470)

        {
            timerUpdate.stop();

        }

    }


    public void draw(Graphics graphics) {
        if (action == true) {
            graphics.drawImage(image, x, y, null);
        }
    }
}

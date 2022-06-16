import javax.swing.*;
import java.util.Arrays.*;

public class Game {

    public static void main(String[] args) {

        String title = JOptionPane.showInputDialog(null,"Введите сложность игры от 1 до 7:",
                "Сложность игры",1);

        int complexity = title.charAt(0) - '0';

        if ((complexity >= 1) && (complexity <= 7)) {
            Window window = new Window(complexity);
        } else {
            System.out.println("Вы ввели неверное значение сложности!");
        }



    }
}


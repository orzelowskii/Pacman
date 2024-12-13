import javax.swing.*;

public class Pacman {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuFrame();
            }
        });



    }
}
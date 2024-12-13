import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    JLabel jLabel4;
    public MenuFrame(){
        ImageIcon pacman1 = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman2.jpeg");
        pacman1.getImage().getScaledInstance(1350,200,Image.SCALE_SMOOTH);
        generateMenu();
    }

    private void generateMenu() {

        setSize(1200,1000);
        setBackground(Color.DARK_GRAY);

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.BLACK);

        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.BLACK);
        JPanel jPanel3 = new JPanel();
        jPanel3.setBackground(Color.BLACK);
        JPanel jPanel4 = new JPanel();
        jPanel4.setBackground(Color.BLACK);

        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        ImageIcon imageIcon4 = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacmannormal.jpeg");
        imageIcon4.getImage().getScaledInstance(1,1,Image.SCALE_DEFAULT);
        jLabel2.setIcon(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacmanandghosts.jpeg"));
        jLabel3.setIcon(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacmanandghosts-kopia.jpeg"));
        jLabel4.setIcon(imageIcon4);


        JButton newGame = new JButton("New Game");
        JButton highScores = new JButton("High Scores");
        JButton exit = new JButton("EXIT");
        newGame.setForeground(Color.BLUE);
        highScores.setForeground(Color.BLUE);
        exit.setForeground(Color.BLUE);
        newGame.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardSize boardSize = new BoardSize();
                boardSize.setVisible(true);
            }
        });
        highScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HighScores highScores = new HighScores();
                highScores.setVisible(true);

            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jPanel.add(newGame);
        jPanel.add(highScores);
        jPanel.add(exit);
        jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
        jPanel.setBounds(500,500,500,500);
        jPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel jLabel = new JLabel("MENU");
        jLabel.setVerticalTextPosition(JLabel.CENTER);
        jLabel.setHorizontalTextPosition(JLabel.CENTER);
        jLabel.setBackground(Color.BLACK);
        jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(jPanel,BorderLayout.CENTER);
        add(jLabel2,BorderLayout.EAST);
        add(jLabel3,BorderLayout.WEST);
        add(jLabel4,BorderLayout.SOUTH);
        add(jLabel,BorderLayout.NORTH);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

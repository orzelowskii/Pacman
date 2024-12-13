import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class NicksFrame extends JFrame {

    private String nick;
    private int points;
    Vector<Scorer> scorers;

    public NicksFrame(int points){
        this.points = points;
        generateFrame();
    }

    private void generateFrame() {

        scorers = new Vector<>();

        setName("GAME OVER");
        setSize(500,100);

        JPanel jPanel = new JPanel();

        JLabel jLabel = new JLabel("Podaj swoj nick: ");
        JTextField jTextField = new JTextField(20);
        JButton jButton = new JButton("Zapisz");

        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jLabel.setLayout(new FlowLayout());

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nick = jTextField.getText();
                Scorer scorer = new Scorer(nick,points);
                scorers.add(scorer);
                MenuFrame menuFrame = new MenuFrame();
                dispose();

            }
        });

        add(jPanel);



        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

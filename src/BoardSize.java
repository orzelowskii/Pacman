import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BoardSize extends JFrame {

    private int rowSize = 55;
    private int columnSize = 55;

    public BoardSize(){


        setSize(1000,200);

        JSlider jSlider = new JSlider(JSlider.HORIZONTAL,10,100,55);
        JSlider jSlider2 = new JSlider(JSlider.HORIZONTAL,10,100,55);
        jSlider.setMajorTickSpacing(10);
        jSlider.setMinorTickSpacing(5);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        jSlider2.setMajorTickSpacing(10);
        jSlider2.setMinorTickSpacing(5);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);
        JLabel jLabel = new JLabel("Rozmiar tablicy: " + rowSize + "x" + columnSize);
        add(jLabel);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider) e.getSource();
                rowSize = jSlider.getValue();
                jLabel.setText("Rozmiar tablicy: " + rowSize + "x" + columnSize);
            }
        });
        jSlider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider s2 = (JSlider) e.getSource();
                columnSize = jSlider2.getValue();
                jLabel.setText("Rozmiar tablicy: " + rowSize + "x" + columnSize);
            }
        });
        setLayout(new FlowLayout());
        add(jSlider);
        add(jSlider2);

        JButton jButton = new JButton("OK");
        add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame gameFrame = new GameFrame(rowSize,columnSize);
                Thread thread = new Thread(gameFrame);
                thread.start();
                gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                gameFrame.setVisible(true);
                dispose();
            }
        });


        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Vector;

public class HighScores extends JFrame implements Serializable {
    public HighScores(){

        Vector<Scorer> scorers = new Vector<>();
        Scorer scorer1 = new Scorer("kuba",1635);
        Scorer scorer2 = new Scorer("Adam",635);
        Scorer scorer3 = new Scorer("Orzel",235);
        scorers.add(scorer1);
        scorers.add(scorer2);
        scorers.add(scorer3);

        setSize(200,200);

        ListModel listModel = new ListModel(scorers);
        JList jList = new JList<>();

        jList.setModel(listModel);


        JScrollPane jScrollPane = new JScrollPane(jList);

        JButton jButton = new JButton("Wstecz");
        setLayout(new BorderLayout());
        add(jScrollPane,BorderLayout.CENTER);
        add(jButton,BorderLayout.PAGE_END);
        jButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void add(Scorer scorer){

    }



}

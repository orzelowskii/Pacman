import javax.swing.*;
import java.util.Vector;

public class ListModel extends AbstractListModel {

    public Vector<Scorer> scorers;


    public ListModel(Vector<Scorer> nicks) {
        this.scorers = nicks;
    }

    @Override
    public int getSize() {
        return scorers.size();
    }

    @Override
    public Object getElementAt(int index) {
        return scorers.get(index);
    }


    public void add(Scorer scorer){
        for(int i = 0;i< scorers.size();i++){
            if(scorer.score > scorers.get(i).score){
                scorers.add(i,scorer);
                fireIntervalAdded(this,i,i);
            }
        }
    }

}

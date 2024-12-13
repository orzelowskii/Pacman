import javax.swing.*;
import java.awt.*;

public class Ghost1 extends Thread {

    ImageIcon ghost;
    int currentRow;
    int currentColumn;
    JTable jTable;
    int[][] maze;
    boolean isRunning = true;

    public Ghost1(JTable jTable, ImageIcon ghost, int currentRow, int currentColumn, int[][] maze) {
        this.jTable = jTable;
        this.ghost = ghost;
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
        this.maze = maze;
    }

    @Override
    public void run() {

        int newRow=0;
        int newColumn=0;

        while (isRunning) {
            try {
                Thread.sleep(500);

                int direction = (int)(Math.random()*4)+1;

                newRow = currentRow;
                newColumn = currentColumn;

                if (direction == 1) {
                    newRow--;
                } else if (direction == 2) {
                    newRow++;
                } else if (direction == 3) {
                    newColumn--;
                } else if (direction == 4) {
                    newColumn++;
                }


                if (newRow >= 0 && newRow < maze.length && newColumn >= 0 && newColumn < maze[0].length && maze[newRow][newColumn] != 1) {
                    if(jTable.getValueAt(currentRow,currentColumn).equals("")){
                        jTable.setValueAt(new ImageIcon(""), currentRow, currentColumn);
                    }else {
                        jTable.setValueAt(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg"), currentRow, currentColumn);
                    }
                    jTable.setValueAt(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost1.jpg"), newRow, newColumn);
                    jTable.repaint();
                    jTable.getCellRenderer(currentRow, currentColumn).getTableCellRendererComponent(jTable, null, false, false, currentRow, currentColumn).setBackground(Color.BLACK);


                    currentRow = newRow;
                    currentColumn = newColumn;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }
}

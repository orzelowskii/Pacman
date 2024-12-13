import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements Runnable, KeyListener {

    private int[][] maze;
    JTable jTable;
    private int minute = 0;
    private int secunde = 0;
    private int lives = 3;
    private int points = 0;
    private boolean tmp = true;
    private boolean isRunning = true;
    PacmanImage pacman;
    private JLabel timeLabel;
    private JLabel lifesLabel;
    private JLabel pointsLabel;
    Ghost1 ghost1;
    Ghost2 ghost2;
    Ghost3 ghost3;
    Ghost4 ghost4;
    public GameFrame(int rowSize,int columnSize){

        maze = new int[rowSize][columnSize];
        for(int i = 0;i< maze.length;i++){
            for(int j = 0;j< maze[i].length;j++){
                if(i == 0 && j == 4){
                    maze[i][j] = 11;
                } else if (i == 0 && j == 6) {
                    maze[i][j] = 12;
                } else if (i == 0 && j == 8) {
                    maze[i][j] = 13;
                } else if (i == 0 && j == 10) {
                    maze[i][j] = 14;
                } else if(i == 0 && j == 0){
                    maze[i][j] = 2;
                }else {
                    maze[i][j] = 0;
                }
            }
        }

        pacman = new PacmanImage(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_right.jpg"),0,0);

        pacman = new PacmanImage(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_right.jpg"),0,0);

        MazeGenerate mazeGenerate = new MazeGenerate();
        maze = mazeGenerate.mazeGenerator(maze);
        setLayout(new BorderLayout());

        timeLabel = new JLabel(minute + ":" + "0" + secunde + "     ");
        lifesLabel = new JLabel("zycia: " + lives + "       ");
        pointsLabel = new JLabel("Punkty: " + points + "        ");

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new FlowLayout());
        jPanel1.add(timeLabel);
        jPanel1.add(lifesLabel);
        jPanel1.add(pointsLabel);

        jTable = new JTable(){
            @Override
            public boolean isCellSelected(int row, int column) {
                return false;
            }
        };
        jTable.setModel(new TableModel(maze));
        jTable.setBackground(Color.black);

        ImagesTable convertt = new ImagesTable();
        jTable = convertt.convertTable(jTable);

        jTable.setCellSelectionEnabled(false);
        jTable.addKeyListener(this);
        jTable.setFocusable(true);

        add(jTable,BorderLayout.CENTER);
        add(jPanel1,BorderLayout.NORTH);

        setSize(1200,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ghost1 = new Ghost1(jTable,new ImageIcon(),0,4,maze);
        ghost2 = new Ghost2(jTable,new ImageIcon(),0,6,maze);
        ghost3 = new Ghost3(jTable,new ImageIcon(),0,8,maze);
        ghost4 = new Ghost4(jTable,new ImageIcon(),0,10,maze);
        Thread thread1 = new Thread(ghost1);
        Thread thread2 = new Thread(ghost2);
        Thread thread3 = new Thread(ghost3);
        Thread thread4 = new Thread(ghost4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Collision collision = new Collision(this,pacman,ghost1,ghost2,ghost3,ghost4);
        Thread thread = new Thread(collision);
        thread.start();

    }

    public void pacmanGoUp() {
        int selectedRow = jTable.getSelectedRow();
        int selectedColumn = jTable.getSelectedColumn();

        if (selectedRow > 0 && maze[selectedRow - 1][selectedColumn] != 1) {
                ImageIcon previousIcon = (ImageIcon) jTable.getValueAt(selectedRow - 1, selectedColumn);
                String previousFilename = previousIcon.getDescription();
                if (previousFilename.equals("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg")) {
                    points += 10;
                    pointsLabel.setText("Punkty: " + points + "        ");
                }
            jTable.setValueAt(new ImageIcon(""), selectedRow, selectedColumn);
            jTable.getCellRenderer(selectedRow, selectedColumn).getTableCellRendererComponent(jTable, null, false, false, selectedRow, selectedColumn).setBackground(Color.BLACK);
            jTable.setValueAt(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_up.jpg"), selectedRow - 1, selectedColumn);
            pacman.setCurrentRow(selectedRow-1);
            pacman.setCurrentColumn(selectedColumn);

        }
    }

    public void pacmanGoDown() {
        int selectedRow = jTable.getSelectedRow();
        int selectedColumn = jTable.getSelectedColumn();

        if (selectedRow < jTable.getRowCount() - 1 && maze[selectedRow + 1][selectedColumn] != 1) {
                ImageIcon previousIcon = (ImageIcon) jTable.getValueAt(selectedRow + 1, selectedColumn);
                String previousFilename = previousIcon.getDescription();
                if (previousFilename.equals("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg")) {
                    points += 10;
                    pointsLabel.setText("Punkty: " + points + "        ");
                }
            jTable.setValueAt(new ImageIcon(""), selectedRow, selectedColumn);
            jTable.getCellRenderer(selectedRow, selectedColumn).getTableCellRendererComponent(jTable, null, false, false, selectedRow, selectedColumn).setBackground(Color.BLACK);
            jTable.setValueAt(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_down.jpg"), selectedRow + 1, selectedColumn);
            pacman.setCurrentRow(selectedRow+1);
            pacman.setCurrentColumn(selectedColumn);
        }
    }

    public void pacmanGoLeft() {
        int selectedRow = jTable.getSelectedRow();
        int selectedColumn = jTable.getSelectedColumn();

        if (selectedColumn > 0 && maze[selectedRow][selectedColumn - 1] != 1) {
                ImageIcon previousIcon = (ImageIcon) jTable.getValueAt(selectedRow , selectedColumn-1);
                String previousFilename = previousIcon.getDescription();
                if (previousFilename.equals("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg")) {
                    points += 10;
                    pointsLabel.setText("Punkty: " + points + "        ");
                }
            jTable.setValueAt(new ImageIcon(""), selectedRow, selectedColumn);
            jTable.getCellRenderer(selectedRow, selectedColumn).getTableCellRendererComponent(jTable, null, false, false, selectedRow, selectedColumn).setBackground(Color.BLACK);
            jTable.setValueAt(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_left.jpg"), selectedRow, selectedColumn - 1);
            pacman.setCurrentRow(selectedRow);
            pacman.setCurrentColumn(selectedColumn-1);
        }
    }

    public void pacmanGoRight() {
        int selectedRow = jTable.getSelectedRow();
        int selectedColumn = jTable.getSelectedColumn();

        if (selectedColumn < jTable.getColumnCount() - 1 && maze[selectedRow][selectedColumn + 1] != 1) {
                ImageIcon previousIcon = (ImageIcon) jTable.getValueAt(selectedRow , selectedColumn+1);
                String previousFilename = previousIcon.getDescription();
                if (previousFilename.equals("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg")) {
                    points += 10;
                    pointsLabel.setText("Punkty: " + points + "        ");
                }
            jTable.setValueAt(new ImageIcon(""), selectedRow, selectedColumn);
            jTable.getCellRenderer(selectedRow, selectedColumn).getTableCellRendererComponent(jTable, null, false, false, selectedRow, selectedColumn).setBackground(Color.BLACK);
            jTable.setValueAt(new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_right.jpg"), selectedRow, selectedColumn + 1);
            pacman.setCurrentRow(selectedRow);
            pacman.setCurrentColumn(selectedColumn+1);
        }

    }


    @Override
    public void run() {
        while (isRunning){
            try {
                Thread.sleep(1000);
                if(!tmp){
                    break;
                }
                if(secunde == 59){
                    secunde = 0;
                    minute++;
                    timeLabel.setText(minute + ":" + "0" + secunde + "     ");
                    if(!tmp){
                        break;
                    }
                } else{
                    secunde++;
                    if(secunde<10){
                        timeLabel.setText(minute + ":" + "0" + secunde + "     ");
                    }else {
                        timeLabel.setText(minute + ":" + secunde + "     ");
                    }
                    if(!tmp){
                        break;
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_UP:
                    pacmanGoUp();
                    break;

            case KeyEvent.VK_DOWN:
                    pacmanGoDown();
                    break;


            case KeyEvent.VK_LEFT:
                    pacmanGoLeft();
                    break;

            case KeyEvent.VK_RIGHT:
                    pacmanGoRight();
                    break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setLives(int lives) {
        lifesLabel.setText("zycia: " + lives + "       ");
    }


    public void stopGame() {
        isRunning = false;
        ghost1.isRunning = false;
        ghost2.isRunning = false;
        ghost3.isRunning = false;
        ghost4.isRunning = false;
        NicksFrame nicksFrame = new NicksFrame(points);
        nicksFrame.setVisible(true);
    }

}

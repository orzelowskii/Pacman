import javax.swing.*;

public class Collision extends Thread {

    GameFrame gameFrame;
    PacmanImage pacmanImage;
    Ghost1 ghost1;
    Ghost2 ghost2;
    Ghost3 ghost3;
    Ghost4 ghost4;
    int lives = 3;


    public Collision(GameFrame gameFrame, PacmanImage pacmanImage, Ghost1 ghost1, Ghost2 ghost2, Ghost3 ghost3, Ghost4 ghost4) {
        this.gameFrame = gameFrame;
        this.pacmanImage = pacmanImage;
        this.ghost1 = ghost1;
        this.ghost2 = ghost2;
        this.ghost3 = ghost3;
        this.ghost4 = ghost4;
    }

    @Override
    public void run() {
        boolean collision;
        while (true) {
            try {
                Thread.sleep(500);
                collision = check(pacmanImage.currentRow, pacmanImage.currentColumn, ghost1.currentRow, ghost1.currentColumn, ghost2.currentRow, ghost2.currentColumn, ghost3.currentRow, ghost3.currentColumn, ghost4.currentRow, ghost4.currentColumn);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean check(int pacmanRow, int pacmanColumn, int ghost1Row, int ghost1Column, int ghost2Row, int ghost2Column, int ghost3Row, int ghost3Column, int ghost4Row, int ghost4Column) {
        boolean collison = false;

        pacmanRow = pacmanImage.getCurrentRow();
        pacmanColumn = pacmanImage.getCurrentColumn();
        ghost1Row = ghost1.getCurrentRow();
        ghost2Row = ghost2.getCurrentRow();
        ghost3Row = ghost3.getCurrentRow();
        ghost4Row = ghost4.getCurrentRow();
        ghost1Column = ghost1.getCurrentColumn();
        ghost2Column = ghost2.getCurrentColumn();
        ghost3Column = ghost3.getCurrentColumn();
        ghost4Column = ghost4.getCurrentColumn();

        if (pacmanRow == ghost1Row && pacmanColumn == ghost1Column) {
            lives--;
            gameFrame.setLives(lives);
            collison = true;
            if (lives == 0) {
                gameFrame.stopGame();
            }
        } else if (pacmanRow == ghost2Row && pacmanColumn == ghost2Column) {
            lives--;
            gameFrame.setLives(lives);
            collison = true;
            if (lives == 0) {
                gameFrame.stopGame();
            } else if (pacmanRow == ghost3Row && pacmanColumn == ghost3Column) {
                lives--;
                gameFrame.setLives(lives);
                collison = true;
                if (lives == 0) {
                    gameFrame.stopGame();
                } else if (pacmanRow == ghost4Row && pacmanColumn == ghost4Column) {
                    lives--;
                    gameFrame.setLives(lives);
                    collison = true;
                    if (lives == 0) {
                        gameFrame.stopGame();
                    }

                }
            }
        }
        return collison;
    }
}





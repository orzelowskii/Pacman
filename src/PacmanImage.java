import javax.swing.*;

public class PacmanImage {
    ImageIcon pacman;
    int currentRow;
    int currentColumn;

    public PacmanImage(ImageIcon pacman, int currentRow, int currentColumn) {
        this.pacman = pacman;
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }
}

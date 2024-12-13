import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TableModel extends AbstractTableModel {

    private int[][] cell;

    public TableModel(int[][] cell) {
        this.cell = cell;
    }

    @Override
    public int getRowCount() {
        return cell.length;
    }

    @Override
    public int getColumnCount() {
        return cell[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return cell[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        cell[rowIndex][columnIndex] = (Integer) aValue;
        fireTableCellUpdated(rowIndex,columnIndex);
    }

}

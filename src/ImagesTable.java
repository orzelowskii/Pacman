import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class ImagesTable {
    public JTable convertTable(JTable intTable) {
        int rowCount = intTable.getRowCount();
        int columnCount = intTable.getColumnCount();

        Object[][] intData = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                intData[i][j] = intTable.getValueAt(i, j);
            }
        }

        Object[][] imageData = convertIntToImage(intData);

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                return ImageIcon.class;
            }
        };

        JTable imageTable = new JTable(model);
        model.setDataVector(imageData, getColumnNames(intTable));

        adjustColumnWidths(imageTable);
        setCellRenderer(imageTable);

        return imageTable;
    }

    private static Object[][] convertIntToImage(Object[][] intData) {
        int rowCount = intData.length;
        int columnCount = intData[0].length;

        Object[][] imageData = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                int value = (int) intData[i][j];

                ImageIcon imageIcon = createImageIconFromInt(value);
                imageData[i][j] = imageIcon;
            }
        }
        return imageData;
    }

    private static ImageIcon createImageIconFromInt(int value) {
        String imagePath = getImagePathForValue(value);
        ImageIcon imageIcon = new ImageIcon(imagePath);
        return imageIcon;
    }

    private static String getImagePathForValue(int value) {

        if(value == 11){
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost1.jpg";
        } else if (value == 12) {
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost2.jpg";
        } else if (value == 13) {
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost3.jpg";
        } else if (value == 14) {
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost4.jpg";
        }else if(value == 2){
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/pacman_mini_right.jpg";
        }else if (value == 0) {
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg";
        }  else {
            return "/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/Kropka_niebieska.jpeg";
        }
    }

    private static String[] getColumnNames(JTable table) {
        int columnCount = table.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = table.getColumnName(i);
        }
        return columnNames;
    }

    private static void adjustColumnWidths(JTable table) {
        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setWidth(80-table.getColumnCount());
            column.setPreferredWidth(80-table.getColumnCount());
            column.setMaxWidth(80-table.getColumnCount());
            column.setMinWidth(80-table.getColumnCount());
        }

    }
    public static void setCellRenderer(JTable table) {
        ImageIcon black = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/nowa_kropka.jpeg");
        ImageIcon blue = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/Kropka_niebieska.jpeg");
        ImageIcon empty = new ImageIcon("");
        ImageIcon ghost1 = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost1.jpg");
        ImageIcon ghost2 = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost2.jpg");
        ImageIcon ghost3 = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost3.jpg");
        ImageIcon ghost4 = new ImageIcon("/Users/jakuborzelowski/Documents/Java/Projekt_2/src/Images/ghost4.jpg");

        black.getImage().getScaledInstance(100/table.getColumnCount(),100/table.getRowCount(),Image.SCALE_SMOOTH);
        blue.getImage().getScaledInstance(10,10,Image.SCALE_SMOOTH);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


                if (value instanceof ImageIcon) {
                    ImageIcon cellIcon = (ImageIcon) value;
                    if (cellIcon.getImage() != null) {
                        if (cellIcon.getImage().equals(black.getImage())) {
                            setBackground(Color.BLACK);
                            setForeground(Color.black);
                            isSelected = false;
                        } else if (cellIcon.getImage().equals(ghost1.getImage()) || cellIcon.getImage().equals(ghost2.getImage()) || cellIcon.getImage().equals(ghost3.getImage()) || cellIcon.getImage().equals(ghost4.getImage())) {
                            setBackground(Color.BLACK);
                            setForeground(Color.black);
                        } else if (cellIcon.getImage().equals(blue.getImage())) {
                            setBackground(Color.BLUE);
                            setForeground(Color.blue);
                            isSelected = false;
                        } else if (cellIcon.getImage().equals(empty.getImage())) {
                            setBackground(Color.BLACK);
                            setForeground(Color.black);
                        }
                    }
                    } else {
                        setBackground(Color.black);
                        setForeground(Color.black);
                        isSelected = false;
                    }
                    isSelected = false;
                    setIcon((ImageIcon) value);
                    setText(null);

                    return cellComponent;
                }
        };


        int columnCount = table.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }
}


package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AlternatingRowColorRenderer extends DefaultTableCellRenderer {
    private static final Color EVEN_COLOR = Color.WHITE;
    private static final Color ODD_COLOR = new Color(215, 244, 247); // Light gray

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row % 2 == 0) {
            cellComponent.setBackground(EVEN_COLOR);
        } else {
            cellComponent.setBackground(ODD_COLOR);
        }

        return cellComponent;
    }
}
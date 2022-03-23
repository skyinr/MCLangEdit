package skyinr.github;

import javax.swing.*;
import java.awt.*;

public class MCLangTable extends JTable {
    public MCLangTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        Init();
    }

    private void Init(){
        this.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        this.getTableHeader().setForeground(Color.RED);
        this.getTableHeader().setResizingAllowed(true);
        this.getTableHeader().setReorderingAllowed(true);
//        this.setPreferredScrollableViewportSize(new Dimension(400, 300));
        this.setRowHeight(30);
        MCLangEdit.jPanel.revalidate();
    }
}

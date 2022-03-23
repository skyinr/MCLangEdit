package skyinr.github.event;

import skyinr.github.unit.AddTable;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

public class CopyField extends TransferHandler {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean importData(JComponent comp, Transferable t) {
        try {
            Object o = t.getTransferData(DataFlavor.javaFileListFlavor);

            String filePath = o.toString();
            filePath = filePath.substring(1, filePath.length() - 1);
            File file = new File(filePath);

            if (filePath.endsWith(".json")||filePath.endsWith(".lang")) {
                AddTable.addTable(comp,file);
                return true;
            }
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
        for (DataFlavor flavor : transferFlavors) {
            if (DataFlavor.javaFileListFlavor.equals(flavor)) {
                return true;
            }
        }
        return false;
    }
}

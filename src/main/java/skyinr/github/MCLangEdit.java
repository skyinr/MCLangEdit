package skyinr.github;

import skyinr.github.event.CopyField;

import javax.swing.*;

public class MCLangEdit {
    public static JFrame jFrame;
    public static JScrollPane jScrollPane;
    public static JPanel jPanel;
    public static void main(String[] args) {
        jFrame = new JFrame("MCLangEdit");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel = new JPanel();
        jPanel.setTransferHandler(new CopyField());

        jFrame.add(jPanel);

        jFrame.setSize(500, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}

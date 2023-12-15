package mapeditor;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    MapPanel mapPanel;
    OperatingPanel operatingPanel;
    public Window(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mapPanel = new MapPanel();
        add(BorderLayout.CENTER, mapPanel);

        operatingPanel = new OperatingPanel(mapPanel);
        add(BorderLayout.EAST, operatingPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

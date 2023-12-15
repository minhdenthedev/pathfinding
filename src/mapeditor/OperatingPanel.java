package mapeditor;

import mapeditor.inputs.buttons.CreateNodeListener;
import mapeditor.inputs.buttons.SaveDistanceListener;

import javax.swing.*;
import java.awt.*;

public class OperatingPanel extends JPanel {
    JButton createBtn, saveBtn, saveDisBtn;
    public JTextField distanceTf, locationTf;
    static JLabel l1 = new JLabel("Set the distance between 2 selected nodes:");
    static JLabel l2 = new JLabel("Enter name of new node:");
    public static JLabel[] activeLabels = new JLabel[2];
    public static JLabel[] activeCoordinates = new JLabel[2];
    MapPanel mapPanel;
    private static Node[] activeNodes = new Node[2];


    public OperatingPanel(MapPanel mapPanel) {
        this.mapPanel = mapPanel;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < activeNodes.length; i++) {
            activeLabels[i] = new JLabel("Active node:");
            add(activeLabels[i]);

            activeCoordinates[i] = new JLabel("Coordinate of node:");
            add(activeCoordinates[i]);

            add(new Box.Filler(new Dimension(0, 50),
                    new Dimension(0, 50), new Dimension(0, 50)));
        }

        add(l1);
        distanceTf = new JTextField();
        add(distanceTf);

        saveDisBtn = new JButton("Save distance");
        saveDisBtn.addActionListener(new SaveDistanceListener(this));
        add(saveDisBtn);


        add(l2);
        locationTf = new JTextField();
        add(locationTf);

        createBtn = new JButton("Create node");
        createBtn.addActionListener(new CreateNodeListener(mapPanel, this));
        add(createBtn);

        saveBtn = new JButton("Save node");
        add(saveBtn);
    }

    public boolean isMaxActive() {
        return activeNodes[0] != null && activeNodes[1] != null;
    }

    public boolean isNoneActive() {
        return activeNodes[0] == null && activeNodes[1] == null;
    }

    public void addActiveNode(Node node) {
        if (isMaxActive()) return;
        if (activeNodes[0] == null) {
            activeNodes[0] = node;

            activeLabels[0].setText("Selected node 1: " + node.name);

            activeCoordinates[0].setText("Coordinate of node 1: " + node.x + ", " + node.y);


        } else {
            activeNodes[1] = node;

            activeLabels[1].setText("Selected node 2: " + node.name);

            activeCoordinates[1].setText("Coordinate of node 2: " + node.x + ", " + node.y);

            add(new Box.Filler(new Dimension(0, 50),
                    new Dimension(0, 50), new Dimension(0, 50)));
        }

    }

    public Node removeActiveNode(Node node) {
        if (isNoneActive()) return null;

        int i = 0;
        while (i < activeNodes.length) {
            if (activeNodes[i] == null) {
                i++;
                continue;
            }
            if (activeNodes[i].equals(node)) {
                activeNodes[i] = null;
                activeLabels[i].setText("Select node:");
                activeCoordinates[i].setText("Coordinate of node:");

                return node;
            }

            i++;
        }
        return null;
    }

    public Node getActiveNode(int i) {
        return activeNodes[i];
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 600);
    }
}

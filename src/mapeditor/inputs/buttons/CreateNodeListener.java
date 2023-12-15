package mapeditor.inputs.buttons;

import mapeditor.MapPanel;
import mapeditor.Node;
import mapeditor.OperatingPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateNodeListener implements ActionListener {
    MapPanel mapPanel;
    OperatingPanel operatingPanel;

    public CreateNodeListener(MapPanel mapPanel, OperatingPanel operatingPanel) {
        this.mapPanel = mapPanel;
        this.operatingPanel = operatingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = operatingPanel.locationTf.getText();
        Node node = mapPanel.createNode(name);
        node.setOperatingPanel(operatingPanel);
    }
}

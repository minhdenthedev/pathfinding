package mapeditor.inputs.buttons;

import mapeditor.OperatingPanel;
import mapeditor.util.DataHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveDistanceListener implements ActionListener {
    OperatingPanel operatingPanel;

    public SaveDistanceListener(OperatingPanel operatingPanel) {
        this.operatingPanel = operatingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name1 = operatingPanel.getActiveNode(0).name;
        String name2 = operatingPanel.getActiveNode(1).name;
        String distance = operatingPanel.distanceTf.getText();

        DataHandler.addData(name1, name2, distance);
        DataHandler.addData(name2, name1, distance);
    }
}

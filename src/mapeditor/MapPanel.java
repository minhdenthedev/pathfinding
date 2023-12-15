package mapeditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;

public class MapPanel extends JPanel {
    BufferedImage map;
    final String filePath = "/map_images/map.png";
    ArrayList<Node> nodeManager;

    public MapPanel() {
        nodeManager = new ArrayList<>();
        setLayout(null);
        loadMap(filePath);
    }

    /* Load the map image;
     */
    private void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            map = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Set the preferred size for the panel
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(800, 600);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(800, 600);
    }

    public Node createNode(String name) {
        Node node = new Node(name);
        nodeManager.add(node);
        add(node);
        repaint();
        return node;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(map, 0, 0, 800, 600, null);
    }
}

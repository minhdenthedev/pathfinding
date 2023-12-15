package mapeditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Node extends JComponent {
    final Color onPressedColor = Color.BLUE;
    final Color activeColor = Color.ORANGE;
    final Color defaultColor = Color.CYAN;
    final Color indicateBorderColor = Color.YELLOW;
    Color nodeColor;
    Color borderColor = Color.BLACK;
    public int x, y;
    int screenX, screenY;
    public String name;
    public boolean isActive = false;
    OperatingPanel operatingPanel;

    public Node(String name) {
        this.name = name;
        x = y = 100;
        screenX = screenY = 100;
        nodeColor = defaultColor;

        addMouseListener(new NodeInputs());
        addMouseMotionListener(new NodeInputs());

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setToolTipText(name + ": " + x + ", " + y);

        setEnabled(true);
        setOpaque(false);

        setBounds(x, y, 50, 50);

        requestFocus();
    }

    public void setOperatingPanel(OperatingPanel operatingPanel) {
        this.operatingPanel = operatingPanel;
    }


    class NodeInputs extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {

            int deltaX = e.getXOnScreen() - screenX;
            int deltaY = e.getYOnScreen() - screenY;
            setLocation(x + deltaX, y + deltaY);
            setToolTipText(name + ": " + (x + deltaX) + ", " + (y + deltaY));

        }

        @Override
        public void mousePressed(MouseEvent e) {
            nodeColor = onPressedColor;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            nodeColor = defaultColor;
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            screenX = e.getXOnScreen();
            screenY = e.getYOnScreen();
            x = getX();
            y = getY();

            if (isActive) {
                setActive(false);
            } else {
                setActive(true);
            }

            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            borderColor = indicateBorderColor;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (isActive) {
                borderColor = activeColor;
            } else {
                borderColor = Color.BLACK;
            }
            repaint();
        }
    }

    public void setActive(boolean bool) {
        if (bool) {
            if (operatingPanel.isMaxActive()) {
                JOptionPane.showMessageDialog(operatingPanel,
                        "Maximum number of active nodes (=2)", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                isActive = true;
                borderColor = activeColor;
                operatingPanel.addActiveNode(this);

            }
        } else {
            isActive = false;
            borderColor = Color.BLACK;
            operatingPanel.removeActiveNode(this);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(nodeColor);
        g2d.fillOval(0, 0, 30, 30);
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(borderColor);
        g2d.drawOval(0, 0, 30, 30);
    }
}

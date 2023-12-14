package view;

import javax.swing.*;
import java.awt.*;

public class CoordinateAxisExample extends JFrame {

    public CoordinateAxisExample() {
        setTitle("Coordinate Axis Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel coordinatePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Lấy kích thước của JPanel
                int width = getWidth();
                int height = getHeight();

                // Vẽ trục x
                g2d.setColor(Color.BLACK);
                g2d.drawLine(0, height / 2, width, height / 2);

                // Vẽ trục y
                g2d.drawLine(width / 2, 0, width / 2, height);

                // Vẽ số trên trục x và y
                g2d.setColor(Color.BLUE);
                // Vẽ số và điểm mỗi 100 đơn vị trên trục x
                for (int i = 0; i <= width; i += 100) {
                    g2d.drawString(Integer.toString(i), i + 5, height - 5); // Đặt số phía dưới trục x
                    g2d.drawLine(i, height - 3, i, height + 3);
                }

                // Vẽ số và điểm mỗi 100 đơn vị trên trục y
                for (int i = 0; i <= height; i += 100) {
                    g2d.drawString(Integer.toString(-i), 5, i + 15); // Đặt số phía bên phải trục y
                    g2d.drawLine(-3, i, 3, i);
                }
            }
        };

        add(coordinatePanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CoordinateAxisExample());
    }
}
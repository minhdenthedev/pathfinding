package view;

import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maps extends JPanel {
    private Image backgroundImage;
    public Model model;
    public View view;
    private boolean activeFindFF = false;
    public boolean getActiveFindFF(){
        return activeFindFF;
    }
    private boolean activeFindDT = false;
    public boolean getActiveFindDT(){
        return activeFindDT;
    }
    public Maps (){
        this.setSize(300,300);
        this.setBackground(Color.RED);
        try {

            backgroundImage = new ImageIcon("F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\map.jpg").getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void paintComponent( Graphics g){
            super.paintComponents ( g );
            Graphics2D g2d = ( Graphics2D ) g;
            if (backgroundImage != null) {
                g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
            Scanner scanner;
            try {
                File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Map.csv" );
                scanner = new Scanner ( file1 );
                while ( scanner.hasNextLine ( ) ) {
                    String line = scanner.nextLine ( );
                    String[] values = line.split ( "," );
                    int x1 = Integer.parseInt ( values[ 0 ] );
                    int y1 = Integer.parseInt ( values[ 1 ] );
                    int x2 = Integer.parseInt ( values[ 2 ] );
                    int y2 = Integer.parseInt ( values[ 3 ] );
                    int weight = Integer.parseInt ( values[ 4 ] );
                    g2d.setColor(Color.darkGray);
                    g2d.setStroke(new BasicStroke(weight));
                    g2d.draw(new Line2D.Double(x1,y1,x2,y2));
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException ( ex );
            }

            try {
                Font font = new Font("Arial", Font.BOLD, 16);
                File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                scanner = new Scanner ( file1 );
                while ( scanner.hasNextLine ( ) ) {
                    String line = scanner.nextLine ( );
                    String[] values = line.split ( "," );
                    int x1 = Integer.parseInt ( values[ 4 ] );
                    int y1 = Integer.parseInt ( values[ 5 ] );
                    int x2 = Integer.parseInt ( values[ 6 ] );
                    int y2 = Integer.parseInt ( values[ 7 ] );
                    String lx1 = values[0];
                    String lx2 = values[1];
                    g2d.setColor(Color.BLUE);
                    g2d.setFont(font);
                    g2d.drawString(lx1, x1, y1);
                    g2d.drawString(lx2, x2, y2);
                    g2d.setColor(Color.WHITE);
                    g2d.drawOval ( x1,y1,2,2 );
                    g2d.drawOval ( x2,y2,2,2);
                    //System.out.println (x1+" "+y1+" "+x2+" "+y2);
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException ( ex );
            }
            model = new Model();
            if(activeFindFF){
                String start = this.view.getStart();
                String end = this.view.getEnd();
                ArrayList <String> paths = model.findDTs(start, end);
                for (int i = 0; i < paths.size() - 1; i++) {
                    String A = paths.get(i);
                    String B = paths.get(i+1);
                    try {
                        File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                        scanner = new Scanner ( file1 );
                        while ( scanner.hasNextLine ( ) ) {
                            String line = scanner.nextLine ( );
                            String[] values = line.split ( "," );
                            String A1 = values[ 0 ];
                            String B1 = values[ 1 ];
                            if ( ( A.equals ( A1 ) && B.equals ( B1 ) ) || ( A1.equals ( A ) && B1.equals ( B ) ) ) {
                                int x1 = Integer.parseInt ( values[ 4 ] );
                                int y1 = Integer.parseInt ( values[ 5 ] );
                                int x2 = Integer.parseInt ( values[ 6 ] );
                                int y2 = Integer.parseInt ( values[ 7 ] );
                                int weight = Integer.parseInt ( values[ 3 ] );
                                g2d.setColor ( Color.RED );
                                g2d.setStroke ( new BasicStroke ( weight ) );
                                g2d.draw ( new Line2D.Double ( x1 , y1 , x2 , y2 ) );
                            }
                        }
                    }catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }

            if(activeFindDT){
                String start = this.view.getStart();
                String end = this.view.getEnd();
                ArrayList <String> paths = model.findDTs(start, end);
                for (int i = 0; i < paths.size () - 1; i++) {
                    String A = paths.get( i );
                    String B = paths.get(i+1);
                    try {
                        File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                        scanner = new Scanner ( file1 );
                        while ( scanner.hasNextLine ( ) ) {
                            String line = scanner.nextLine ( );
                            String[] values = line.split ( "," );
                            String A1 = values[ 0 ];
                            String B1 = values[ 1 ];
                            if ( ( A.equals ( A1 ) && B.equals ( B1 ) ) || ( A1.equals ( A ) && B1.equals ( B ) ) ) {
                                int x1 = Integer.parseInt ( values[ 4 ] );
                                int y1 = Integer.parseInt ( values[ 5 ] );
                                int x2 = Integer.parseInt ( values[ 6 ] );
                                int y2 = Integer.parseInt ( values[ 7 ] );
                                int weight = Integer.parseInt ( values[ 3 ] );
                                g2d.setColor ( Color.BLUE );
                                g2d.setStroke ( new BasicStroke ( weight ) );
                                g2d.draw ( new Line2D.Double ( x1 , y1 , x2 , y2 ) );
                            }
                        }
                    }catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        }
            scanner.close ( );
    }
    public void onFindFFClicked() {
        this.activeFindFF = true;
    }
    public void onFindDTClicked() {
        this.activeFindDT = true;
    }
}

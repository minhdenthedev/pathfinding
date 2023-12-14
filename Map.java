package view;

import FordFulkerson.FordFulkersonDfsSolverAdjacencyList;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends JPanel {
    public Map(){
        this.setSize(500,500);
        this.setBackground(Color.RED);
    }
    protected void paintComponent( Graphics g){
        super.paintComponents ( g );
        Graphics2D g2d = ( Graphics2D ) g;
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
                //System.out.println (x1+" "+y1+" "+x2+" "+y2);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException ( ex );
        }

        try {
            File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
            scanner = new Scanner ( file1 );
            while ( scanner.hasNextLine ( ) ) {
                String line = scanner.nextLine ( );
                String[] values = line.split ( "," );
                int x1 = Integer.parseInt ( values[ 5 ] );
                int y1 = Integer.parseInt ( values[ 6 ] );
                int x2 = Integer.parseInt ( values[ 7 ] );
                int y2 = Integer.parseInt ( values[ 8 ] );
                g2d.setColor(Color.WHITE);
                g2d.drawOval ( x1,y1,2,2 );
                g2d.drawOval ( x2,y2,2,2);
                //System.out.println (x1+" "+y1+" "+x2+" "+y2);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException ( ex );
        }


        FordFulkersonDfsSolverAdjacencyList Ford ;//A->B->C->D
        for( int i = 0; i< Ford.length()-1;i++){
            String A = Ford[i];
            String B = Ford[i+1];
            try {
                File file1 = new File ( "F:\\DataStructure&Algorithms\\FinalExam\\src\\Add\\Location.csv" );
                scanner = new Scanner ( file1 );
                while ( scanner.hasNextLine ( ) ) {
                    String line = scanner.nextLine ( );
                    String[] values = line.split ( "," );
                    String A1 = values[1];
                    String B1 = values[2];
                    if((A.equals ( A1 )&&B.equals ( B1 )) ||
                            (A1.equals ( A )&&B1.equals ( B ))){
                        int x1 = Integer.parseInt ( values[ 5 ] );
                        int y1 = Integer.parseInt ( values[ 6 ] );
                        int x2 = Integer.parseInt ( values[ 7 ] );
                        int y2 = Integer.parseInt ( values[ 8 ] );
                        g2d.setColor(Color.RED);
                        g2d.drawOval ( x1,y1,2,2 );
                        g2d.drawOval ( x2,y2,2,2);
                        //System.out.println (x1+" "+y1+" "+x2+" "+y2);
                    }

                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException ( ex );
            }

        }



        scanner.close ( );
    }
    public int checkIDx(String s){
        switch (s){
            case "A": return 780; break;
            case "B": return 1070; break;
            case "C": return 780; break;
            case "D": return 780; break;
            case "E": return 780; break;
            case "F": return 780; break;
            case "G": return 780; break;
            case "H": return 780; break;
            case "I": return 780; break;
            case "K": return 780; break;
            case "L": return 780; break;
            case "M": return 780; break;
            case "O": return 780; break;
            case "P": return 780; break;
            case "Q": return 780; break;
            case "R": return 780; break;
            case "S": return 780; break;
            case "T": return 780; break;
            case "U": return 780; break;
            case "V": return 780; break;
            case "W": return 780; break;
            case "X": return 780; break;
            case "Y": return 780; break;
            case "Z": return 780; break;
            default: return 0;
        }
    }
    public int checkIDy(String s){
        switch (s){
            case "A": return 780; break;
            case "B": return 780; break;
            case "C": return 780; break;
            case "D": return 780; break;
            case "E": return 780; break;
            case "F": return 780; break;
            case "G": return 780; break;
            case "H": return 780; break;
            case "I": return 780; break;
            case "K": return 780; break;
            case "L": return 780; break;
            case "M": return 780; break;
            case "O": return 780; break;
            case "P": return 780; break;
            case "Q": return 780; break;
            case "R": return 780; break;
            case "S": return 780; break;
            case "T": return 780; break;
            case "U": return 780; break;
            case "V": return 780; break;
            case "W": return 780; break;
            case "X": return 780; break;
            case "Y": return 780; break;
            case "Z": return 780; break;
            default: return 0;
        }
    }

}

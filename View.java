package view;

import Dijkstra.AdjacentListGraph;
import controller.FindWay;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class View extends JFrame {
    private AdjacentListGraph adjacentListGraph;
    private JTextField jTextField_start;
    private JTextField jTextField_end;
    private JTextField jTextField_ans;
    private JLabel jLabel_answer;

    public View () throws HeadlessException {
        super();
        this.adjacentListGraph = new AdjacentListGraph ();
        this.init();
    }
    private void init ( ) {
        this.setTitle("Map");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo (null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Arial",Font.BOLD,20);
        //West
        JLabel jLabel_start = new JLabel("Start point");
        jLabel_start.setFont ( font );
        jTextField_start = new JTextField (  );
        jTextField_start.setFont ( font );

        JLabel jLabel_end = new JLabel("End point");
        jLabel_end.setFont ( font );
        jTextField_end = new JTextField (  );
        jTextField_end.setFont ( font );


        FindWay find_way = new FindWay (this);

        JButton jButton_find = new JButton("Find ways");
        jButton_find.setFont(font);
        jButton_find.addActionListener ( find_way );

        jLabel_answer = new JLabel (  );

        JLabel jLabel_ans = new JLabel("Answer");
        jLabel_ans.setFont ( font );
        jTextField_ans = new JTextField (  );
        jTextField_ans.setFont ( font );

        JPanel jPanel_menu = new JPanel();
        jPanel_menu.setLayout ( new GridLayout(3,1,20,20));
        jPanel_menu.add( jLabel_start);
        jPanel_menu.add(jTextField_start);
        jPanel_menu.add( jLabel_end);
        jPanel_menu.add(jTextField_end);
//        jPanel_menu.add(jLabel_ans);
//        jPanel_menu.add(jTextField_ans);
        jPanel_menu.add(jButton_find);

        Map map = new Map();

        
        this.setLayout(new BorderLayout());
        this.add ( jPanel_menu, BorderLayout.WEST );
        this.add( map,BorderLayout.CENTER);
        this.setVisible (true);
    }
//    public void find(){
//        this.FordFulkerson.
//    }

}

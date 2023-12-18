package view;

import controller.FindWay;
import model.Model;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Maps map;
    private Model model;
    private JTextField jTextField_start;
    private JTextField jTextField_end;
    private JTextArea jTextArea_findFF;
    private JTextArea jTextArea_findDT;

    private JLabel jLabel_answer;

    public View () throws HeadlessException {
        super();
        this.model = new Model ();
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

        JButton jButton_findFF = new JButton("Find ways using FF");
        jButton_findFF.setFont(font);
        jTextArea_findFF = new JTextArea (  );
        jTextArea_findFF.setFont ( font );

        JButton jButton_findDT = new JButton("Find ways using DT");
        jButton_findDT.setFont(font);
        jTextArea_findDT = new JTextArea (  );
        jTextArea_findDT.setFont ( font );

        jLabel_answer = new JLabel (  );

        JPanel jPanel_menu = new JPanel();
        jPanel_menu.setLayout ( new GridLayout(4,1,20,20));
        jPanel_menu.add( jLabel_start);
        jPanel_menu.add(jTextField_start);
        jPanel_menu.add( jLabel_end);
        jPanel_menu.add(jTextField_end);

        jPanel_menu.add(jButton_findFF);
        jPanel_menu.add(jTextArea_findFF);

        jPanel_menu.add(jButton_findDT);
        jPanel_menu.add(jTextArea_findDT);

        map = new Maps ();
        this.setLayout(new BorderLayout());
        this.add ( jPanel_menu, BorderLayout.WEST );
        this.add( map,BorderLayout.CENTER);
        this.setVisible (true);

        FindWay findWayFF = new FindWay(this);
        jButton_findFF.addActionListener ( findWayFF );

        FindWay findWayDT = new FindWay(this);
      jButton_findDT.addActionListener ( findWayDT );
    }
    public String getStart(){
        return jTextField_start.getText ();
    }
    public String getEnd(){
        return jTextField_end.getText ();
    }

    public void findDTs(){
        this.model.findDT(jTextField_start.getText (),jTextField_end.getText());
        this.jTextArea_findDT.setText(this.model.getKetquaDT ());
        this.map.onFindDTClicked ();
        repaint();
    }
    public void findFFs(){
        this.model.findFF(jTextField_start.getText (),jTextField_end.getText());
        this.jTextArea_findFF.setText(this.model.getKetquaFF ());
        this.map.onFindFFClicked ();
        repaint();
    }

}

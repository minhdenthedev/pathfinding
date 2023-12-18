package controller;

import view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindWay implements ActionListener {
    private View view;

    public FindWay ( View view ) {
        super();
        this.view = view;
    }

    @Override
    public void actionPerformed ( ActionEvent e ) {
        String button = e.getActionCommand ();
        if(button.equals("Find ways using DT")) {
            this.view.findDTs();
        } else if (button.equals("Find ways using FF")) {
            this.view.findFFs();
        }
    }
}

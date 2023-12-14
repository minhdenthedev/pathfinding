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
//        this.view.find();
    }
}

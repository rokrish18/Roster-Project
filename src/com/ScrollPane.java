package com;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ScrollPane extends JPanel implements Observer {
	protected JTable rosterTable;

    public ScrollPane() {
    	
    	setLayout(new BorderLayout());
    	Dimension dimensions = new Dimension();
    	double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    	double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    	dimensions.setSize(width / 1.5, height / 1.5);
		setPreferredSize(dimensions);
		
		Dimension scPane = new Dimension();
		scPane.setSize(width, height);
    	setSize(scPane);
		
    	this.rosterTable = new JTable();
    	JScrollPane scrollPane = new JScrollPane(rosterTable);
    	scrollPane.setSize(scPane);
    	add(scrollPane);
    	
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	String[][] rosterData = ((Repository)o).getRosterData();
    	String[] rosterHeaders = ((Repository)o).getHeadings();
    	this.rosterTable.setModel(new DefaultTableModel(rosterData, rosterHeaders));
    	rosterTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
}


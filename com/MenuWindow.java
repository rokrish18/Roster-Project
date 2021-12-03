package com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.awt.*;

import javax.swing.*;

//import com.sun.media.sound.Toolkit;


public class MenuWindow extends JFrame {
	protected static Repository re;
	public MenuWindow() {
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		Dimension di = new Dimension();
		di.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2, Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 );
		setPreferredSize(di);
		
		JMenuItem rosterLoad = new JMenuItem("Load Roster");
		JMenuItem addAttendance = new JMenuItem("Add Attendance");
        JMenuItem saveRoster = new JMenuItem("Save");
        JMenuItem plotData = new JMenuItem("Plot Data");
		
		JMenu f = new JMenu("File");
		f.add(rosterLoad);
		f.add(addAttendance);
        f.add(saveRoster);
        f.add(plotData);
		
		JMenuItem ab = new JMenuItem("About");
		
		JMenuBar jb = new JMenuBar();
		
		jb.add(f);
		jb.add(ab);
		
		add(jb);
		setJMenuBar(jb);
		
		setTitle("CSE63 Assignment 05");
		Panel pl = new Panel();
		add(pl, BorderLayout.CENTER);
	        
	        // Repository
	        re = new Repository();
	        re.addObserver(pl);
		rosterLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String filePath = RosterController.getFilePath();
				if(filePath != null)
				{
					RosterController.prepareTable(filePath);
				}
			}
		});
		
		 addAttendance.addActionListener(new ActionListener() {
	        	@Override
				public void actionPerformed(ActionEvent e) {
	        		if(Repository.studentRoster != null) {		// Check if roster has been loaded
			        	String inputFilepath = RosterController.getFilePath();
			        	if(inputFilepath != null) {		// Check if file could be found
			        		RosterController.displayDatePicker(inputFilepath);
			        	}
	        		}
	        		else {
	        			RosterController.displayEmptyRosterError();		// Display error if roster has not been loaded yet
	        		}
	        	}
	        });
	        
	        saveRoster.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	            	if(Repository.studentRoster != null) {		// Check if roster has been loaded
	        			String inputFilepath = RosterController.getSavePath();
	        			if(inputFilepath != null) {		// Check if file could be found
	        				RosterController.saveTable(inputFilepath);
	        			}
	        		}
	        		else {
	        			RosterController.displayEmptyRosterError();
	        		}
	            }
	        });
	        
	        plotData.addActionListener(new ActionListener() {
	        	@Override
	            public void actionPerformed(ActionEvent e)
	            {
	        		if(Repository.studentRoster != null) {		// Check if roster has been loaded
	        			RosterController.displayScatterPlot();
	        		}
	        		else {
	        			RosterController.displayEmptyRosterError();
	        		}
	            }
	        });
	        
	        ab.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	                RosterController.displayAboutTab();
	            }
	        });
	
	}
}
	
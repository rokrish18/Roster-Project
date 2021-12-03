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
        JMenuItem saveRoster = new JMenuItem("Save Data");
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
		
		setTitle("CSE 563 Assignment 05");
		ScrollPane pl = new ScrollPane();
		add(pl, BorderLayout.CENTER);
	        
	        // Repository
	        re = new Repository();
	        re.addObserver(pl);
		rosterLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String filePath = AttendanceRosterController.getFilePath();
				if(filePath != null)
				{
					AttendanceRosterController.prepareTable(filePath);
				}
			}
		});
		
		 addAttendance.addActionListener(new ActionListener() {
	        	@Override
				public void actionPerformed(ActionEvent e) {
	        		if(Repository.studentRoster != null) {		
			        	String inputFilepath = AttendanceRosterController.getFilePath();
			        	if(inputFilepath != null) {		
			        		AttendanceRosterController.displayDatePicker(inputFilepath);
			        	}
	        		}
	        		else {
	        			AttendanceRosterController.displayEmptyRosterError();	//Display the popup error message if the roster is not loaded	
	        		}
	        	}
	        });
	        
	        saveRoster.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	            	if(Repository.studentRoster != null) {		// Check if the roster is loaded or not
	        			String inputFilepath = AttendanceRosterController.getSavePath();
	        			if(inputFilepath != null) {		
	        				AttendanceRosterController.saveTable(inputFilepath);
	        			}
	        		}
	        		else {
	        			AttendanceRosterController.displayEmptyRosterError();
	        		}
	            }
	        });
	        
	        plotData.addActionListener(new ActionListener() {
	        	@Override
	            public void actionPerformed(ActionEvent e)
	            {
	        		if(Repository.studentRoster != null) {		// Check if the roster is loaded for plot data or not
	        			AttendanceRosterController.displayScatterPlot(); //Display the plot data
	        		}
	        		else {
	        			AttendanceRosterController.displayEmptyRosterError(); //
	        		}
	            }
	        });
	        
	        ab.addActionListener(new ActionListener()
	        {
	            @Override
	            public void actionPerformed(ActionEvent e)
	            {
	            	AttendanceRosterController.displayAboutTab();
	            }
	        });
	
	}
}
	
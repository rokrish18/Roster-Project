package com;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Panel extends JPanel implements Observer {
	protected JTable table;

	/**s
	 * Constructor for Panel class.
	 * Adds a scroll pane with a JTable inside of it to the JPanel
	 */
    public Panel() {
    	
    	setLayout(new BorderLayout());
    	
    	Dimension di = new Dimension();
		di.setSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 1.5, Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 1.5);
		setPreferredSize(di);
		
		Dimension sc = new Dimension();
		sc.setSize(Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
    	setSize(sc);
		
		
    	this.table = new JTable();
    	JScrollPane scrollPane = new JScrollPane(table);
    	scrollPane.setSize(sc);
    	add(scrollPane);
    	
    }
    
    
    /**
     * Sets the value of the drawable object and repaints the JPanel
     * @param o Observable object that notified this plotPanel observer
     * @param arg Object passed by notifyObservers() 
     */
    @Override
    public void update(Observable o, Object arg) {
    	String[][] data = ((Repository)o).getRosterData();
    	String[] headers = ((Repository)o).getHeadings();
    	//System.out.println(Arrays.toString(Repository.headers.toArray()));
    	//System.out.print(headers);
    	for(String[] arr : data) {
    		System.out.println(Arrays.toString(arr));
    	}
    	this.table.setModel(new DefaultTableModel(data, headers));
    	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }
}


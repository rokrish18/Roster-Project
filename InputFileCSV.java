package com;
import java.awt.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
@SuppressWarnings("serial")
public class InputFileCSV extends JFileChooser {
	JFileChooser ch = new JFileChooser();
	FileNameExtensionFilter fe = new FileNameExtensionFilter("CSV Files", "csv");
	Dimension di = new Dimension();
	
	public InputFileCSV() {
		ch.setFileFilter(fe);
		ch.setBackground(Color.gray);
		ch.setForeground(Color.black);
		di.setSize(
                Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2,
                Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
        ch.setPreferredSize(di);
	}
	
	public File getFileInput() {
		File inputFile = null;
		
		int ret = 0;
		ret = ch.showOpenDialog(getParent());
		inputFile = ch.getSelectedFile();
		if(ret == JFileChooser.APPROVE_OPTION) {
			String fileName = inputFile.getName();
            if (!fileName.substring(fileName.lastIndexOf('.')).equals(".csv")) {
                inputFile = null;
            }
            
		}else {
			inputFile = null;
		}
		return inputFile;
	}
	
}

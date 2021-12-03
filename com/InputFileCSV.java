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
	
    /**
     * Allows user to choose where/which file to save to by displaying a save file dialogue
     *
     * @return File chosen by user
     */
    public File getSaveFile() {
        File file;
        int returnVal = ch.showSaveDialog(getParent());
        file = ch.getSelectedFile();

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            file = null;
        }

        // check for extension tag in save file
        if (file.getName().indexOf('.') == -1) {
            // no extension
            file = new File(file.toString() + ".csv");
        } else if (!file.getName()
                .substring(file.getName().indexOf('.'))
                .equalsIgnoreCase(".csv")) {
            // file extension is not a .csv file but has an extension
            file = null;
        } else {
            // file extension is good
        }

        return file;
    }
	
}

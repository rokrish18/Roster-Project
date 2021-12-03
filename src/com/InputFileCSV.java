package com;
import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")

public class InputFileCSV extends JFileChooser {
	JFileChooser chooser = new JFileChooser();
	Dimension dimension = new Dimension();
	FileNameExtensionFilter extension = new FileNameExtensionFilter("CSV Files", "csv");
	
	public File getFileInput() {
		File inputFile = null;
		
		int returnValue = 0;
		
		returnValue = chooser.showOpenDialog(getParent());
		inputFile = chooser.getSelectedFile();
		
		if(returnValue == JFileChooser.APPROVE_OPTION) {
			String fileName = inputFile.getName();
            if (!fileName.substring(fileName.lastIndexOf('.')).equals(".csv")) {
                inputFile = null;
            }
		}
		else {
			inputFile = null;
		}
		return inputFile;
	}
	
    public File getSaveFile() {
        File file = chooser.getSelectedFile();
        
        int returnVal = chooser.showSaveDialog(getParent());

        if (returnVal != JFileChooser.APPROVE_OPTION) {
            file = null;
        }

        if (file.getName().indexOf('.') == -1) {
            file = new File(file.toString() + ".csv");
        } 
        else if (!file.getName().substring(file.getName().indexOf('.')).equalsIgnoreCase(".csv")) {
            file = null;
        }

        return file;
    }
    
	public InputFileCSV() {
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
		
		dimension.setSize(width, height);
		
		chooser.setFileFilter(extension);
		chooser.setPreferredSize(dimension);
	}
	
}

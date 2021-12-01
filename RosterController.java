package com;

public class RosterController {
	public static String getFilePath() {
		try {
			String filePathOut;
			InputFileCSV iFile = new InputFileCSV();
			filePathOut = iFile.getFileInput().getAbsolutePath().toString();
			return filePathOut;
		} catch(java.lang.NullPointerException e) {
		return null;
	}
  }
	
	public static void prepareTable(String filepath) {
		MenuWindow.re.loadInputFile(filepath);
	}
  
}

package com;

import java.time.LocalDate;

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
	
	/**
	 * Calls getSaveFile in CSV file chooser
	 * @return String path where the user wants to save the csv file
	 */
	public static String getSavePath() {
		try {
			return new InputFileCSV().getSaveFile().getAbsolutePath().toString();
		} catch(java.lang.NullPointerException e) {
			return null;
		}
	}

	/**
	 * Calls the save function iin Repository
	 * @param filepath path to the csv file that the current roster is being saved to
	 */
    public static void saveTable(String filepath) {
        MenuWindow.re.save(filepath);
    }
	
    /**
     * Calls the datePickerGUI from DatePicker class
     * @param filepath path to the csv file with attendance data for the date being selected
     */
	public static void displayDatePicker(String filepath) {
		// Prompt user to select date of attendance
        DatePicker calendar = new DatePicker();
        calendar.datePickerGUI(filepath);
    }
    
	/**
	 * Calls the addStudentAttendance function from Repository
	 * Calls Display to display the status/result of the added attendance
	 * @param month 
	 * @param day 
	 * @param year
	 * @param filepath path to the csv file with attendance data for the date selected
	 */
    public static void saveDate(int month, int day, int year, String filepath) {
    	// Save date and time from file into attendance data
    	LocalDate date = LocalDate.of(year,  month, day);
    	MenuWindow.re.addStudentAttendance(date, filepath);

    	// Display JDialog with added info
    	Display dis = new Display();
    	dis.displayAttendanceResult(Repository.additionalStudents, Repository.studentsAdded);
    }
    
    /**
     * Calls the Display to display an error when the roster has not been loaded before save, add attendance, and plot data are called
     */
    public static void displayEmptyRosterError() {
    	// Display error for when the roster has not been loaded
    	Display dis = new Display();
    	dis.emptyRosterErrorHandler();
    }
    
    /**
     * Displays the scatter plot GUI
     */
    public static void displayScatterPlot() {
    	ScatterPlot.scatterPlotGUI();
    } 
    
    /**
     * Displays the About dialogue box
     */
    public static void displayAboutTab() {
        Display dis = new Display();
        dis.displayTeamInfo();
    }

}

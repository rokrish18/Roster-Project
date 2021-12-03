package com;

import java.time.LocalDate;

public class AttendanceRosterController {
	public static String getFilePath() {
		try {
			String fileOutputPath;
			InputFileCSV inputFile = new InputFileCSV();
			fileOutputPath = inputFile.getFileInput().getAbsolutePath().toString();
			return fileOutputPath;
		} catch(java.lang.NullPointerException e) {
		return null;
	}
  }
	
	public static void prepareTable(String filepath) {
		MenuWindow.re.loadInputFile(filepath);
	}
	
	public static String getSavePath() {
		try {
			return new InputFileCSV().getSaveFile().getAbsolutePath().toString();
		} catch(java.lang.NullPointerException e) {
			return null;
		}
	}

    public static void saveTable(String filepath) {
        MenuWindow.re.save(filepath);
    }
	
	public static void displayDatePicker(String filepath) {
        DatePicker calendar = new DatePicker();
        calendar.datePickerGUI(filepath);
    }

    public static void saveDate(int month, int day, int year, String filepath) {
    	LocalDate date = LocalDate.of(year,  month, day);
    	MenuWindow.re.addStudentAttendance(date, filepath);
    	Display dis = new Display();
    	dis.displayAttendanceResult(Repository.additionalStudents, Repository.studentsAdded);
    }
    
    public static void displayEmptyRosterError() {
    	Display display = new Display();
    	display.emptyRosterErrorHandler();
    }
    
    public static void displayScatterPlot() {
    	ScatterPlot.scatterPlotGUI();
    } 
    
    public static void displayAboutTab() {
        Display display = new Display();
        display.displayTeamInfo();
    }

}

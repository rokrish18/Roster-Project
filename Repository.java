package com;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
@SuppressWarnings("deprecation")
public class Repository extends Observable {
	
    public static List<Student> studentRoster;
    public static List<String> headings;
    public static int studentsAdded = 0;
    public static LinkedHashMap<String, Integer> additionalStudents;
    public static List<LocalDate> attendenceDates;

    public static final String sep = ",";
    public static final int totHeadings = 6;
    
    public Repository() {
        headings = new ArrayList();
        headings.add("ID");
        headings.add("First Name");
        headings.add("Last Name");
        headings.add("Major");
        headings.add("Level");
        headings.add("ASURITE ID");
        additionalStudents = new LinkedHashMap();
        attendenceDates = new ArrayList<LocalDate>();
    }
    public void loadInputFile(String inpCSVfile) {
    	headings = headings.subList(0, totHeadings);
    	this.readInputFile(inpCSVfile);
    	setChanged();
    	notifyObservers();
    }
    public void readInputFile(String fileCSV) {
    	List<Student> studentDet = new ArrayList();
    	try {
            File f = new File(fileCSV);
            BufferedReader br = new BufferedReader(new FileReader(f));

            String l = "";
            String[] stRec;
            
            l = br.readLine();
            stRec = l.split(sep);
            if (stRec[0].equals("ID")) {
                for (int i = headings.size(); i < stRec.length; i++) {
                    headings.add(stRec[i]);
                }
            } else {
                studentDet.add(createStudentRec(stRec));
            }

            while ((l = br.readLine()) != null) {
                stRec = l.split(sep);
                studentDet.add(createStudentRec(stRec));
            }
            br.close();
    	}catch(IOException ioe){
    		ioe.printStackTrace();
    	}
    	studentRoster = studentDet;
    }
    
    public Student createStudentRec(String[] StRec) {
        String ID = StRec[0];
        String firstName = StRec[1];
        String lastName = StRec[2];
        String major = StRec[3];
        String level = StRec[4];
        String ASURITE_ID = StRec[5];

        Student stud = new Student(ID, firstName, lastName, major, level, ASURITE_ID);
        for (int i = totHeadings; i < StRec.length; i++) {
            stud.addAttendence(LocalDate.parse(headings.get(i)), Integer.parseInt(StRec[i]));
        }

        return stud;
    }
    
    public String[][] getRosterData() {

        String[][] tableData = new String[studentRoster.size()][];

        for (int i = 0; i < studentRoster.size(); i++) {
            String[] stRec = new String[headings.size()];
            stRec[0] = studentRoster.get(i).getID();
            stRec[1] = studentRoster.get(i).getFirstName();
            stRec[2] = studentRoster.get(i).getLastName();
            stRec[3] = studentRoster.get(i).getMajor();
            stRec[4] = studentRoster.get(i).getLevel();
            stRec[5] = studentRoster.get(i).getASURITE_ID();

            int studentIndex = totHeadings;
            for (Map.Entry<LocalDate, Integer> e : studentRoster.get(i).getAttendence().entrySet()) {
                stRec[studentIndex] = Integer.toString(e.getValue());
                studentIndex++;
            }

            tableData[i] = stRec;
        }

        return tableData;
    }
    
    public String[] getHeadings() {

        String[] headersArr = new String[headings.size()];
        int i = 0;
        for (String s : headings) {
            headersArr[i] = s;
            i++;
        }
        return headersArr;
    }

}

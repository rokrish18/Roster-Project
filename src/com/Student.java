package com;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Student {
	private String ID;
    private String FirstName;
    private String LastName;
    private String Major;
    private String Level;
    private String ASURITE_ID;
    
    private HashMap<LocalDate, Integer> attendence;
    
    public Student(
            String ID,
            String firstName,
            String lastName,
            String major,
            String level,
            String ASURITE_ID) {
        this.ID = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Major = major;
        this.Level = level;
        this.ASURITE_ID = ASURITE_ID;
        this.attendence = new LinkedHashMap();
    }

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		this.FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		this.LastName = lastName;
	}

	public String getMajor() {
		return Major;
	}

	public void setMajor(String major) {
		this.Major = major;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		this.Level = level;
	}

	public String getASURITE_ID() {
		return ASURITE_ID;
	}

	public void setASURITE_ID(String ASURITE_ID) {
		this.ASURITE_ID = ASURITE_ID;
	}

	public HashMap<LocalDate, Integer> getAttendence() {
		return new LinkedHashMap(attendence);
	}

	public void setAttendence(HashMap<LocalDate, Integer> attendence) {
		this.attendence = attendence;
	}

    public void addAttendence(LocalDate date, int time) {
        attendence.put(date, attendence.getOrDefault(date, 0) + time);
    }

    public int getAttendenceDate(LocalDate date) {
        return attendence.get(date);
    }
   
    
    
}

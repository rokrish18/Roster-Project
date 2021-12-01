package com;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Student {
	private String ID;
    private String firstName;
    private String lastName;
    private String major;
    private String level;
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.level = level;
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
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

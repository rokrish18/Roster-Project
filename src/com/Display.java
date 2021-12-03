package com;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Display {
	
	public void displayTeamInfo() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JDialog dialog = new JDialog(frame, "About");
		
        String teamInfo = "<html> <style>html {word-wrap: break-word} html {text-align: left}</style>" +
                "<h1>CSE-563 Group 4</h1>"
        				+ "<br>"
                        + "<h3>The Team:</h3>"
        				+ "<br>"
        				+ "<h3>1. Abhishri Medewar</h3>"
        				+ "<br>"
        				+ "<h3>2. Roshan Gowrishankar Krishna</h3>"
        				+ "<br>"
        				+ "<h3>3. Sai Tejaswi Indlamudi</h3>"
        				+ "<br>"
        				+ "<h3>4. Venkat Natarajan Raghavendra</h3>"
        				+ "<br>"
                        + "</html>";
        
        JLabel teamInfoText = new JLabel(teamInfo);

        panel.add(teamInfoText);
        dialog.add(panel);
        dialog.setSize(850, 400);
        dialog.setVisible(true);
    }

    public void displayAttendanceResult(LinkedHashMap<String, Integer> extraParticipants, int studentsAdded) {
        JFrame frame = new JFrame();
        JDialog dialog = new JDialog(frame, "Add Attendance Results");
        
        String loadedMessageText = "Attendance for " + studentsAdded + " students has been loaded.";
        String additionalMessageText =  "<html>" + extraParticipants.size()  + " additional attendee(s) was found:<br>";
        
        JPanel panel = new JPanel();
        JLabel loadedMessage = new JLabel(loadedMessageText);
        JLabel additionalMessage = new JLabel(additionalMessageText);

        panel.setLayout(new FlowLayout());
        panel.add(loadedMessage);
        panel.add(additionalMessage);

        String attendeeMessage = "";

        if (!extraParticipants.isEmpty()) {
            for (Map.Entry<String, Integer> e : extraParticipants.entrySet()) {
                attendeeMessage = "<html>" + e.getKey() + ", connected for " + e.getValue() + " minute(s)" + "<br></br>";
                JLabel additionalLabel = new JLabel(attendeeMessage);
                panel.add(additionalLabel);
            }
        }

        dialog.add(new JScrollPane(panel));
        dialog.setSize(650, 420);
        dialog.setVisible(true);
        
        Repository.additionalStudents.clear();
        Repository.studentsAdded = 0;
    }
    
    public void emptyRosterErrorHandler() {
        JFrame newJFrame = new JFrame();
        JDialog newDialog = new JDialog(newJFrame, "Error");
        JPanel newJPanel = new JPanel();
        JLabel errorMessage = new JLabel("ERROR: Please Load the Roster first");

        newJPanel.add(errorMessage);
        newDialog.add(newJPanel);

        newDialog.setSize(270, 85);
        newDialog.setVisible(true);
    }
}

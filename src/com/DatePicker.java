package com;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatePicker {

    public void datePickerGUI(String filepath) {

        JLabel dateLabel = new JLabel("Date of attendance:");
        JFrame dateFrame = new JFrame("Attendance Date");
        JPanel datePanel = new JPanel();
        JButton dateButton = new JButton("Ok");
        dateFrame.setBounds(300, 300, 300, 150);
        JXDatePicker datePicker = new JXDatePicker();
        datePicker.setDate(Calendar.getInstance().getTime());
        datePicker.setFormats(new SimpleDateFormat("MM/dd/yyyy"));
        datePanel.add(dateLabel);
        datePanel.add(datePicker);
        datePanel.add(dateButton);
        dateFrame.getContentPane().add(datePanel);
        dateFrame.setVisible(true);
        dateButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Date dateSelected = datePicker.getDate();
                        int selectedDay = dateSelected.getDate();
                        int selectedYear = dateSelected.getYear() + 1900;
                        int selectedMonth = dateSelected.getMonth() + 1;
                        AttendanceRosterController.saveDate(selectedMonth, selectedDay, selectedYear, filepath);
                        dateFrame.dispose();
                    }
                });
    }
}

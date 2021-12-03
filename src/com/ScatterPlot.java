package com;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.PublicCloneable;

public class ScatterPlot extends JFrame {

    private XYDataset createDataset() {
        List<LocalDate> dates = new ArrayList<LocalDate>();

        for (int i = 6; i < Repository.headings.size(); i++) {
            dates.add(LocalDate.parse(Repository.headings.get(i)));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();

        for (LocalDate date : dates) {
            List<Double> xAxis = MenuWindow.re.getDataSet(date);
            XYSeries classData = new XYSeries(date.toString());

            for (int i = 0; i < xAxis.size(); i++) {
                int percentage = xAxis.get(i).intValue();
                int count = 1;

                for (int j = i + 1; j < xAxis.size(); j++) {
                    if (percentage == xAxis.get(j).intValue()) {
                    	xAxis.remove(j);
                        j--;
                        count++;
                    }
                }
                classData.add(percentage, count);
            }
            dataset.addSeries(classData);
        }

        return dataset;
    }
    
    public ScatterPlot(String title) {
        super(title);

        XYDataset dataset = createDataset();

        JFreeChart chart = ChartFactory.createScatterPlot("Attendance", "Attendance Percentage", "Count", dataset);

        XYPlot plot = (XYPlot) chart.getPlot();

        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        domain.setRange(-5, 105);
        domain.setTickUnit(new NumberTickUnit(10));
        domain.setVerticalTickLabels(true);

        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(0, Repository.studentRoster.size() + 0.5);
        range.setTickUnit(new NumberTickUnit(1));
        range.setVerticalTickLabels(true);
        
        plot.setBackgroundPaint(new Color(240, 240, 240));

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }

    public static void scatterPlotGUI() {
        SwingUtilities.invokeLater(() -> {
                    ScatterPlot sp = new ScatterPlot("Plot of Attendance Data");
                    sp.setLocationRelativeTo(null);
                    sp.setSize(825, 415);
                    sp.setVisible(true);
        });
    }
}

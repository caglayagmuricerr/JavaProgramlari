package myPackage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Create a Student instance
        Student[] students = {
                new Student("John Doe", 20, "Male", "12345", "Computer Science", 0),
                new Student("Jane Doe", 21, "Female", "54321", "Computer Science", 0),
        };

        // Create and configure the GUI components
        JFrame frame = new JFrame("Student Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();

        // Create a JComboBox for selecting a student
        JComboBox<Student> studentComboBox = new JComboBox<>(students);

        // Display the selected student's information initially
        JLabel nameLabel = new JLabel("Name: " + students[0].getName());
        JLabel courseLabel = new JLabel("Course: " + students[0].getCourse());
        JLabel absenceLabel = new JLabel("Absence Days: " + students[0].getAbsenceDays());

        // Button to add absence days for the selected student
        JButton trackAbsencesButton = new JButton("Add Absence Day");
        trackAbsencesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                selectedStudent.trackAbsences();
                updateDisplay(nameLabel, courseLabel, absenceLabel, selectedStudent);
            }
        });

        // Add action listener to JComboBox to update the display when a name is selected
        studentComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                updateDisplay(nameLabel, courseLabel, absenceLabel, selectedStudent);
            }
        });

        // Add components to the panel
        panel.add(studentComboBox);
        panel.add(nameLabel);
        panel.add(courseLabel);
        panel.add(absenceLabel);
        panel.add(trackAbsencesButton);

        // Add panel to the frame
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    // Method to update the display
    private static void updateDisplay(JLabel nameLabel, JLabel courseLabel, JLabel absenceLabel, Student student) {
        nameLabel.setText("Name: " + student.getName());
        courseLabel.setText("Course: " + student.getCourse());
        absenceLabel.setText("Absence Days: " + student.getAbsenceDays());
    }
}

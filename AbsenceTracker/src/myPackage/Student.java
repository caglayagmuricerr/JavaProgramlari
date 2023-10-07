package myPackage;

public class Student extends Person{
    private String studentId;
    private String course;
    private int absenceDays;

    public Student(String name, int age, String gender, String studentId, String course, int absenceDays) {
        super(name, age, gender);
        this.studentId = studentId;
        this.course = course;
        this.absenceDays = absenceDays;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }
    public int getAbsenceDays() {
        return absenceDays;
    }

    public void trackAbsences() {
        // Validate if the number of days is non-negative
        if (this.absenceDays >= 0) {
            this.absenceDays++;
        } else {
            System.out.println("Invalid number of absence days.");
        }
    }
    
    @Override
    public String toString() {
        return this.getName(); // Overrided the toString method to display the student name in the JComboBox
    }
}

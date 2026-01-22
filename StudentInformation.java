/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgrademanagement_cabasog;

/**
 *
 * @author USER
 */
public class StudentInformation {
    private String studentName;
    private String studentID;
    private int[] subjectGrade;
    
    public StudentInformation(String studentName, String studentID, int[] subjectGrade) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.subjectGrade = subjectGrade;
    }
    
    public double calculateAverage() {
        if (subjectGrade == null || subjectGrade.length == 0) return 0;
        
        double sum = 0;
        for (int grade : subjectGrade) {
            sum += grade;
        }
        return sum / subjectGrade.length;
    }
    
    public String getRemark() {
        double average = calculateAverage();
        if (average >= 90) return "Excellent";
        if (average >= 80) return "Very Good";
        if (average >= 70) return "Good";
        if (average >= 60) return "Needs Improvement";
        return "Fail";
    }

    // Getters
    public String getStudentName() {
        return studentName;
    }

    public String getIdNumber() {
        return studentID;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10.2f %-15s", 
            studentID, studentName, calculateAverage(), getRemark());
    }
}

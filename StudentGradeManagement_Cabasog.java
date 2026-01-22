/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentgrademanagement_cabasog;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeManagement_Cabasog {

    private static boolean menu = true;
    private static Scanner scanner = new Scanner(System.in);
    public static String separatorOne = "=".repeat(50);
    public static String separatorTwo = "-".repeat(60);
    public static String programTitle = "Student Grade Management";
    
    public static void main(String[] args) {
        ArrayList<StudentInformation> students = new ArrayList<>();
        
        System.out.println(separatorOne);
        System.out.printf("%21s%s%n","Welcome to the ", programTitle);
        System.out.println(separatorOne);
        
        while (menu) {
            displayMenu();
            int choice = getChoice("Enter choice: ");
            
            switch (choice) {
                case 1:
                    addStudentInfo(students);
                    break;
                case 2:
                    viewStudentInfo(students);
                    break;
                case 3:
                    menu = false;
                    System.out.println("Exiting system. Farewell!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    public static void displayMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Exit");
    }
    
    public static int getChoice(String prompt) {
        while(true){
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e){
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }
    }
    
    public static int getValidGrade(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) return grade;
                System.out.println("Error: Grade must be 0-100.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                scanner.next();
            }
        }
    }
    
    public static void addStudentInfo(ArrayList<StudentInformation> students) {
        do {
            System.out.println("\n" + separatorTwo);
            System.out.printf("%43s%n", "===== Add a New Student =====");
            System.out.println(separatorTwo + "\n");
            
            String studentName;
            while(true) {
                System.out.printf("%-25s: ","Enter Student name");
                studentName = scanner.nextLine();
        
                if (studentName.trim().isEmpty()) {
                    System.out.println("Contact name cannot be empty. Please enter a valid name.");
                } else if (containsDigit(studentName)) {
                   System.out.println("Contact name should not contain numbers. Please enter a valid name.");
                } else {
                   break;
                }
            }
        
            System.out.printf("%-25s: ", "Enter Student ID");
            String studentID = scanner.nextLine();
        
            int[] subjectGrade = new int[3];
            for (int i = 0; i < 3; i++){
                subjectGrade[i] = getValidGrade("Enter Grade for Subject " + (i + 1) + ": ");
            }
            scanner.nextLine(); 
        
            StudentInformation newStudent = new StudentInformation(studentName, studentID, subjectGrade);
            students.add(newStudent);
            
            System.out.println("\n1. Add Another\n2. Main Menu");
            if (getChoice("Selection: ") != 1) break;
        } while (true);
    }
    
    public static void viewStudentInfo(ArrayList<StudentInformation> students) {
        System.out.println("\n" + separatorTwo);
        System.out.printf("%-10s %-20s %-10s %-15s%n", "ID", "Name", "Average", "Remark");
        System.out.println(separatorTwo);
        if (students.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (StudentInformation s : students) {
                System.out.println(s.toString());
            }
        }
        System.out.println(separatorTwo);
    }
    
    public static boolean containsDigit(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}

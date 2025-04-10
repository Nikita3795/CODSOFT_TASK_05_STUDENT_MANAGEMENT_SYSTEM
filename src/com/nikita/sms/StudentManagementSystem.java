package com.nikita.sms;

import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private final String FILE_NAME = "students.txt";

    // Constructor initializes student list and loads data from file
    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student Added Successfully!");
        saveStudentsToFile();
    }

    // Remove a student by Roll Number
    public void removeStudent(int rollNumber) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("✅ Student Removed Successfully!");
            saveStudentsToFile();
        } else {
            System.out.println("❌ Student Not Found!");
        }
    }

    // Search for a student
    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("🔍 Student Found:");
                student.displayStudent();
                return;
            }
        }
        System.out.println("❌ Student Not Found!");
    }

    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No Students Found!");
            return;
        }
        System.out.println("\n📋 Student List:");
        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Update student details
    public void updateStudent(int rollNumber, String newName, String newGrade) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                student.setName(newName);
                student.setGrade(newGrade);
                System.out.println("✅ Student Updated Successfully!");
                saveStudentsToFile();
                return;
            }
        }
        System.out.println("❌ Student Not Found!");
    }

    // Save students to file
    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.getRollNumber() + "," + student.getName() + "," + student.getGrade());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error Saving Students Data!");
        }
    }

    // Load students from file
    private void loadStudentsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    int rollNumber = Integer.parseInt(data[0]);
                    String name = data[1];
                    String grade = data[2];
                    students.add(new Student(name, rollNumber, grade));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error Loading Students Data!");
        }
    }
}

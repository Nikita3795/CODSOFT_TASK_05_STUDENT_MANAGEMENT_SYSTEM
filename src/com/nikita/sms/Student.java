package com.nikita.sms;

public class Student {
    private String name;
    private int rollNumber;
    private String grade;

    // ✅ Constructor (Fixes "undefined" error)
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // ✅ Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getRollNumber() { return rollNumber; }
    public void setRollNumber(int rollNumber) { this.rollNumber = rollNumber; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    // ✅ Display student details
    public void displayStudent() {
        System.out.println("📚 Student: " + name + " | Roll No: " + rollNumber + " | Grade: " + grade);
    }
}

package com.nikita.sms;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\n🔹 STUDENT MANAGEMENT SYSTEM 🔹");
            System.out.println("1️⃣ Add Student");
            System.out.println("2️⃣ Remove Student");
            System.out.println("3️⃣ Search Student");
            System.out.println("4️⃣ Display All Students");
            System.out.println("5️⃣ Update Student Details");
            System.out.println("6️⃣ Exit");
            System.out.print("👉 Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("📝 Enter Student Name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("🔢 Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    System.out.print("📊 Enter Grade: ");
                    scanner.nextLine();
                    String grade = scanner.nextLine();
                    sms.addStudent(new Student(name, rollNumber, grade));
                    break;

                case 2:
                    System.out.print("❌ Enter Roll Number to Remove: ");
                    int removeRoll = scanner.nextInt();
                    sms.removeStudent(removeRoll);
                    break;

                case 3:
                    System.out.print("🔍 Enter Roll Number to Search: ");
                    int searchRoll = scanner.nextInt();
                    sms.searchStudent(searchRoll);
                    break;

                case 4:
                    sms.displayAllStudents();
                    break;

                case 5:
                    System.out.print("✏️ Enter Roll Number to Update: ");
                    int updateRoll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("📝 Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("📊 Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    sms.updateStudent(updateRoll, newName, newGrade);
                    break;

                case 6:
                    System.out.println("🚪 Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid Choice! Try Again.");
            }
        }
    }
}

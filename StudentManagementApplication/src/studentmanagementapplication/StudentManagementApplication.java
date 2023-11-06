
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementapplication;
import java.util.Scanner;

/**
 *
 * @author shong
 */


public class StudentManagementApplication {
private static Student[] students = new Student[100];
private static int studentCount = 0;

public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

while (true) {
System.out.println("Student Management Application");
System.out.println("1. Capture a new student");
System.out.println("2. Search for a student");
System.out.println("3. Delete a student");
System.out.println("4. Print student report");
System.out.println("5. Exit application");
System.out.print("Enter your choice: ");

int choice = scanner.nextInt();
scanner.nextLine();

switch (choice) {
case 1:
captureNewStudent(scanner);
break;
case 2:
searchForStudent(scanner);
break;
case 3:
deleteStudent(scanner);
break;
case 4:
printStudentReport();
break;
case 5:
System.out.println("Exiting the application. Goodbye!");
System.exit(0);
default:
System.out.println("Invalid choice. Please enter a valid option.");
}
}
}

private static void captureNewStudent(Scanner scanner) {
System.out.print("Enter student ID: ");
int id = scanner.nextInt();
scanner.nextLine(); 

System.out.print("Enter student name: ");
String name = scanner.nextLine();

System.out.print("Enter student age: ");
int age = scanner.nextInt();
scanner.nextLine();

if (age < 16) {
System.out.print("Student is under 16. Enter a greater age: ");
age = scanner.nextInt();
scanner.nextLine(); 
}

System.out.print("Enter student email address: ");
String email = scanner.nextLine();

System.out.print("Enter student course: ");
String course = scanner.nextLine();

students[studentCount] = new Student(id, name, age, email, course);
studentCount++;

System.out.println("Student information saved successfully!");
}

private static void searchForStudent(Scanner scanner) {
System.out.print("Enter student ID to search: ");
int searchId = scanner.nextInt();

boolean found = false;
for (int i = 0; i < studentCount; i++) {
if (students[i] != null && students[i].getId() == searchId) {
System.out.println("Student found:");
System.out.println(students[i]);
found = true;
break;
}
}

if (!found) {
System.out.println("Student not found.");
}
}

private static void deleteStudent(Scanner scanner) {
System.out.print("Enter student ID to delete: ");
int deleteId = scanner.nextInt();

for (int i = 0; i < studentCount; i++) {
if (students[i] != null && students[i].getId() == deleteId) {
students[i] = null;
System.out.println("Student deleted successfully.");
return;
}
}

System.out.println("Student not found, cannot be deleted.");
}

private static void printStudentReport() {
System.out.println("Student Report:");
for (int i = 0; i < studentCount; i++) {
if (students[i] != null) {
System.out.println(students[i]);
}
}
}
}

class Student {
private int id;
private String name;
private int age;
private String email;
private String course;

public Student(int id, String name, int age, String email, String course) {
this.id = id;
this.name = name;
this.age = age;
this.email = email;
this.course = course;
}

public int getId() {
return id;
}

@Override
public String toString() {
return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Email: " + email + ", Course: " + course;
}
}

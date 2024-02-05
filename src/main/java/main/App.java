package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.LinkedHashMap;

public class App 
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        String MENU = "1) Add student, 2) List students, 3) Add course completion for student, 4) List course completions of student, 5) Calculate the average of course completions, 6) Calculate median of course completions, 7) Save students to file, 8) Load students from file, 0) End the program";
        University university = new University();
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        // int choice = -1;

        // while (choice != 0) {
        boolean exit = false;
        while (!exit) {

        System.out.println(MENU);
        if(scanner.hasNext()) {
            int i = 0;

            i = Integer.parseInt(scanner.nextLine());

            switch (i) {
                case 1:
                    System.out.println("What is the name of the student?");
                    String name = scanner.nextLine();

                    System.out.println("What is the student number of the student?");
                    String studentNumber = scanner.nextLine();

                    university.students.add(new Student(name, studentNumber));
                    break;
                case 2:
            // } else if (choice == 2) {
                    university.listStudents(false);
                    break;
            // } else if (choice == 3) {
                case 3:
                    university.listStudents(true);
                    System.out.println("Which student do you want to add course completion for?");
                    int studentIndex = Integer.parseInt(scanner.nextLine());

                    System.out.println("What is the name of the course?");
                    String course = scanner.nextLine();

                    System.out.println("What is the grade of the course?");
                    int grade = Integer.parseInt(scanner.nextLine());

                    university.students.get(studentIndex).addGrade(course, grade);
                    break;
            // } else if (choice == 4) {
                case 4:
                    university.listStudents(true);
                    System.out.println("Which student do you want to list course completions for?");
                    int stdIndex = Integer.parseInt(scanner.nextLine());

                    Student selectedStudent = university.students.get(stdIndex);
                    for (String course1 : selectedStudent.grades.keySet()) {
                        System.out.println(course1 + ": " + selectedStudent.grades.get(course1));
                    }
                    break;
            // } else if (choice == 5) {
                case 5:
                    university.listStudents(true);
                    System.out.println("Which student do you want to calculate the average for?");
                    int index = Integer.parseInt(scanner.nextLine());
                
                    Student sldStudent = university.students.get(index);
                    double average = calculator.getAverageGrade(sldStudent);

                    System.out.printf("Average is %.1f\n", average);
                    break;
            // } else if (choice == 6) {
                case 6:
                    university.listStudents(true);
                    System.out.println("Which student do you want to calculate the median for?");
                    int Ind = Integer.parseInt(scanner.nextLine());
                
                    Student chosedStudent = university.students.get(Ind);
                    double median = calculator.getMedianGrade(chosedStudent);
                    System.out.printf("Median is %.1f\n", median);
                    break;
                case 7:
                    // } else if (choice == 7) {
                    university.saveStudentsToFile("students.bin");
                    break;
            // } else if (choice == 8) {
                case 8:
                    university.loadStudentsFromFile("students.bin");
                    break;
            // } else if (choice == 0) {
                case 0:
                    System.out.println("Thank you for using the program.");
                    exit = true;
                    break;
                default:
            // } else {
                    System.out.println("Wrong input value");
                    break;

            }
        }
        }
    }
}

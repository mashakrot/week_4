package main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.io.*;


public class University {
    public List<Student> students = new ArrayList<Student>();

    public University() {}

    public void listStudents(boolean toChoose) {
        if (toChoose) {
            for (int i = 0; i < students.size(); i++) {
                System.out.printf("%d: %s\n", i, students.get(i).name);
            }

            return;
        }

        System.out.println("Students:");
        for (Student s : students) {
            System.out.printf("%s: %s\n", s.studentNumber, s.name);
        }
    }
    
    @SuppressWarnings("unchecked")
    public void saveStudentsToFile(String file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, true))) {
            out.writeObject(students);
        } catch (IOException e) { } 
    }

    @SuppressWarnings("unchecked")
    public void loadStudentsFromFile(String file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            students = (ArrayList<Student>) in.readObject();
        } catch (Exception e) { } 
    }
}

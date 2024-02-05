package main;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.LinkedHashMap;

public class Student implements java.io.Serializable{
    public String name;
    public String studentNumber;
    public LinkedHashMap<String, Integer> grades = new LinkedHashMap<String, Integer>();

    public Student(String name, String studentNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
    }
    
    public void addGrade(String course, int grade) {
        grades.put(course, grade);
    }

}

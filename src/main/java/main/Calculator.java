package main;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Calculator {
    public Calculator() { }

    public double getAverageGrade(Student s) {
        LinkedHashMap<String, Integer> grades = s.grades;
        if (grades.size() == 0) { return 0; }
        int sum = 0;

        for (int grade : grades.values()) {
            sum += grade;
        }
        
        return (double) sum / grades.size();
    }
    
    public double getMedianGrade(Student s) {
        LinkedHashMap<String, Integer> grades = s.grades;
        if (grades.size() == 0) { return 0; }

        int[] gradeArray = new int[grades.size()];
        int i = 0;

        for (int grade : grades.values()) {
            gradeArray[i] = grade;
            i++;
        }

        Arrays.sort(gradeArray);

        if (gradeArray.length % 2 == 0) {
            return (double) (gradeArray[gradeArray.length / 2] + gradeArray[gradeArray.length / 2 - 1]) / 2;
        }

        return (double) gradeArray[gradeArray.length / 2];
    }
}

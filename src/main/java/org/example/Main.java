package org.example;

import org.example.container.SubjectContainer;
import org.example.data.Course;
import org.example.data.CourseResult;
import org.example.util.SubjectComparator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SubjectContainer subjectContainer = new SubjectContainer();

        subjectContainer.addAll(Arrays.asList(
                new Course("Programowanie obiektowe", "Jan Kowalski"),
                new Course("Algorytmy i struktury danych", "Paweł Nowak"),
                new Course("Administrowanie systemami operacyjnymi", "Anna Kowalik"),
                new Course("Wstęp do informatyki", "Paweł Pawłowski"),
                new Course("Analiza matematyczna", "Marek Matematyk"),
                new Course("Algebra z geometrią", "Aleksandra Nowak"),
                new Course("Języki i paradygmaty programowania", "Mateusz Prokop"),
                new Course("Systemy operacyjne", "Monika Duda"),
                new Course("Programowanie w języku Java", "Marcin Kowal"),
                new Course("Metody obliczeniowe", "Zygmunt Stary"),
                new Course("Grafika komputerowa", "Adrianna Kaczmarek"),
                new Course("Inżynieria oprogramowania", "Tomasz Kamiński"),
                new Course("Projekt zespołowy", "Barbara Pawlak")
        ));

        int n = 10;
        List<CourseResult> top10Subjects = SubjectComparator.findTopSubjects(subjectContainer.getSubjects(), n);

        System.out.printf("Top %d przedmiotów z największą liczbą wspólnych liter: \n", n);
        for (int i = 0; i < top10Subjects.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, top10Subjects.get(i));
        }
    }
}
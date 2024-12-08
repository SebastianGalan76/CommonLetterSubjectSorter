package org.example;

import org.example.container.SubjectContainer;
import org.example.data.Subject;
import org.example.data.SubjectResult;
import org.example.util.SubjectComparator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SubjectContainer subjectContainer = new SubjectContainer();

        subjectContainer.addAll(Arrays.asList(
                new Subject("Programowanie obiektowe", "Jan Kowalski"),
                new Subject("Algorytmy i struktury danych", "Paweł Nowak"),
                new Subject("Administrowanie systemami operacyjnymi", "Anna Kowalik"),
                new Subject("Wstęp do informatyki", "Paweł Pawłowski"),
                new Subject("Analiza matematyczna", "Marek Matematyk"),
                new Subject("Algebra z geometrią", "Aleksandra Nowak"),
                new Subject("Języki i paradygmaty programowania", "Mateusz Prokop"),
                new Subject("Systemy operacyjne", "Monika Duda"),
                new Subject("Programowanie w języku Java", "Marcin Kowal"),
                new Subject("Metody obliczeniowe", "Zygmunt Stary"),
                new Subject("Grafika komputerowa", "Adrianna Kaczmarek"),
                new Subject("Inżynieria oprogramowania", "Tomasz Kamiński"),
                new Subject("Projekt zespołowy", "Barbara Pawlak")
        ));

        int n = 10;
        List<SubjectResult> top10Subjects = SubjectComparator.findTopSubjects(subjectContainer.getSubjects(), n);

        System.out.printf("Top %d przedmiotów z największą liczbą wspólnych liter: \n", n);
        for (int i = 0; i < top10Subjects.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, top10Subjects.get(i));
        }
    }
}
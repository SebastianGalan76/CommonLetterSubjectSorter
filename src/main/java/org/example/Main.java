package org.example;

import org.example.container.SubjectContainer;
import org.example.data.Subject;

import java.util.Arrays;

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
    }
}
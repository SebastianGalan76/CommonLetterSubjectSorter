package util;

import org.example.data.Subject;
import org.example.data.SubjectResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.util.SubjectComparator.findTopSubjects;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubjectComparatorTest {

    @Test
    public void findTopSubjects_nullSubjectList(){
        assertTrue(findTopSubjects(null, 10).isEmpty(), "Wynik dla pustej listy przedmiotów powinien być pusty");
    }

    @Test
    public void findTopSubjects_emptySubjectList(){
        assertTrue(findTopSubjects(new ArrayList<>(), 10).isEmpty(), "Wynik dla pustej listy przedmiotów powinien być pusty");
    }

    @Test
    public void findTopSubjects_oneSubject(){
        Subject subject = new Subject("Programowanie obiektowe", "Jan Kowalski");
        List<SubjectResult> result = findTopSubjects(List.of(subject), 10);
        assertEquals(1, result.size(), "Wynik dla jednego przedmiotu powinien mieć jeden element");

        SubjectResult topSubjectResult = result.get(0);
        assertEquals(subject.name() +" "+subject.instructor(), topSubjectResult.subject().name() +" "+topSubjectResult.subject().instructor());
    }

    @Test
    public void findTopSubjects_multipleSubjects(){
        Subject subject1 = new Subject("aaa", "aab");
        Subject subject2 = new Subject("aaa", "aaa");
        Subject subject3 = new Subject("abc", "def");

        List<SubjectResult> result = findTopSubjects(Arrays.asList(subject1, subject2, subject3), 10);
        assertEquals(3, result.size(), "Wynik dla trzech przedmiotów powinien mieć 3 elementy");

        assertEquals(3, result.get(0).commonLetters());
        assertEquals(2, result.get(1).commonLetters());
        assertEquals(0, result.get(2).commonLetters());
    }
}

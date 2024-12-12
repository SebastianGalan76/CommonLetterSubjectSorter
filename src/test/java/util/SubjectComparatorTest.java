package util;

import org.example.data.Course;
import org.example.data.CourseResult;
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
        Course course = new Course("Programowanie obiektowe", "Jan Kowalski");
        List<CourseResult> result = findTopSubjects(List.of(course), 10);
        assertEquals(1, result.size(), "Wynik dla jednego przedmiotu powinien mieć jeden element");

        CourseResult topCourseResult = result.get(0);
        assertEquals(course.name() +" "+ course.instructor(), topCourseResult.course().name() +" "+ topCourseResult.course().instructor());
    }

    @Test
    public void findTopSubjects_multipleSubjects(){
        Course course1 = new Course("aaa", "aab");
        Course course2 = new Course("aaa", "aaa");
        Course course3 = new Course("abc", "def");

        List<CourseResult> result = findTopSubjects(Arrays.asList(course1, course2, course3), 10);
        assertEquals(3, result.size(), "Wynik dla trzech przedmiotów powinien mieć 3 elementy");

        assertEquals(3, result.get(0).commonLetters());
        assertEquals(2, result.get(1).commonLetters());
        assertEquals(0, result.get(2).commonLetters());
    }
}

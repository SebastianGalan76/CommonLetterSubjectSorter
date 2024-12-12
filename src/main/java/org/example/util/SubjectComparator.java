package org.example.util;

import org.example.data.Course;
import org.example.data.CourseResult;

import java.util.ArrayList;
import java.util.List;

public class SubjectComparator {
    /**
     * Finds top N subjects based on the number of common letters
     *
     * @param courses List of Subjects to be processed
     * @param n Number of subjects to return
     * @return List of SubjectResult objects sorted in ascending order by the number of common letters
     */
    public static List<CourseResult> findTopSubjects(List<Course> courses, int n){
        List<CourseResult> results = new ArrayList<>();

        if(courses == null || courses.isEmpty() || n <= 0){
            return results;
        }

        courses.forEach(subject -> {
            int commonLetters = CommonLetterCounter.countCommonLetters(subject.name(), subject.instructor());
            results.add(new CourseResult(subject, commonLetters));
        });

        results.sort((a, b) -> Integer.compare(b.commonLetters(), a.commonLetters()));
        return results.subList(0, Math.min(n, results.size()));
    }
}

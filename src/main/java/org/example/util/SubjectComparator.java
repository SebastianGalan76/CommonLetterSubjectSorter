package org.example.util;

import org.example.data.Subject;
import org.example.data.SubjectResult;

import java.util.ArrayList;
import java.util.List;

public class SubjectComparator {
    /**
     * Finds top N subjects based on the number of common letters
     *
     * @param subjects List of Subjects to be processed
     * @param n Number of subjects to return
     * @return List of SubjectResult objects sorted in ascending order by the number of common letters
     */
    public static List<SubjectResult> findTopSubjects(List<Subject> subjects, int n){
        List<SubjectResult> results = new ArrayList<>();

        if(subjects == null || subjects.isEmpty() || n <= 0){
            return results;
        }

        subjects.forEach(subject -> {
            int commonLetters = CommonLetterCounter.countCommonLetters(subject.name(), subject.instructor());
            results.add(new SubjectResult(subject, commonLetters));
        });

        results.sort((a, b) -> Integer.compare(b.commonLetters(), a.commonLetters()));
        return results.subList(0, Math.min(n, results.size()));
    }
}

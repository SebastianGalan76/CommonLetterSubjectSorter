package org.example.container;

import org.example.data.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectContainer {
    private final List<Subject> subjects;

    public SubjectContainer(){
        subjects = new ArrayList<>();
    }

    public void addAll(List<Subject> newSubjects){
        this.subjects.addAll(newSubjects);
    }

    public List<Subject> getSubjects(){
        return subjects;
    }
}

package org.example.container;

import org.example.data.Course;

import java.util.ArrayList;
import java.util.List;

public class SubjectContainer {
    private final List<Course> courses;

    public SubjectContainer(){
        courses = new ArrayList<>();
    }

    public void addAll(List<Course> newCourses){
        this.courses.addAll(newCourses);
    }

    public List<Course> getSubjects(){
        return courses;
    }
}

package org.example.container;

import org.example.data.CourseResult;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CourseResultContainer {
    private final TreeSet<CourseResult> results;
    private final int maxSize;

    public CourseResultContainer(int maxSize){
        results = new TreeSet<>();
        this.maxSize = maxSize;
    }

    public void add(CourseResult courseResult){
        results.add(courseResult);
        if(results.size()>maxSize){
            results.pollLast();
        }
    }

    public List<CourseResult> getSortedList(){
        return new ArrayList<>(results);
    }
}

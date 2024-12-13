package org.example.data;

import java.util.Objects;

public record CourseResult(Course course, int commonLetters) implements Comparable<CourseResult>{

    @Override
    public int compareTo(CourseResult o) {
        return Integer.compare(o.commonLetters, this.commonLetters);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        CourseResult sr = (CourseResult) obj;
        return Objects.equals(this, sr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course);
    }

    @Override
    public String toString(){
        return "Common Letters: "+commonLetters+",\t Course name: "+course.name()+",\t Lecturer: "+course.lecturer();
    }
}

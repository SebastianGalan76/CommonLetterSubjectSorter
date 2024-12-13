package org.example;

import org.example.api.courses.CourseEdition;
import org.example.api.courses.Search;
import org.example.container.CourseResultContainer;
import org.example.data.Course;
import org.example.data.CourseResult;
import org.example.util.CommonLetterCounter;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CourseResultContainer courseResultContainer = new CourseResultContainer(10);

        final String termId = "24/25Z";

        //Optional query parameter for /services/courses/search endpoint
        final int num = 20;
        int start = 0;

        //Define the maximum number of iterations for the search and initialize the counter.
        //If maxSearchIteration = -1 there is no limit
        final int maxSearchIteration = 10;
        int currentSearchIteration = 0;

        Optional<Search.SearchDto> optionalSearchDto;

        //Perform paginated search until there are no more pages
        do{
            optionalSearchDto = Search.search("pl", Map.of("num", String.valueOf(num), "start", String.valueOf(start)));

            //Increment the start offset for the next search request
            start += num;

            //Increment search iteration counter
            currentSearchIteration++;

            //Can be empty when some error occur during searching for courses
            if(optionalSearchDto.isPresent()){
                List<Search.CourseDto> courseDtoList = optionalSearchDto.get().items();

                courseDtoList.forEach(courseDto -> {
                    //Fetch detailed information about the course edition
                    Optional<CourseEdition.CourseEditionDto> optionalCourseEditionDto = CourseEdition.get(
                        courseDto.id(),
                            termId,
                            Map.of("fields", "course_id|course_name|lecturers")
                    );

                    //Can be empty when there is no course edition for specified termID
                    if(optionalCourseEditionDto.isPresent()){
                        CourseEdition.CourseEditionDto courseEditionDto = optionalCourseEditionDto.get();

                        //Check if the course edition has lecturers
                        if(courseEditionDto.lecturers() != null && !courseEditionDto.lecturers().isEmpty()){
                            courseEditionDto.lecturers().forEach(lecturer -> {
                                //Create course object with name and lecturer's full name
                                Course course = new Course(courseEditionDto.courseName().pl(), lecturer.firstName() +" "+lecturer.lastName());

                                //Calculate the number of common letters between course name and lecturer's name
                                int commonLetters = CommonLetterCounter.countCommonLetters(course.name(), course.lecturer());

                                //Add course result object to the result container
                                courseResultContainer.add(new CourseResult(course, commonLetters));
                            });
                        }
                    }
                });
            }
        }while (optionalSearchDto.isPresent() && optionalSearchDto.get().nextPage() && (maxSearchIteration == -1 || currentSearchIteration < maxSearchIteration));

        printResult(courseResultContainer.getSortedList());
    }

    public static void printResult(List<CourseResult> result){
        System.out.println("Top 10 przedmiotów z największą liczbą wspólnych liter:");
        for (int i = 0; i < 10; i++) {
            if(i<result.size()){
                System.out.printf("%d. %s\n", i + 1, result.get(i));
            }
            else{
                System.out.printf("%d. ...\n", i + 1);
            }
        }
    }
}
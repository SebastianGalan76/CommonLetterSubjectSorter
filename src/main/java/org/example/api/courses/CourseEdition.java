package org.example.api.courses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.api.ApiClient;
import org.example.exception.ApiResponseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CourseEdition {
    public final static String ENDPOINT= "services/courses/course_edition";

    /**
     * Fetching details of a course edition based on the course ID and term ID
     *
     * @param courseId Required ID of the course
     * @param termId Required ID of the term
     * @param optionalParams Map of optional query params
     * @return Optional containing the parsed CourseEditionDto is successful, otherwise, an empty Optional
     */
    public static Optional<CourseEditionDto> get(String courseId, String termId, Map<String, String> optionalParams){
        Map<String, String> params = (optionalParams != null) ?
                new HashMap<>(optionalParams) :
                new HashMap<>();
        params.put("course_id", courseId);
        params.put("term_id", termId);

        try{
            return ApiClient.getInstance().get(ENDPOINT, params, CourseEditionDto.class);
        }catch (InterruptedException | IOException e){
            System.err.println("Error while fetching course edition: " + e.getMessage());
        }catch (ApiResponseException ignore){ }
        return Optional.empty();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CourseEditionDto(@JsonProperty("course_id") String id, @JsonProperty("course_name") CourseNameDto courseName, List<UserDto> lecturers){}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CourseNameDto(String pl){}
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record UserDto(@JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName){}

}

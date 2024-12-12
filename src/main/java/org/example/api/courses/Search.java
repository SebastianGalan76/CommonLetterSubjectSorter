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

public class Search {
    public final static String ENDPOINT= "services/courses/search";

    /**
     * Search for courses using specified language and optional query params
     *
     * @param lang Required language parameter
     * @param optionalParams Map of optional query params
     * @return Optional containing the parsed SearchDto is successful, otherwise, an empty Optional
     */
    public static Optional<SearchDto> search(String lang, Map<String, String> optionalParams){
        Map<String, String> params = (optionalParams != null) ?
                new HashMap<>(optionalParams) :
                new HashMap<>();
        params.put("lang", lang);

        try{
            return ApiClient.getInstance().get(ENDPOINT, params, SearchDto.class);
        }catch (InterruptedException | IOException | ApiResponseException e){
            System.err.println("Error while fetching courses: " + e.getMessage());
            return Optional.empty();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record SearchDto(List<CourseDto> items, @JsonProperty("next_page") boolean nextPage){}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record CourseDto(@JsonProperty("course_id") String id){}
}

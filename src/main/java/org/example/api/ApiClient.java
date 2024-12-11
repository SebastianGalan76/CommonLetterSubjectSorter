package org.example.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

public class ApiClient {
    private static ApiClient instance;

    final String apiUrl = "https://test.usosapi.devel.uj.edu.pl/";

    final HttpClient client;
    final ObjectMapper objectMapper;

    private ApiClient(){
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }


    /**
     * Sends GET request to API with query parameters and parse the
     * response body into a specified type.
     *
     * @param endpoint Endpoint to call from API
     * @param params Map of parameters to include in the request URL
     * @param responseType Response body type
     * @return Deserialized response object if successful, otherwise, an empty Optional
     */
    public <T> Optional<T> get(String endpoint, Map<String, String> params, Class<T> responseType) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getFinalUrl(endpoint, params)))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if(response.statusCode() == 200 && response.body() != null){
            return Optional.of(objectMapper.readValue(response.body(), responseType));
        }
        else{
            MessageResponse messageResponse = objectMapper.readValue(response.body(), MessageResponse.class);
            System.err.println("Error while fetching courses: " + messageResponse.message());
        }

        return Optional.empty();
    }

    /**
     * Returns a completed URL by appending the endpoint and query parameters to API URL
     *
     * @param endpoint Endpoint to be appended to API URL
     * @param params Map of query parameters
     * @return Final URL
     */
    private String getFinalUrl(String endpoint, Map<String, String> params){
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(apiUrl).append(endpoint);

        if(params != null && !params.isEmpty()){
            urlBuilder.append("?");

            params.forEach((k, v) -> {
                if(k != null && v != null){
                    urlBuilder.append(k).append("=").append(v).append("&");
                }
            });

            //Removes last "&" sign
            urlBuilder.setLength(urlBuilder.length() - 1);
        }

        return urlBuilder.toString();
    }

    public static ApiClient getInstance(){
        if(instance == null){
            instance = new ApiClient();
        }

        return instance;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    record MessageResponse(String message){}
}

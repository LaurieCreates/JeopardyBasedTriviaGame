package com.kenzie.app;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CustomHttpClient {


    public static String sendGET(String URLString) {

        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(URLString);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                return String.format("Get request failed: %d status code received", statusCode);
            }

        } catch (IOException | InterruptedException e) {
            e.getMessage();

        }
        assert false;
        return httpResponse.body();
    }
}
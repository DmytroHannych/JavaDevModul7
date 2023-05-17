package org.example;


import okhttp3.OkHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String IMAGE_URL = "https://http.cat/";
    HttpRequest httpRequest;
    HttpClient httpClient;
    public String getStatusImage(int code) throws URISyntaxException, IOException, InterruptedException {
        URI uri = new URI(IMAGE_URL + code);
       httpRequest = HttpRequest.newBuilder(uri)
                .GET()
                .build();
       httpClient = HttpClient.newBuilder()
               .version(HttpClient.Version.HTTP_1_1)
               .build();
        HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        int statusCode = httpResponse.statusCode();
        if (statusCode == 200){
            return String.valueOf(uri);
        } else {
            throw new RuntimeException("404");
        }
    }
}


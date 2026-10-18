package com.learn.java_version_lab.java11.exercise_8_java_http_client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class Test {

    private static final String BASE_URL =
            "https://jsonplaceholder.typicode.com/posts"; // this link returns dummy data

    private static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static void main(String[] args) throws Exception {

        // 1. GET
        System.out.println("===== GET =====");
        HttpResponse<String> getResponse = get("/1");
        printResponse(getResponse);

        // 2. POST
        System.out.println("\n===== POST =====");
        String newPost = "{"
                + "\"title\":\"Learning Java 11\","
                + "\"body\":\"Practising HttpClient\","
                + "\"userId\":1"
                + "}";

        HttpResponse<String> postResponse = post("", newPost);
        printResponse(postResponse);

        // 3. PUT
        System.out.println("\n===== PUT =====");
        String updatedPost = "{"
                + "\"id\":1,"
                + "\"title\":\"Updated Java 11\","
                + "\"body\":\"Learning HTTP methods\","
                + "\"userId\":1"
                + "}";

        HttpResponse<String> putResponse = put("/1", updatedPost);
        printResponse(putResponse);

        // 4. DELETE
        System.out.println("\n===== DELETE =====");
        HttpResponse<String> deleteResponse = delete("/1");
        printResponse(deleteResponse);

        // 5. Asynchronous GET
        System.out.println("\n===== ASYNC GET =====");

        CompletableFuture<HttpResponse<String>> future =
                getAsync("/2");

        future.thenAccept(response -> {
            System.out.println("Async status: "
                    + response.statusCode());
            System.out.println("Async body: "
                    + response.body());
        }).join();

        System.out.println("All requests completed.");
    }

    // GET request
    public static HttpResponse<String> get(String path)
            throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .GET()
                .build();

        return client.send(
                request, // passing the request to httpClient
                HttpResponse.BodyHandlers.ofString()
        );
    }

    // POST request
    public static HttpResponse<String> post(
            String path, String jsonBody) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }

    // PUT request
    public static HttpResponse<String> put(
            String path, String jsonBody) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        return client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }

    // DELETE request
    public static HttpResponse<String> delete(String path)
            throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .DELETE()
                .build();

        return client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }

    // Asynchronous GET request ************
    public static CompletableFuture<HttpResponse<String>> getAsync(
            String path) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + path))
                .GET()
                .build();

        return client.sendAsync( // this is the sendAsync method.
                request,
                HttpResponse.BodyHandlers.ofString()
        );
    }

    // Print response details
    private static void printResponse(
            HttpResponse<String> response) {

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());
    }
}

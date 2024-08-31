package com.shibing.stress;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StressTest {

    public static void getAll() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =
                HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/incident")).GET().header("Accept",
                        "application/json").build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Response Body: " + response.body());
            } else {
                System.err.println("Error: " + response.statusCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10); // 假设我们模拟10个并发用户

        for (int i = 0; i < 100; i++) { // 假设我们想要模拟100次请求
            executor.submit(StressTest::getAll);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("Stress test completed.");
    }





}

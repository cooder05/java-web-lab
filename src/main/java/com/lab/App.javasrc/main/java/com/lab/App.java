
package com.lab;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(
            System.getenv().getOrDefault("PORT", "8081")
        );

        HttpServer server = HttpServer.create(
            new InetSocketAddress("0.0.0.0", port), 0
        );

        server.createContext("/", exchange -> {
            String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                          content="width=device-width, initial-scale=1">
                    <title>Jenkins CI/CD Lab</title>
                    <style>
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: #101827;
                            color: white;
                            text-align: center;
                        }
                        main {
                            max-width: 650px;
                            margin: 100px auto;
                            padding: 35px;
                            background: #1e293b;
                            border-radius: 16px;
                        }
                        h1 { color: #38bdf8; }
                        .status {
                            color: #86efac;
                            font-weight: bold;
                        }
                    </style>
                </head>
                <body>
                    <main>
                        <h1>Java Web Application-modified</h1>
                        <p>Git + Maven + Jenkins + Docker</p>
                        <p class="status">
                            Build and deployment successful!
                        </p>
                        <p>Automated CI/CD Lab Exercise</p>
                    </main>
                </body>
                </html>
                """;

            byte[] response =
                html.getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                "Content-Type", "text/html; charset=UTF-8"
            );
            exchange.sendResponseHeaders(200, response.length);
            try (var output = exchange.getResponseBody()) {
                output.write(response);
            }
        });

        server.start();
        System.out.println("Webpage running on port " + port);
    }
}

// [START functions_health_get]
package com.anderb.gcp.functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.Objects;
import java.util.Optional;

public class HealthHttp implements HttpFunction {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        PrintWriter writer = new PrintWriter(response.getWriter());
        response.setContentType("application/json; charset=UTF-8");
        response.setStatusCode(HttpURLConnection.HTTP_OK);
        handleCORS(request, response);
        writer.write("{\"status\": \"UP\"}");
    }

    private void handleCORS(HttpRequest request, HttpResponse response) {
        Optional.ofNullable(request.getHeaders().get("Origin"))
                .map(list -> list.get(0))
                .filter(HealthHttp::isWhitelisted)
                .ifPresent(originValue -> {
                    response.appendHeader("Access-Control-Allow-Origin", originValue);
                    response.appendHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
                });
    }

    private static boolean isWhitelisted(String source) {
        Objects.requireNonNull(source);
        return source.equals("https://somesite.com") || source.equals("https://mail.google.com");
    }
}

// [END functions_health_get]
// [START functions_health_get]
package com.anderb.gcp.functions;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import java.io.PrintWriter;
import java.net.HttpURLConnection;

public class HealthHttp implements HttpFunction {
  @Override
  public void service(HttpRequest request, HttpResponse response) throws Exception {
    PrintWriter writer = new PrintWriter(response.getWriter());
    response.setStatusCode(HttpURLConnection.HTTP_OK);
    response.setContentType("application/json; charset=UTF-8");
    writer.write("{\"status\": \"UP\"}");
  }
}

// [END functions_health_get]

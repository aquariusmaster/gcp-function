# GCP functions

Links:
- https://cloud.google.com/functions/docs/first-java#gradle
- https://cloud.google.com/functions/docs/samples/functions-tips-connection-pooling#functions_tips_connection_pooling-java
- https://github.com/GoogleCloudPlatform/functions-framework-java
- https://quarkus.io/guides/gcp-functions
- https://cloud.google.com/functions/docs/concepts/java-deploy

## Run server locally
```bash
./gradlew runServer --stacktrace
```

## Deploy to GCP

Deploy from source:
```bash
gcloud functions deploy health-function \
    --entry-point com.anderb.gcp.functions.HealthHttp \
    --runtime java11 \
    --trigger-http \
    --memory 512MB \
    --allow-unauthenticated
```
Deploy from a JAR:
```bash
gcloud functions deploy health-function \
    --entry-point=com.anderb.gcp.functions.HealthHttp \
    --runtime=java11 \
    --trigger-http \
    --source=build/libs \
    --allow-unauthenticated
```
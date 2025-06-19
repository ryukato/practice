# Build stage
FROM --platform=linux/amd64 eclipse-temurin:17-jdk-alpine AS builder
ARG APP_NAME
RUN echo "APP_NAME=$APP_NAME"
COPY . .
RUN ./gradlew clean :$APP_NAME:build -x test

FROM --platform=linux/amd64 eclipse-temurin:17-jdk-alpine AS runner
ARG APP_NAME
WORKDIR /app
COPY --from=builder ./apps/$APP_NAME/build/libs/$APP_NAME.jar app.jar
RUN chmod +x /app
# PROFILE will be passed by SPRING_PROFILES_ACTIVE env var
# Additional env vars: PORT, ACTUATOR_PROT, JASYPT_ENCRYPTOR_PASSWORD
ENTRYPOINT [ "java", "-jar", "app.jar" ]

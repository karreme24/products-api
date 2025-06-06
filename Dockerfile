FROM eclipse-temurin:17-jdk-alpine
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar el JAR
COPY target/render-springboot-neon-0.0.1-SNAPSHOT.jar app.jar



ENTRYPOINT ["java", "-jar", "app.jar"]

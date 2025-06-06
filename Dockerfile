
FROM eclipse-temurin:21-alpine
WORKDIR /app

# Copiar el JAR
COPY target/render-springboot-neon-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

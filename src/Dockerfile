
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/java-web-lab-1.0.0.jar app.jar
EXPOSE 8081
ENV PORT=8081
CMD ["java", "-jar", "app.jar"]
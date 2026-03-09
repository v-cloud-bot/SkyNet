# Step 1: Use a lightweight Java 17 runtime (Eclipse Temurin)
FROM eclipse-temurin:25-jdk-jammy

# Step 2: Set the directory inside the container where commands run
WORKDIR /app

# Step 3: Copy the compiled JAR file from your local 'target' folder to the container
# Note: You must run 'mvn package' first to create this file!
COPY target/*.jar app.jar

# Step 4: Tell the container to listen on port 8080 (Google Cloud Run default
EXPOSE 8080

# Step 5: The command to start your Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
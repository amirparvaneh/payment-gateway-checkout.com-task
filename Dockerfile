# Use a base image with Java and Maven pre-installed
FROM maven:3.8.4-openjdk-18-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and project files to the container
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use a base image with Java only
FROM adoptopenjdk:18-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the previous build stage
COPY --from=build /app/target/your-application.jar .

# Expose the port your application is running on
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "your-application.jar"]
FROM openjdk:17-jdk-slim

# Update package lists, install curl, and clean up
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Metadata about the image
LABEL authors="sahil ghadage"

# Copy the application JAR file into the container
COPY target/cards-0.0.1-SNAPSHOT.jar cards-0.0.1-SNAPSHOT.jar

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "cards-0.0.1-SNAPSHOT.jar"]
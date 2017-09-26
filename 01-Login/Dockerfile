# Use JAVA image
FROM openjdk:7u121-jdk

# Change dir
WORKDIR /app

# Copy local contents to /app
COPY . /app

# Trigger a Gradle download
RUN chmod +x gradlew
RUN ./gradlew clean

# Define default command
ENTRYPOINT ["./gradlew"]
CMD ["clean", "bootRun"]

# Open 8080 in the container
EXPOSE 8080
